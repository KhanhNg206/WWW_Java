package org.example.ontaptk1_web_de02.model;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("gradeReport")
@SessionScoped
public class GradeReport implements Serializable {

    private String maSv;
    private String hoVaTen;
    private String hocKy;
    private List<String> monHoc;

    public GradeReport(String maSv, String hoVaTen, String hocKy, List<String> monHoc) {
        this.maSv = maSv;
        this.hoVaTen = hoVaTen;
        this.hocKy = hocKy;
        this.monHoc = monHoc;
    }

    public GradeReport() {
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public List<String> getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(List<String> monHoc) {
        this.monHoc = monHoc;
    }

    @Override
    public String toString() {
        return "GradeReport{" +
                "maSv='" + maSv + '\'' +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", hocKy='" + hocKy + '\'' +
                ", monHoc=" + monHoc +
                '}';
    }
}
