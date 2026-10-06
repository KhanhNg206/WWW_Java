package org.example.www_tuan06_bai05_rest.repo;


import org.example.www_tuan06_bai05_rest.model.Employee;
import org.example.www_tuan06_bai05_rest.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public List<Employee> getAll() {

        List<Employee> list = new ArrayList<>();

        String sql =
                "SELECT id, name, department_id, salary " +
                        "FROM employees";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Employee employee = new Employee();

                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setDepartmentId(
                        rs.getInt("department_id")
                );
                employee.setSalary(
                        rs.getBigDecimal("salary")
                );

                list.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Employee getById(int id) {

        String sql =
                "SELECT id, name, department_id, salary " +
                        "FROM employees WHERE id = ?";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("department_id"),
                            rs.getBigDecimal("salary")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Employee> getByDepartment(int departmentId) {

        List<Employee> list = new ArrayList<>();

        String sql =
                "SELECT id, name, department_id, salary " +
                        "FROM employees " +
                        "WHERE department_id = ?";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, departmentId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Employee employee = new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("department_id"),
                            rs.getBigDecimal("salary")
                    );

                    list.add(employee);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean insert(Employee employee) {

        String sql =
                "INSERT INTO employees " +
                        "(name, department_id, salary) " +
                        "VALUES (?, ?, ?)";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getDepartmentId());
            ps.setBigDecimal(3, employee.getSalary());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Employee employee) {

        String sql =
                "UPDATE employees " +
                        "SET name = ?, department_id = ?, salary = ? " +
                        "WHERE id = ?";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getDepartmentId());
            ps.setBigDecimal(3, employee.getSalary());
            ps.setInt(4, employee.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id) {

        String sql =
                "DELETE FROM employees WHERE id = ?";

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