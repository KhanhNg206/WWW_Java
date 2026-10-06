package org.example.www_tuan06_bai06_rest.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.www_tuan06_bai06_rest.model.DanhMuc;
import org.example.www_tuan06_bai06_rest.service.DanhMucService;


import java.util.List;

@Path("/danh-muc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DanhMucResource {

    private final DanhMucService service;

    public DanhMucResource() {
        service = new DanhMucService();
    }

    @GET
    public Response getAll() {

        List<DanhMuc> list = service.getAll();

        return Response.ok(list).build();
    }

    @GET
    @Path("/{madm}")
    public Response getById(
            @PathParam("madm") int madm) {

        DanhMuc danhMuc = service.getById(madm);

        if (danhMuc == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        return Response.ok(danhMuc).build();
    }

    @POST
    public Response insert(DanhMuc danhMuc) {

        boolean result = service.insert(danhMuc);

        if (result) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(danhMuc)
                    .build();
        }

        return Response
                .status(Response.Status.BAD_REQUEST)
                .build();
    }

    @PUT
    @Path("/{madm}")
    public Response update(
            @PathParam("madm") int madm,
            DanhMuc danhMuc) {

        danhMuc.setMadm(madm);

        boolean result = service.update(danhMuc);

        if (result) {
            return Response.ok(danhMuc).build();
        }

        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @DELETE
    @Path("/{madm}")
    public Response delete(
            @PathParam("madm") int madm) {

        boolean result = service.delete(madm);

        if (result) {
            return Response
                    .status(Response.Status.NO_CONTENT)
                    .build();
        }

        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }
}
