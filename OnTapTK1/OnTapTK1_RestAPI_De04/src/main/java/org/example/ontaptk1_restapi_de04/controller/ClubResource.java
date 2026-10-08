package org.example.ontaptk1_restapi_de04.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.ontaptk1_restapi_de04.model.Club;

import java.awt.*;

@Path("/club")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClubResource {

    @Inject
    private ClubSession clubSession;

    @GET
    public Response getAll(){
        return Response.ok(clubSession.getClubList()).build();
    }

    @GET
    @Path("/{clubId}")
    public Response getClubById(@PathParam("clubId") String clubId){
        Club club = clubSession.findClubById(clubId);
        if(club == null){
            return Response.ok(Response.Status.NOT_FOUND)
                    .entity("Không tìm thấy id : "+clubId)
                    .build();
        }
        return Response.ok(club)
                .build();
    }

    @POST
    public Response create(Club club){
        clubSession.addClub(club);

        return  Response.ok(Response.Status.CREATED)
                .entity(club)
                .build();
    }

    @PUT
    @Path("/{clubId}")
    public Response updateClub(@PathParam("clubId") String clubId,Club club){
        for(int i = 0 ; i < clubSession.getClubList().size() ; i++){
            if(clubSession.getClubList().get(i).getMaClub().equals(clubId)){
                club.setMaClub(clubId);
                clubSession.getClubList().set(i,club);
                return Response.ok(club).build();
            }
        }
        return Response.ok(Response.Status.NOT_FOUND)
                .entity("Không tìm thấy id : "+clubId)
                .build();
    }

    @DELETE
    @Path("/{clubId}")
    public Response deleteClub(@PathParam("clubId") String clubId){
        Club club = clubSession.findClubById(clubId);
        clubSession.getClubList().remove(club);

        return Response.ok().entity("đã xóa club : "+clubId).build();
    }
}
