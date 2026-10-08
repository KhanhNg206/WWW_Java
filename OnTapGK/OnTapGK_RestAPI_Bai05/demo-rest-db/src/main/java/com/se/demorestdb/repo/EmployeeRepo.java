package com.se.demorestdb.repo;

import com.se.demorestdb.model.Employee;

import java.util.List;

public interface EmployeeRepo {
    List<Employee> getAll();

    Employee getById(int id);

    boolean deleteById(int id);

    boolean insert(Employee employee);

    boolean update(Employee employee);
}
