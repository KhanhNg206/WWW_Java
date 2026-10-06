package org.example.www_tuan06_bai06.dao;

import org.example.www_tuan06_bai06.model.TinTuc;
import org.example.www_tuan06_bai06.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhSachTinTucQuanLy {

    // Lấy tất cả tin tức
    public List<TinTuc> getAll() {

        List<TinTuc> list = new ArrayList<>();

        String sql = """
                SELECT MATT,
                       TIEUDE,
                       NOIDUNGTT,
                       LIENKET,
                       MADM
                FROM TINTUC
                ORDER BY MATT
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                TinTuc tinTuc = new TinTuc();

                tinTuc.setMatt(
                        rs.getString("MATT")
                );

                tinTuc.setTieuDe(
                        rs.getString("TIEUDE")
                );

                tinTuc.setNoiDungTT(
                        rs.getString("NOIDUNGTT")
                );

                tinTuc.setLienKet(
                        rs.getString("LIENKET")
                );

                tinTuc.setMadm(
                        rs.getInt("MADM")
                );

                list.add(tinTuc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Lấy tin tức theo danh mục
    public List<TinTuc> getByDanhMuc(int madm) {

        List<TinTuc> list = new ArrayList<>();

        String sql = """
                SELECT MATT,
                       TIEUDE,
                       NOIDUNGTT,
                       LIENKET,
                       MADM
                FROM TINTUC
                WHERE MADM = ?
                ORDER BY MATT
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, madm);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    TinTuc tinTuc = new TinTuc();

                    tinTuc.setMatt(
                            rs.getString("MATT")
                    );

                    tinTuc.setTieuDe(
                            rs.getString("TIEUDE")
                    );

                    tinTuc.setNoiDungTT(
                            rs.getString("NOIDUNGTT")
                    );

                    tinTuc.setLienKet(
                            rs.getString("LIENKET")
                    );

                    tinTuc.setMadm(
                            rs.getInt("MADM")
                    );

                    list.add(tinTuc);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Thêm tin tức
    public boolean insert(TinTuc tinTuc) {

        String sql = """
                INSERT INTO TINTUC
                    (MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, tinTuc.getMatt());
            ps.setString(2, tinTuc.getTieuDe());
            ps.setString(3, tinTuc.getNoiDungTT());
            ps.setString(4, tinTuc.getLienKet());
            ps.setInt(5, tinTuc.getMadm());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Xóa tin tức
    public boolean delete(String matt) {

        String sql =
                "DELETE FROM TINTUC WHERE MATT = ?";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, matt);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Lấy danh sách danh mục
    public List<String[]> getDanhMuc() {

        List<String[]> list = new ArrayList<>();

        String sql = """
                SELECT MADM, TENDANHMUC
                FROM DANHMUC
                ORDER BY MADM
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                list.add(
                        new String[]{
                                String.valueOf(
                                        rs.getInt("MADM")
                                ),
                                rs.getString("TENDANHMUC")
                        }
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
