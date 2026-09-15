package org.example.ontaptk1_restapi_final.session;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.ontaptk1_restapi_final.model.Passenger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PassengerSession implements Serializable {
    private List<Passenger> passengerList = new ArrayList<>();

    public PassengerSession() {
        passengerList.add(new Passenger("123","name 1","2","tra vinh"));
        passengerList.add(new Passenger("124","name 2","10","Vinh lonh"));
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public Passenger findById(String id){
        for (Passenger passenger : passengerList){
            if (passenger.getId().equals(id)){
                return passenger;
            }
        }
        return null;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}
