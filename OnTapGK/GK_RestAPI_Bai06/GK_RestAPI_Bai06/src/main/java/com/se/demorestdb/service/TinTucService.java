package com.se.demorestdb.service;

import com.se.demorestdb.dto.TinTucDanhMuc;
import com.se.demorestdb.model.TinTuc;
import com.se.demorestdb.repo.TinTucRepoImpl;

import java.util.List;

public class TinTucService {
    private final TinTucRepoImpl repo;

    public TinTucService() {
        repo = new TinTucRepoImpl();
    }

    public List<TinTuc> getAll(){
        return repo.getAll();
    }

    public List<TinTucDanhMuc> getTinTucDanhMuc(){
        return repo.getTinTucDanhMuc();
    }

    public List<TinTucDanhMuc> getTinTucDanhMucByTenDM(String tenDanhMuc){
        return repo.getTinTucDanhMucByTenDM(tenDanhMuc);
    }

    public List<TinTucDanhMuc> getSoLuongTT(){
        return repo.getSoLuongTT();
    }

    public List<TinTucDanhMuc> getSoLuongTTLonHonHoacBangHai(){
        return repo.getSoLuongTTLonHonHoacBangHai();
    }

    public List<TinTucDanhMuc> getSoLongTTMax(){
        return repo.getSoLongTTMax();
    }

}
