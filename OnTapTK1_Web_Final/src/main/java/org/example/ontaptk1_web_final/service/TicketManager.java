package org.example.ontaptk1_web_final.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.example.ontaptk1_web_final.model.Passenger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named("passengers")
public class TicketManager implements Serializable {
    List<Passenger> passengerList = new ArrayList<>();

    public TicketManager() {
        passengerList.add(new Passenger("123","pass 01","Ghế ngồi","Hà Nội - Hải Phòng"));
        passengerList.add(new Passenger("124","pass 02","Ghế ngồi","Hà Nội - Hải Phòng"));
        passengerList.add(new Passenger("125","pass 03","Giường nằm","TP.HCM - Đà Lạt"));
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public List<Passenger> getAllPassenger(){
        return passengerList;
    }
}
