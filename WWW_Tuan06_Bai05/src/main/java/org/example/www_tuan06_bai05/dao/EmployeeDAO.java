package org.example.www_tuan06_bai05.dao;

import org.example.www_tuan06_bai05.model.Employee;
import org.example.www_tuan06_bai05.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Lấy tất cả nhân viên
    public List<Employee> getAll() {

        List<Employee> employees = new ArrayList<>();

        String sql = """
                SELECT e.id,
                       e.name,
                       e.department_id,
                       d.name AS department_name,
                       e.salary
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.id
                ORDER BY e.id
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                employees.add(
                        mapEmployee(rs)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // Lấy nhân viên theo phòng ban
    public List<Employee> getByDepartment(int departmentId) {

        List<Employee> employees = new ArrayList<>();

        String sql = """
                SELECT e.id,
                       e.name,
                       e.department_id,
                       d.name AS department_name,
                       e.salary
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.id
                WHERE e.department_id = ?
                ORDER BY e.id
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, departmentId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    employees.add(
                            mapEmployee(rs)
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // Tìm kiếm nhân viên
    public List<Employee> search(
            String keyword,
            Integer departmentId) {

        List<Employee> employees = new ArrayList<>();

        StringBuilder sql = new StringBuilder("""
                SELECT e.id,
                       e.name,
                       e.department_id,
                       d.name AS department_name,
                       e.salary
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.id
                WHERE e.name LIKE ?
                """);

        if (departmentId != null) {
            sql.append(" AND e.department_id = ? ");
        }

        sql.append(" ORDER BY e.id ");

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql.toString())
        ) {

            ps.setString(1, "%" + keyword + "%");

            if (departmentId != null) {
                ps.setInt(2, departmentId);
            }

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    employees.add(
                            mapEmployee(rs)
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // Lấy employee theo ID
    public Employee getById(int id) {

        String sql = """
                SELECT e.id,
                       e.name,
                       e.department_id,
                       d.name AS department_name,
                       e.salary
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.id
                WHERE e.id = ?
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return mapEmployee(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Thêm employee
    public boolean insert(Employee employee) {

        String sql = """
                INSERT INTO employees
                    (name, department_id, salary)
                VALUES (?, ?, ?)
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getDepartmentId());
            ps.setDouble(3, employee.getSalary());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update employee
    public boolean update(Employee employee) {

        String sql = """
                UPDATE employees
                SET name = ?,
                    department_id = ?,
                    salary = ?
                WHERE id = ?
                """;

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getDepartmentId());
            ps.setDouble(3, employee.getSalary());
            ps.setInt(4, employee.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete employee
    public boolean delete(int id) {

        String sql =
                "DELETE FROM employees WHERE id = ?";

        try (
                Connection conn = DButil.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Chuyển ResultSet thành Employee
    private Employee mapEmployee(ResultSet rs)
            throws SQLException {

        Employee employee = new Employee();

        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setDepartmentId(
                rs.getInt("department_id")
        );
        employee.setDepartmentName(
                rs.getString("department_name")
        );
        employee.setSalary(
                rs.getDouble("salary")
        );

        return employee;
    }
}