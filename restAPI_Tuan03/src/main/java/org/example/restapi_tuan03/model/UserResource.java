package org.example.restapi_tuan03.model;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    // Danh sách User tạm thời
    private static final List<User> users = new ArrayList<>();

    // Dữ liệu mẫu
    static {
        users.add(new User(1, "Nguyen Van A", "a@gmail.com"));
        users.add(new User(2, "Tran Thi B", "b@gmail.com"));
    }

    // =========================
    // GET - Lấy tất cả User
    // GET /api/user
    // =========================
    @GET
    public Response getAllUsers() {
        return Response.ok(users).build();
    }

    // =========================
    // GET - Lấy User theo ID
    // GET /api/user/1
    // =========================
    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") int id) {

        for (User user : users) {
            if (user.getId() == id) {
                return Response.ok(user).build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND)
                .entity("Không tìm thấy User có id = " + id)
                .build();
    }

    // =========================
    // POST - Thêm User mới
    // POST /api/user
    // =========================
    @POST
    public Response createUser(User user) {

        // Kiểm tra ID đã tồn tại chưa
        for (User u : users) {
            if (u.getId() == user.getId()) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("ID User đã tồn tại")
                        .build();
            }
        }

        users.add(user);

        return Response.status(Response.Status.CREATED)
                .entity(user)
                .build();
    }

    // =========================
    // PUT - Cập nhật User
    // PUT /api/user/1
    // =========================
    @PUT
    @Path("/{id}")
    public Response updateUser(
            @PathParam("id") int id,
            User updatedUser) {

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == id) {

                // Đảm bảo ID không bị thay đổi
                updatedUser.setId(id);

                users.set(i, updatedUser);

                return Response.ok(updatedUser).build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND)
                .entity("Không tìm thấy User có id = " + id)
                .build();
    }

    // =========================
    // DELETE - Xóa User
    // DELETE /api/user/1
    // =========================
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {

        for (User user : users) {

            if (user.getId() == id) {

                users.remove(user);

                return Response.ok()
                        .entity("Đã xóa User có id = " + id)
                        .build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND)
                .entity("Không tìm thấy User có id = " + id)
                .build();
    }
}

