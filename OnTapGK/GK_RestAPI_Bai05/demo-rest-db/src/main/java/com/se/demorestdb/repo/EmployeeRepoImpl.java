package com.se.demorestdb.repo;

import com.se.demorestdb.model.Employee;

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

public class EmployeeRepoImpl implements EmployeeRepo {

    private volatile DataSource dataSource;

    private DataSource getDataSource(){
        if(dataSource == null){
            try{
                Context env = (Context) new InitialContext().lookup("java:comp/env");
                dataSource = (DataSource) env.lookup("jdbc/hrdb");
            }catch (NamingException e){
                throw new RuntimeException("Không tìm thấy data source ",e);
            }
        }
        return dataSource;
    }

    @Override
    public List<Employee> getAll(){
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setSalary(rs.getDouble("salary"));
                employeeList.add(employee);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public Employee getById(int id){
        Employee employee = new Employee();
        String sql = "SELECT * FROM employees where id = ?";
        try(
                Connection con = getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setInt(1,id);
           try(ResultSet rs = ps.executeQuery()){
               if(rs.next()){
                   employee.setId(rs.getInt("id"));
                   employee.setName(rs.getString("name"));
                   employee.setDepartment_id(rs.getInt("department_id"));
                   employee.setSalary(rs.getDouble("salary"));
                   return employee;
               }
           }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id){
        String sql = "delete from employees where id = ?";
        try(Connection con = getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ){
            ps.setInt(1,id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insert(Employee employee){
        String sql ="insert into employees(name,department_id,salary) values(?,?,?)";
        try(Connection con = getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,employee.getName());
            ps.setInt(2,employee.getDepartment_id());
            ps.setDouble(3,employee.getSalary());

            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employee employee){
        String sql = "update employees set name = ?,department_id = ?,salary = ? where id = ?";
        try(Connection con = getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1,employee.getName());
            ps.setInt(2,employee.getDepartment_id());
            ps.setDouble(3,employee.getSalary());
            ps.setInt(4,employee.getId());

            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}
