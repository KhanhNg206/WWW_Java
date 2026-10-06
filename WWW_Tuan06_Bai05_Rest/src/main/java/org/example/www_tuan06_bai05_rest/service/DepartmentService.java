package org.example.www_tuan06_bai05_rest.service;


import org.example.www_tuan06_bai05_rest.model.Department;
import org.example.www_tuan06_bai05_rest.repo.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService() {
        repository = new DepartmentRepository();
    }

    public List<Department> getAll() {
        return repository.getAll();
    }

    public Department getById(int id) {
        return repository.getById(id);
    }

    public boolean insert(Department department) {
        return repository.insert(department);
    }

    public boolean update(Department department) {
        return repository.update(department);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}
