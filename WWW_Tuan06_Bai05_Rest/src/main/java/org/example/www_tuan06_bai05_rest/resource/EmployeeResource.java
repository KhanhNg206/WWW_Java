package org.example.www_tuan06_bai05_rest.resource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.www_tuan06_bai05_rest.model.Employee;
import org.example.www_tuan06_bai05_rest.service.EmployeeService;

import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private final EmployeeService service;

    public EmployeeResource() {
        service = new EmployeeService();
    }

    @GET
    public Response getAll() {

        List<Employee> list = service.getAll();

        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {

        Employee employee = service.getById(id);

        if (employee == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        return Response.ok(employee).build();
    }

    @GET
    @Path("/department/{departmentId}")
    public Response getByDepartment(
            @PathParam("departmentId") int departmentId) {

        List<Employee> list =
                service.getByDepartment(departmentId);

        return Response.ok(list).build();
    }

    @POST
    public Response insert(Employee employee) {

        boolean result = service.insert(employee);

        if (result) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(employee)
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
            Employee employee) {

        employee.setId(id);

        boolean result = service.update(employee);

        if (result) {
            return Response.ok(employee).build();
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