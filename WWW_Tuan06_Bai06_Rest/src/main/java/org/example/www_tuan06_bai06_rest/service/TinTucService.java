package org.example.www_tuan06_bai06_rest.service;


import org.example.www_tuan06_bai06_rest.model.TinTuc;
import org.example.www_tuan06_bai06_rest.repo.TinTucRepository;

import java.util.List;

public class TinTucService {

    private final TinTucRepository repository;

    public TinTucService() {
        repository = new TinTucRepository();
    }

    public List<TinTuc> getAll() {
        return repository.getAll();
    }

    public TinTuc getById(String matt) {
        return repository.getById(matt);
    }

    public List<TinTuc> getByDanhMuc(int madm) {
        return repository.getByDanhMuc(madm);
    }

    public boolean insert(TinTuc tinTuc) {
        return repository.insert(tinTuc);
    }

    public boolean update(TinTuc tinTuc) {
        return repository.update(tinTuc);
    }

    public boolean delete(String matt) {
        return repository.delete(matt);
    }
}
