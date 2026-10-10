package com.se.demorestdb.dto;

public class TinTucDanhMuc {
    private String maTT;
    private String tieuDe;
    private String tenDanhMuc;
    private String noiDung;
    private String maDM;
    private int soLuong;


    public TinTucDanhMuc(String maTT, String tieuDe, String tenDanhMuc, String noiDung, String maDM, int soLuong) {
        this.maTT = maTT;
        this.tieuDe = tieuDe;
        this.tenDanhMuc = tenDanhMuc;
        this.noiDung = noiDung;
        this.maDM = maDM;
        this.soLuong = soLuong;
    }

    public TinTucDanhMuc() {
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    @Override
    public String toString() {
        return "TinTucDanhMuc{" +
                "maTT='" + maTT + '\'' +
                ", tieuDe='" + tieuDe + '\'' +
                ", tenDanhMuc='" + tenDanhMuc + '\'' +
                ", noiDung='" + noiDung + '\'' +
                '}';
    }
}
