package com.se.demorestdb.resource;

import com.se.demorestdb.model.Employee;
import com.se.demorestdb.service.EmployeeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.checkerframework.common.util.report.qual.ReportCall;
import org.jboss.logging.annotations.Pos;

import java.util.List;

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private final EmployeeService service;

    public EmployeeResource() {
        service = new EmployeeService();
    }

    @GET
    public Response getAll(){
        List<Employee> employeeList = service.getAll();
        return Response.ok(employeeList).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id){
        Employee employee = service.getById(id);
        return Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteByIđ(@PathParam("id") int id){
        boolean result = service.deleteById(id);
        if(result){
            return Response.ok("Đã xóa thành công!").build();
        }
        return Response.
                status(Response.Status.NOT_FOUND).
                entity("Không tìm thấy id : "+id).
                build();
    }

    @POST
    public Response insert(Employee employee){
        boolean result = service.insert(employee);
        if(result){
            return Response.ok("Đã thêm thành công!").build();
        }
        return Response.
                status(Response.Status.NOT_FOUND).
                entity("Thêm thất baị").
                build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Employee employee){
        employee.setId(id);
        boolean result = service.update(employee);
        if(result){
            return Response.ok("Đã cập nhật thành công!").build();
        }
        return Response.
                status(Response.Status.NOT_FOUND).
                entity("cập nhật thất baị").
                build();
    }
}
