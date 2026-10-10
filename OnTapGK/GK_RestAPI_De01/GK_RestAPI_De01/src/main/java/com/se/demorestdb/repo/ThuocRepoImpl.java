package com.se.demorestdb.repo;

import com.se.demorestdb.dto.ThuocDTO;
import com.se.demorestdb.model.Thuoc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ThuocRepoImpl {
    private volatile DataSource dataSource;

    private DataSource getDataSource(){
        if(dataSource == null){
            try{
                Context env = (Context)new InitialContext().lookup("java:comp/env");
                dataSource =(DataSource)env.lookup("jdbc/hrdb");
            } catch (NamingException e) {
                throw new IllegalArgumentException("Khoông tìm thấy trang",e);
            }
        }
        return dataSource;
    }

    public List<Thuoc> getAll(){
        List<Thuoc> list = new ArrayList<>();
        String sql = "select * from thuoc";
        try(
                Connection conn = getDataSource().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while(rs.next()){
                Thuoc thuoc = new Thuoc();
                thuoc.setMaThuoc(rs.getInt("MATHUOC"));
                thuoc.setTenThuoc(rs.getString("TENTHUOC"));
                thuoc.setGia(rs.getDouble("GIA"));
                thuoc.setNamSanXuat(rs.getInt("NAMSX"));
                thuoc.setMaLoai(rs.getInt("MALOAI"));
                thuoc.setNgayBatDauSuDung(rs.getDate("ngayBatDauSuDung").toLocalDate());
                thuoc.setNgayHetHanSuDung(rs.getDate("ngayHetHanSuDung").toLocalDate());
                list.add(thuoc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    //câu 1
    public List<ThuocDTO> getTheoKhoangGia(String tenLoai, Double khoangGia){
        List<ThuocDTO> list = new ArrayList<>();
        String sql = "SELECT lt.TENLOAI, t.TENTHUOC, t.GIA\n" +
                "FROM THUOC t\n" +
                "JOIN LOAITHUOC lt ON t.MALOAI = lt.MALOAI\n" +
                "WHERE (? IS NULL OR t.GIA >= ?) and lt.TENLOAI = ?\n" +
                "ORDER BY lt.TENLOAI, t.TENTHUOC;";
        try(
                Connection conn = getDataSource().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);

        ){
            if( khoangGia ==  null){
                ps.setNull(1, Types.DOUBLE);
                ps.setNull(2,Types.DOUBLE);
            }else{
                ps.setDouble(1,khoangGia);
                ps.setDouble(2,khoangGia);
            }
            ps.setString(3,tenLoai);
            try(ResultSet rs = ps.executeQuery();){
                while(rs.next()){
                    ThuocDTO thuoc = new ThuocDTO();
                    thuoc.setTenThuoc(rs.getString("TENTHUOC"));
                    thuoc.setTenLoai(rs.getString("TENLOAI"));
                    thuoc.setGia(rs.getDouble("GIA"));
                    list.add(thuoc);
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //câu 2
    public List<Thuoc> getTheoNgay(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        List<Thuoc> list = new ArrayList<>();

        String sql = "SELECT * FROM THUOC " +
                "WHERE (? IS NULL OR ngayBatDauSuDung >= ?) " +
                "AND (? IS NULL OR ngayHetHanSuDung <= ?)";

        try (
                Connection conn = getDataSource().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            if (ngayBatDau == null) {
                ps.setNull(1, java.sql.Types.DATE);
                ps.setNull(2, java.sql.Types.DATE);
            } else {
                ps.setDate(1, java.sql.Date.valueOf(ngayBatDau));
                ps.setDate(2, java.sql.Date.valueOf(ngayBatDau));
            }

            if (ngayKetThuc == null) {
                ps.setNull(3, java.sql.Types.DATE);
                ps.setNull(4, java.sql.Types.DATE);
            } else {
                ps.setDate(3, java.sql.Date.valueOf(ngayKetThuc));
                ps.setDate(4, java.sql.Date.valueOf(ngayKetThuc));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Thuoc thuoc = new Thuoc();

                    thuoc.setMaThuoc(rs.getInt("MATHUOC"));
                    thuoc.setTenThuoc(rs.getString("TENTHUOC"));
                    thuoc.setGia(rs.getDouble("GIA"));
                    thuoc.setNamSanXuat(rs.getInt("NAMSX"));
                    thuoc.setMaLoai(rs.getInt("MALOAI"));

                    java.sql.Date ngayBD = rs.getDate("ngayBatDauSuDung");
                    java.sql.Date ngayHH = rs.getDate("ngayHetHanSuDung");

                    thuoc.setNgayBatDauSuDung(ngayBD != null ? ngayBD.toLocalDate() : null);

                    thuoc.setNgayHetHanSuDung(ngayHH != null ? ngayHH.toLocalDate() : null);

                    list.add(thuoc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
