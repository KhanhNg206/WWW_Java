package org.example.www_tuan06_bai06_rest.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.www_tuan06_bai06_rest.model.TinTuc;
import org.example.www_tuan06_bai06_rest.service.TinTucService;

import java.util.List;

@Path("/tin-tuc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TinTucResource {

    private final TinTucService service;

    public TinTucResource() {
        service = new TinTucService();
    }

    @GET
    public Response getAll() {

        List<TinTuc> list = service.getAll();

        return Response.ok(list).build();
    }

    @GET
    @Path("/{matt}")
    public Response getById(@PathParam("matt") String matt) {

        TinTuc tinTuc = service.getById(matt);

        if (tinTuc == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        return Response.ok(tinTuc).build();
    }

    @GET
    @Path("/danh-muc/{madm}")
    public Response getByDanhMuc(
            @PathParam("madm") int madm) {

        List<TinTuc> list =
                service.getByDanhMuc(madm);

        return Response.ok(list).build();
    }

    @POST
    public Response insert(TinTuc tinTuc) {

        boolean result = service.insert(tinTuc);

        if (result) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(tinTuc)
                    .build();
        }

        return Response
                .status(Response.Status.BAD_REQUEST)
                .build();
    }

    @PUT
    @Path("/{matt}")
    public Response update(
            @PathParam("matt") String matt,
            TinTuc tinTuc) {

        tinTuc.setMatt(matt);

        boolean result = service.update(tinTuc);

        if (result) {
            return Response.ok(tinTuc).build();
        }

        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @DELETE
    @Path("/{matt}")
    public Response delete(
            @PathParam("matt") String matt) {

        boolean result = service.delete(matt);

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
