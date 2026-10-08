package org.example.ontaptk1_restapi_de03.model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.bind.annotation.JsonbTransient;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PhieuMuonSach implements Serializable {
    private int id;
    private String tenSach;
    private List<String> theLoai;
    private LocalDate ngayTra;
    private LocalDate ngayMuon;


    @JsonbTransient
    private List<PhieuMuonSach> muonSachList = new ArrayList<>();

    public PhieuMuonSach(int id, String tenSach, List<String> theLoai, LocalDate ngayTra, LocalDate ngayMuon) {
        this.id = id;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.ngayTra = ngayTra;
        this.ngayMuon = ngayMuon;
    }

    public PhieuMuonSach() {
    }

    public List<PhieuMuonSach> getMuonSachList() {
        return muonSachList;
    }

    public void setMuonSachList(List<PhieuMuonSach> muonSachList) {
        this.muonSachList = muonSachList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public List<String> getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(List<String> theLoai) {
        this.theLoai = theLoai;
    }

    public LocalDate getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }

    public LocalDate getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(LocalDate ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void addPhieuMuonSach(PhieuMuonSach phieuMuonSach){
        muonSachList.add(phieuMuonSach);
    }

    public PhieuMuonSach findById(int id){
        for(PhieuMuonSach phieuMuonSach : muonSachList){
            if(phieuMuonSach.getId() == id){
                return phieuMuonSach;
            }
        }
        return null;
    }
}
