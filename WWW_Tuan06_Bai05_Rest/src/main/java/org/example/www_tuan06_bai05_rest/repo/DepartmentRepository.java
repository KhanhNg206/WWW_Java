package org.example.www_tuan06_bai05_rest.repo;


import org.example.www_tuan06_bai05_rest.model.Department;
import org.example.www_tuan06_bai05_rest.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    public List<Department> getAll() {

        List<Department> list = new ArrayList<>();

        String sql = "SELECT id, name FROM departments";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Department department = new Department();

                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));

                list.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Department getById(int id) {

        String sql = "SELECT id, name FROM departments WHERE id = ?";

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

    public boolean insert(Department department) {

        String sql = "INSERT INTO departments (name) VALUES (?)";

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

    public boolean update(Department department) {

        String sql =
                "UPDATE departments SET name = ? WHERE id = ?";

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
