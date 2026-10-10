package com.se.demorestdb.service;

import com.se.demorestdb.dto.ThuocDTO;
import com.se.demorestdb.model.Thuoc;
import com.se.demorestdb.repo.ThuocRepoImpl;

import java.time.LocalDate;
import java.util.List;

public class ThuocService {
    private ThuocRepoImpl repo;

    public ThuocService() {
        repo = new ThuocRepoImpl();
    }

    public List<Thuoc> getAll(){
        return  repo.getAll();
    }

    public List<ThuocDTO> getTheoKhoangGia(String tenLoai, Double khoangGia){
        return repo.getTheoKhoangGia(tenLoai,khoangGia);
    }

    public List<Thuoc> getTheoNgay(LocalDate ngayBatDau,LocalDate ngayKetThuc){
        return repo.getTheoNgay(ngayBatDau,ngayKetThuc);
    }
}
