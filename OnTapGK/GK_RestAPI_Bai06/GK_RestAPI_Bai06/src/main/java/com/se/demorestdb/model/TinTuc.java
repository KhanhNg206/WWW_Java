package com.se.demorestdb.model;

public class TinTuc {
    private String maTinTuc;
    private String tieuDe;
    private String noiDung;
    private String lienKet;
    private int maDM;

    public TinTuc(String maTinTuc, String tieuDe, String noiDung, String lienKet, int maDM) {
        this.maTinTuc = maTinTuc;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.lienKet = lienKet;
        this.maDM = maDM;
    }

    public TinTuc() {
    }

    public String getMaTinTuc() {
        return maTinTuc;
    }

    public void setMaTinTuc(String maTinTuc) {
        this.maTinTuc = maTinTuc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getLienKet() {
        return lienKet;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    @Override
    public String toString() {
        return "TinTuc{" +
                "maTinTuc='" + maTinTuc + '\'' +
                ", tieuDe='" + tieuDe + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", lienKet='" + lienKet + '\'' +
                ", maDM=" + maDM +
                '}';
    }
}
