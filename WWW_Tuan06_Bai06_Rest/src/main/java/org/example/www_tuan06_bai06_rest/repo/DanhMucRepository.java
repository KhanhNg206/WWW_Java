package org.example.www_tuan06_bai06_rest.repo;


import org.example.www_tuan06_bai06_rest.model.DanhMuc;
import org.example.www_tuan06_bai06_rest.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhMucRepository {

    public List<DanhMuc> getAll() {

        List<DanhMuc> list = new ArrayList<>();

        String sql = """
                SELECT MADM, TENDANHMUC, NGUOIQUANLY, GHICHU
                FROM DANHMUC
                ORDER BY MADM
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                DanhMuc danhMuc = new DanhMuc(
                        rs.getInt("MADM"),
                        rs.getString("TENDANHMUC"),
                        rs.getString("NGUOIQUANLY"),
                        rs.getString("GHICHU")
                );

                list.add(danhMuc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public DanhMuc getById(int madm) {

        String sql = """
                SELECT MADM, TENDANHMUC, NGUOIQUANLY, GHICHU
                FROM DANHMUC
                WHERE MADM = ?
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, madm);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new DanhMuc(
                            rs.getInt("MADM"),
                            rs.getString("TENDANHMUC"),
                            rs.getString("NGUOIQUANLY"),
                            rs.getString("GHICHU")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insert(DanhMuc danhMuc) {

        String sql = """
                INSERT INTO DANHMUC
                (TENDANHMUC, NGUOIQUANLY, GHICHU)
                VALUES (?, ?, ?)
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, danhMuc.getTenDanhMuc());
            ps.setString(2, danhMuc.getNguoiQuanLy());
            ps.setString(3, danhMuc.getGhiChu());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(DanhMuc danhMuc) {

        String sql = """
                UPDATE DANHMUC
                SET TENDANHMUC = ?,
                    NGUOIQUANLY = ?,
                    GHICHU = ?
                WHERE MADM = ?
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, danhMuc.getTenDanhMuc());
            ps.setString(2, danhMuc.getNguoiQuanLy());
            ps.setString(3, danhMuc.getGhiChu());
            ps.setInt(4, danhMuc.getMadm());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int madm) {

        String sql = "DELETE FROM DANHMUC WHERE MADM = ?";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, madm);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}