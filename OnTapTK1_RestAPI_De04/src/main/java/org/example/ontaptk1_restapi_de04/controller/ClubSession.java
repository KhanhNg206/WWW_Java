package org.example.ontaptk1_restapi_de04.controller;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.ontaptk1_restapi_de04.model.Club;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClubSession implements Serializable {
    private List<Club> clubList = new ArrayList<>();

    public ClubSession() {
        clubList.add(new Club("123","club 1",100));
        clubList.add(new Club("124","club 2",200));
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }

    public void addClub(Club club){
        clubList.add(club);
    }

    public Club findClubById(String id){
        for(Club club : clubList){
            if(club.getMaClub().equals(id)){
                return  club;
            }
        }
        return null;
    }
}
