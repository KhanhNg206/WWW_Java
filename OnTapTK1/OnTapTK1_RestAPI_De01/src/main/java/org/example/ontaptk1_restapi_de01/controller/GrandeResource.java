package org.example.ontaptk1_restapi_de01.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.ontaptk1_restapi_de01.model.GrandeReport;
import jakarta.annotation.PostConstruct;
import java.util.Arrays;

@Path("/grades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GrandeResource {

    @Inject
    private GrandeReport grandeReport;

    @PostConstruct
    public void initData() {
        if (grandeReport.getGrandeReports().isEmpty()) {
            grandeReport.addReport(new GrandeReport(
                    "123456",
                    "Hoang Vinh",
                    "Hoc ky 2",
                    Arrays.asList(
                            "Lap trinh Java",
                            "Co so du lieu"
                    )
            ));

            grandeReport.addReport(new GrandeReport(
                    "654321",
                    "Nguyen Van A",
                    "Hoc ky 1",
                    Arrays.asList(
                            "Cau truc du lieu",
                            "Lap trinh Java"
                    )
            ));
        }
    }

    @GET
    public Response getAll(){
        return Response.ok(grandeReport.getGrandeReports()).build();
    }

    @GET
    @Path("/{studentId}")
    public Response getById(@PathParam("studentId") String studentId){
        GrandeReport report = grandeReport.findByStudentId(studentId);

        if(report == null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Không có id : "+studentId)
                    .build();
        }

        return Response.ok(report).build();
    }

    @POST
    public Response createPhieuDiem(GrandeReport report){
        grandeReport.addReport(report);

        return Response.status(Response.Status.CREATED)
                .entity(report)
                .build();
    }

}
