package org.example.www_tuan06_bai05_rest.resource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.www_tuan06_bai05_rest.model.Department;
import org.example.www_tuan06_bai05_rest.service.DepartmentService;

import java.util.List;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    private final DepartmentService service;

    public DepartmentResource() {
        service = new DepartmentService();
    }

    @GET
    public Response getAll() {

        List<Department> list = service.getAll();

        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {

        Department department = service.getById(id);

        if (department == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        return Response.ok(department).build();
    }

    @POST
    public Response insert(Department department) {

        boolean result = service.insert(department);

        if (result) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(department)
                    .build();
        }

        return Response
                .status(Response.Status.BAD_REQUEST)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(
            @PathParam("id") int id,
            Department department) {

        department.setId(id);

        boolean result = service.update(department);

        if (result) {
            return Response.ok(department).build();
        }

        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {

        boolean result = service.delete(id);

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
