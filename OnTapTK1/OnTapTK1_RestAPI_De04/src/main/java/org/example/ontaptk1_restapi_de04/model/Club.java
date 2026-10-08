package org.example.ontaptk1_restapi_de04.model;

public class Club {
    private String maClub;
    private String tenClub;
    private int soLuongThanhVien;

    public Club(String maClub, String tenClub, int soLuongThanhVien) {
        this.maClub = maClub;
        this.tenClub = tenClub;
        this.soLuongThanhVien = soLuongThanhVien;
    }

    public Club() {
    }

    public String getMaClub() {
        return maClub;
    }

    public void setMaClub(String maClub) {
        this.maClub = maClub;
    }

    public String getTenClub() {
        return tenClub;
    }

    public void setTenClub(String tenClub) {
        this.tenClub = tenClub;
    }

    public int getSoLuongThanhVien() {
        return soLuongThanhVien;
    }

    public void setSoLuongThanhVien(int soLuongThanhVien) {
        this.soLuongThanhVien = soLuongThanhVien;
    }
}
