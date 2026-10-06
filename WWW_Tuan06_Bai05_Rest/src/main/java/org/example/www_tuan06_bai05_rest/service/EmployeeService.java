package org.example.www_tuan06_bai05_rest.service;


import org.example.www_tuan06_bai05_rest.model.Employee;
import org.example.www_tuan06_bai05_rest.repo.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService() {
        repository = new EmployeeRepository();
    }

    public List<Employee> getAll() {
        return repository.getAll();
    }

    public Employee getById(int id) {
        return repository.getById(id);
    }

    public List<Employee> getByDepartment(int departmentId) {
        return repository.getByDepartment(departmentId);
    }

    public boolean insert(Employee employee) {
        return repository.insert(employee);
    }

    public boolean update(Employee employee) {
        return repository.update(employee);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}