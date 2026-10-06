package org.example.www_tuan06_bai06_rest.repo;

import org.example.www_tuan06_bai06_rest.model.TinTuc;
import org.example.www_tuan06_bai06_rest.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TinTucRepository {

    public List<TinTuc> getAll() {

        List<TinTuc> list = new ArrayList<>();

        String sql = """
                SELECT MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM
                FROM TINTUC
                ORDER BY MATT
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                TinTuc tinTuc = new TinTuc();

                tinTuc.setMatt(rs.getString("MATT"));
                tinTuc.setTieuDe(rs.getString("TIEUDE"));
                tinTuc.setNoiDungTT(rs.getString("NOIDUNGTT"));
                tinTuc.setLienKet(rs.getString("LIENKET"));
                tinTuc.setMadm(rs.getInt("MADM"));

                list.add(tinTuc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public TinTuc getById(String matt) {

        String sql = """
                SELECT MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM
                FROM TINTUC
                WHERE MATT = ?
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, matt);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new TinTuc(
                            rs.getString("MATT"),
                            rs.getString("TIEUDE"),
                            rs.getString("NOIDUNGTT"),
                            rs.getString("LIENKET"),
                            rs.getInt("MADM")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<TinTuc> getByDanhMuc(int madm) {

        List<TinTuc> list = new ArrayList<>();

        String sql = """
                SELECT MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM
                FROM TINTUC
                WHERE MADM = ?
                ORDER BY MATT
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, madm);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    list.add(new TinTuc(
                            rs.getString("MATT"),
                            rs.getString("TIEUDE"),
                            rs.getString("NOIDUNGTT"),
                            rs.getString("LIENKET"),
                            rs.getInt("MADM")
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean insert(TinTuc tinTuc) {

        String sql = """
                INSERT INTO TINTUC
                (MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
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

    public boolean update(TinTuc tinTuc) {

        String sql = """
                UPDATE TINTUC
                SET TIEUDE = ?,
                    NOIDUNGTT = ?,
                    LIENKET = ?,
                    MADM = ?
                WHERE MATT = ?
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, tinTuc.getTieuDe());
            ps.setString(2, tinTuc.getNoiDungTT());
            ps.setString(3, tinTuc.getLienKet());
            ps.setInt(4, tinTuc.getMadm());
            ps.setString(5, tinTuc.getMatt());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(String matt) {

        String sql = "DELETE FROM TINTUC WHERE MATT = ?";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, matt);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
