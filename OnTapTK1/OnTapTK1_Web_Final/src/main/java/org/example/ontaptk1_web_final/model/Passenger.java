package org.example.ontaptk1_web_final.model;

public class Passenger {
    private String passengerName;
    private String password;
    private String seatType;
    private String route;

    public Passenger(String passengerName, String password, String seatType, String route) {
        this.passengerName = passengerName;
        this.password = password;
        this.seatType = seatType;
        this.route = route;
    }

    public Passenger() {
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
