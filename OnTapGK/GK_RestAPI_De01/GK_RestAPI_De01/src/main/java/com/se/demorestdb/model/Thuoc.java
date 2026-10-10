package com.se.demorestdb.model;

import java.time.LocalDate;

public class Thuoc {
    private int maThuoc;
    private String tenThuoc;
    private double gia;
    private int namSanXuat;
    private int maLoai;
    private LocalDate ngayBatDauSuDung;
    private LocalDate ngayHetHanSuDung;

    public Thuoc(int maThuoc, String tenThuoc, double gia, int namSanXuat, int maLoai, LocalDate ngayBatDauSuDung, LocalDate ngayHetHanSuDung) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.namSanXuat = namSanXuat;
        this.maLoai = maLoai;
        this.ngayBatDauSuDung = ngayBatDauSuDung;
        this.ngayHetHanSuDung = ngayHetHanSuDung;
    }

    public Thuoc() {
    }

    public int getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(int maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public LocalDate getNgayBatDauSuDung() {
        return ngayBatDauSuDung;
    }

    public void setNgayBatDauSuDung(LocalDate ngayBatDauSuDung) {
        this.ngayBatDauSuDung = ngayBatDauSuDung;
    }

    public LocalDate getNgayHetHanSuDung() {
        return ngayHetHanSuDung;
    }

    public void setNgayHetHanSuDung(LocalDate ngayHetHanSuDung) {
        this.ngayHetHanSuDung = ngayHetHanSuDung;
    }

    @Override
    public String toString() {
        return "Thuoc{" +
                "maThuoc=" + maThuoc +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", gia=" + gia +
                ", namSanXuat=" + namSanXuat +
                ", maLoai=" + maLoai +
                ", ngayBatDauSuDung=" + ngayBatDauSuDung +
                ", ngayHetHanSuDung=" + ngayHetHanSuDung +
                '}';
    }
}
