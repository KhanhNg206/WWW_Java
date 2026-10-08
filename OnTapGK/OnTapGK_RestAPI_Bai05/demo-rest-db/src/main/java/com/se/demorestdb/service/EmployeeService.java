package com.se.demorestdb.service;

import com.se.demorestdb.model.Employee;
import com.se.demorestdb.repo.EmployeeRepoImpl;
import jakarta.inject.Inject;

import java.util.List;

public class EmployeeService {
    private final EmployeeRepoImpl repo;

    public EmployeeService() {
        repo = new EmployeeRepoImpl();
    }

    public List<Employee> getAll(){
        return repo.getAll();
    }

    public Employee getById(int id){
        return repo.getById(id);
    }

    public boolean deleteById(int id){
        return repo.deleteById(id);
    }

    public boolean insert(Employee employee){
        return repo.insert(employee);
    }

    public boolean update(Employee employee){
        return repo.update(employee);
    }
}
