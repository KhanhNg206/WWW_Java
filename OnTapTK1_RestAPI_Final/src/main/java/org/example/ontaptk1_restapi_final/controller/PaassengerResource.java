package org.example.ontaptk1_restapi_final.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.ontaptk1_restapi_final.model.Passenger;
import org.example.ontaptk1_restapi_final.session.PassengerSession;

import java.net.http.HttpClient;

@Path("/passenger")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaassengerResource  {

    @Inject
    private PassengerSession passengerSession;

    @GET
    public Response getAll(){
        return Response.ok(passengerSession.getPassengerList()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id){
        Passenger passenger = passengerSession.findById(id);
        if(passenger == null){
            return Response.ok(Response.Status.NOT_FOUND).entity("Không tìm thấy id : "+id).build();
        }
        return Response.ok(passenger).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id,Passenger passenger){
        for (int i = 0; i< passengerSession.getPassengerList().size();i++){
           if(passengerSession.getPassengerList().get(i).getId().equals(id)){
               passenger.setId(id);
               passengerSession.getPassengerList().set(i,passenger);
               return Response.ok(passenger).build();
           }
        }
        return Response.ok(Response.Status.NOT_FOUND).entity("Không tìm thấy id : "+id).build();
    }

    @POST
    public Response create(Passenger passenger){
        passengerSession.addPassenger(passenger);
        return Response.ok(Response.Status.CREATED).entity(passenger).build();
    }


    @DELETE
    @Path("/{id}")
    public Response deletePassenger(@PathParam("id") String id){
        Passenger passenger = passengerSession.findById(id);
        if(passenger != null){
            passengerSession.getPassengerList().remove(passenger);
            return Response.ok(passenger).build();
        }
        return Response.ok(Response.Status.NOT_FOUND).entity("Không tìm thấy id : "+id).build();
    }
}
