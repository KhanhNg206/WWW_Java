package org.example.www_tuan06_bai05.dao;

import org.example.www_tuan06_bai05.model.Department;
import org.example.www_tuan06_bai05.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    // Lấy tất cả phòng ban
    public List<Department> getAll() {

        List<Department> departments = new ArrayList<>();

        String sql = """
                SELECT id, name
                FROM departments
                ORDER BY id
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Department department =
                        new Department(
                                rs.getInt("id"),
                                rs.getString("name")
                        );

                departments.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }

    // Tìm kiếm phòng ban
    public List<Department> search(String keyword) {

        List<Department> departments = new ArrayList<>();

        String sql = """
                SELECT id, name
                FROM departments
                WHERE name LIKE ?
                ORDER BY id
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    departments.add(
                            new Department(
                                    rs.getInt("id"),
                                    rs.getString("name")
                            )
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }

    // Tìm phòng ban theo ID
    public Department getById(int id) {

        String sql = """
                SELECT id, name
                FROM departments
                WHERE id = ?
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Department(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Thêm phòng ban
    public boolean insert(Department department) {

        String sql =
                "INSERT INTO departments(name) VALUES (?)";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, department.getName());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Cập nhật phòng ban
    public boolean update(Department department) {

        String sql = """
                UPDATE departments
                SET name = ?
                WHERE id = ?
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, department.getName());
            ps.setInt(2, department.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Xóa phòng ban
    public boolean delete(int id) {

        String sql =
                "DELETE FROM departments WHERE id = ?";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}