package org.example.ontaptk1_restapi_final.model;

public class Passenger {
    private String id;
    private String passengerName;
    private String loaiGhe;
    private String tuyenXe;

    public Passenger(String id, String passengerName, String loaiGhe, String tuyenXe) {
        this.id = id;
        this.passengerName = passengerName;
        this.loaiGhe = loaiGhe;
        this.tuyenXe = tuyenXe;
    }

    public Passenger() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(String loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public String getTuyenXe() {
        return tuyenXe;
    }

    public void setTuyenXe(String tuyenXe) {
        this.tuyenXe = tuyenXe;
    }
}
