package org.example.www_tuan06_bai06_rest.service;


import org.example.www_tuan06_bai06_rest.model.DanhMuc;
import org.example.www_tuan06_bai06_rest.repo.DanhMucRepository;

import java.util.List;

public class DanhMucService {

    private final DanhMucRepository repository;

    public DanhMucService() {
        repository = new DanhMucRepository();
    }

    public List<DanhMuc> getAll() {
        return repository.getAll();
    }

    public DanhMuc getById(int madm) {
        return repository.getById(madm);
    }

    public boolean insert(DanhMuc danhMuc) {
        return repository.insert(danhMuc);
    }

    public boolean update(DanhMuc danhMuc) {
        return repository.update(danhMuc);
    }

    public boolean delete(int madm) {
        return repository.delete(madm);
    }
}
