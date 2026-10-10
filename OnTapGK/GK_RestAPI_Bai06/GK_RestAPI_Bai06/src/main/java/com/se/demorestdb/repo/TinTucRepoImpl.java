package com.se.demorestdb.repo;

import com.se.demorestdb.dto.TinTucDanhMuc;
import com.se.demorestdb.model.TinTuc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TinTucRepoImpl {
    private volatile DataSource dataSource;

    private DataSource getDataSource(){
        if(dataSource == null){
            try{
                Context env = (Context)new InitialContext().lookup("java:comp/env");
                dataSource = (DataSource) env.lookup("jdbc/hrdb");
            }catch (NamingException e){
                throw new IllegalArgumentException("Không tìm thấy trang ",e);
            }
        }
        return dataSource;
    }

    public List<TinTuc> getAll(){
        List<TinTuc> listTinTuc = new ArrayList<>();
        String sql = "select * from TINTUC";
        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while (rs.next()){
                TinTuc tinTuc = new TinTuc();
                tinTuc.setMaTinTuc(rs.getString("MATT"));
                tinTuc.setNoiDung(rs.getString("NOIDUNGTT"));
                tinTuc.setTieuDe(rs.getString("TIEUDE"));
                tinTuc.setLienKet(rs.getString("LIENKET"));
                tinTuc.setMaDM(rs.getInt("MADM"));
                listTinTuc.add(tinTuc);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listTinTuc;
    }

    public List<TinTucDanhMuc> getTinTucDanhMuc(){
        List<TinTucDanhMuc> list = new ArrayList<>();
        String sql = "SELECT t.MATT, t.TIEUDE, d.TENDANHMUC \n" +
                "FROM TINTUC t \n" +
                "INNER JOIN DANHMUC d ON t.MADM = d.MADM";
        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ){
            while (rs.next()){
                TinTucDanhMuc tinTucDanhMuc = new TinTucDanhMuc();
                tinTucDanhMuc.setMaTT(rs.getString("MATT"));
                tinTucDanhMuc.setTenDanhMuc(rs.getString("TENDANHMUC"));
                tinTucDanhMuc.setTieuDe(rs.getString("TIEUDE"));
                list.add(tinTucDanhMuc);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<TinTucDanhMuc> getTinTucDanhMucByTenDM(String tenDanhMuc){
        List<TinTucDanhMuc> list = new ArrayList<>();
        String sql = "SELECT t.MATT, t.TIEUDE, d.TENDANHMUC ,t.NOIDUNGTT\n" +
                "FROM TINTUC t \n" +
                "INNER JOIN DANHMUC d ON t.MADM = d.MADM where d.tendanhmuc = ?";
        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,tenDanhMuc);
            try(ResultSet rs = ps.executeQuery();){
                while (rs.next()){
                    TinTucDanhMuc tinTucDanhMuc = new TinTucDanhMuc();
                    tinTucDanhMuc.setMaTT(rs.getString("MATT"));
                    tinTucDanhMuc.setTenDanhMuc(rs.getString("TENDANHMUC"));
                    tinTucDanhMuc.setTieuDe(rs.getString("TIEUDE"));
                    tinTucDanhMuc.setTenDanhMuc(rs.getString("NOIDUNGTT"));
                    list.add(tinTucDanhMuc);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<TinTucDanhMuc> getSoLuongTT(){
        List<TinTucDanhMuc> list = new ArrayList<>();
        String sql = "SELECT d.MADM, d.TENDANHMUC, COUNT(t.MATT) AS SOLUONG_TINTUC \n" +
                "FROM DANHMUC d \n" +
                "LEFT JOIN TINTUC t ON d.MADM = t.MADM \n" +
                "GROUP BY d.MADM, d.TENDANHMUC";

        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while(rs.next()){
                TinTucDanhMuc tinTucDanhMuc = new TinTucDanhMuc();
                tinTucDanhMuc.setMaDM(rs.getString("MADM"));
                tinTucDanhMuc.setTenDanhMuc(rs.getString("TENDANHMUC"));
                tinTucDanhMuc.setSoLuong(rs.getInt("SOLUONG_TINTUC"));
                list.add(tinTucDanhMuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<TinTucDanhMuc> getSoLuongTTLonHonHoacBangHai(){
        List<TinTucDanhMuc> list = new ArrayList<>();
        String sql = "SELECT d.MADM, d.TENDANHMUC, COUNT(t.MATT) AS SOLUONG_TINTUC \n" +
                "FROM DANHMUC d \n" +
                "LEFT JOIN TINTUC t ON d.MADM = t.MADM \n" +
                "GROUP BY d.MADM, d.TENDANHMUC having COUNT(t.MATT) >= 2";

        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                TinTucDanhMuc tinTucDanhMuc = new TinTucDanhMuc();
                tinTucDanhMuc.setMaDM(rs.getString("MADM"));
                tinTucDanhMuc.setTenDanhMuc(rs.getString("TENDANHMUC"));
                tinTucDanhMuc.setSoLuong(rs.getInt("SOLUONG_TINTUC"));
                list.add(tinTucDanhMuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<TinTucDanhMuc> getSoLongTTMax(){
        List<TinTucDanhMuc> list = new ArrayList<>();
        String sql = "SELECT d.MADM, d.TENDANHMUC, COUNT(t.MATT) AS SOLUONG_TINTUC \n" +
                "FROM DANHMUC d \n" +
                "LEFT JOIN TINTUC t ON d.MADM = t.MADM \n" +
                "GROUP BY d.MADM, d.TENDANHMUC \n" +
                "HAVING COUNT(t.MATT) = ( \n" +
                " SELECT MAX(SoLuong) \n" +
                " FROM ( \n" +
                " SELECT COUNT(t2.MATT) AS SoLuong \n" +
                " FROM DANHMUC d2 \n" +
                " LEFT JOIN TINTUC t2 ON d2.MADM = t2.MADM \n" +
                " GROUP BY d2.MADM \n" +
                " ) AS ThongKeMax);";

        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                TinTucDanhMuc tinTucDanhMuc = new TinTucDanhMuc();
                tinTucDanhMuc.setMaDM(rs.getString("MADM"));
                tinTucDanhMuc.setTenDanhMuc(rs.getString("TENDANHMUC"));
                tinTucDanhMuc.setSoLuong(rs.getInt("SOLUONG_TINTUC"));
                list.add(tinTucDanhMuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
