package org.example.www_tuan06_bai06.model;


public class TinTuc {

    private String matt;
    private String tieuDe;
    private String noiDungTT;
    private String lienKet;
    private int madm;

    // Constructor rỗng
    public TinTuc() {
    }

    // Constructor đầy đủ
    public TinTuc(
            String matt,
            String tieuDe,
            String noiDungTT,
            String lienKet,
            int madm) {

        this.matt = matt;
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
        this.madm = madm;
    }

    public String getMatt() {
        return matt;
    }

    public void setMatt(String matt) {
        this.matt = matt;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDungTT() {
        return noiDungTT;
    }

    public void setNoiDungTT(String noiDungTT) {
        this.noiDungTT = noiDungTT;
    }

    public String getLienKet() {
        return lienKet;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }

    public int getMadm() {
        return madm;
    }

    public void setMadm(int madm) {
        this.madm = madm;
    }
}
