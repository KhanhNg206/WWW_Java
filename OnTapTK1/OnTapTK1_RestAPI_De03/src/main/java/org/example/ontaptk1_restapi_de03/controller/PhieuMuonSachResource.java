package org.example.ontaptk1_restapi_de03.controller;


import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jdk.javadoc.doclet.Reporter;
import org.example.ontaptk1_restapi_de03.model.PhieuMuonSach;

import java.time.LocalDate;
import java.util.Arrays;

@Path("/phieuMuonSach")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PhieuMuonSachResource {

    @Inject
    private PhieuMuonSach phieuMuonSach;

    @PostConstruct
    public void initialData(){
        if(phieuMuonSach.getMuonSachList().isEmpty()){
            phieuMuonSach.addPhieuMuonSach(new PhieuMuonSach(123,
                    "Conan",
                     Arrays.asList("trinh thám","tình cảm"),
                     LocalDate.of(2026,9,14),
                     LocalDate.of(2026,9,14)));

            phieuMuonSach.addPhieuMuonSach(new PhieuMuonSach(124,
                    "Doraemon",
                    Arrays.asList("trinh thám","tình cảm"),
                    LocalDate.of(2026,9,14),
                    LocalDate.of(2026,9,14)));
        }
    }

    @GET
    public Response getAll(){
        return Response.ok(phieuMuonSach.getMuonSachList()).build();
    }

    @GET
    @Path("/{id}")
    public Response getSachById(@PathParam("id") int id){
        PhieuMuonSach sach = phieuMuonSach.findById(id);
        if(sach == null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Không tìm thấy id : "+id).build();
        }
        return Response.ok(sach).build();
    }

    @POST
    public Response createPhieuSach(PhieuMuonSach sach){
        phieuMuonSach.addPhieuMuonSach(sach);

        return Response.ok().status(Response.Status.CREATED)
                .entity(sach)
                .build();
    }
}
