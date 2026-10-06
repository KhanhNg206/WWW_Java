package org.example.www_tuan06_bai05.controller_restAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.example.www_tuan06_bai05.dao.DepartmentDAO;
import org.example.www_tuan06_bai05.model.Department;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/api/departments/*")
public class DepartmentRestController extends HttpServlet {

    private DepartmentDAO departmentDAO;
    private Gson gson;

    @Override
    public void init() {

        departmentDAO = new DepartmentDAO();

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    // =========================
    // GET
    // =========================

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(
                "application/json;charset=UTF-8"
        );

        String pathInfo =
                request.getPathInfo();

        // GET /api/departments
        if (pathInfo == null
                || pathInfo.equals("/")
                || pathInfo.isEmpty()) {

            getAll(response);

            return;
        }

        // GET /api/departments/{id}

        try {

            int id = Integer.parseInt(
                    pathInfo.substring(1)
            );

            getById(id, response);

        } catch (NumberFormatException e) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    "ID phải là số nguyên"
                            )
                    )
            );
        }
    }

    // =========================
    // POST
    // =========================

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(
                "application/json;charset=UTF-8"
        );

        request.setCharacterEncoding("UTF-8");

        String json =
                request.getReader()
                        .lines()
                        .reduce("", (acc, line) ->
                                acc + line
                        );

        try {

            Department department =
                    gson.fromJson(
                            json,
                            Department.class
                    );

            if (department == null
                    || department.getName() == null
                    || department.getName().trim().isEmpty()) {

                response.setStatus(
                        HttpServletResponse.SC_BAD_REQUEST
                );

                response.getWriter().write(
                        gson.toJson(
                                new ErrorResponse(
                                        "Tên phòng ban không được để trống"
                                )
                        )
                );

                return;
            }

            departmentDAO.insert(department);

            response.setStatus(
                    HttpServletResponse.SC_CREATED
            );

            response.getWriter().write(
                    gson.toJson(department)
            );

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    e.getMessage()
                            )
                    )
            );
        }
    }

    // =========================
    // PUT
    // =========================

    @Override
    protected void doPut(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(
                "application/json;charset=UTF-8"
        );

        request.setCharacterEncoding("UTF-8");

        String pathInfo =
                request.getPathInfo();

        if (pathInfo == null
                || pathInfo.equals("/")
                || pathInfo.isEmpty()) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    "Phải cung cấp ID"
                            )
                    )
            );

            return;
        }

        try {

            int id = Integer.parseInt(
                    pathInfo.substring(1)
            );

            Department oldDepartment =
                    departmentDAO.getById(id);

            if (oldDepartment == null) {

                response.setStatus(
                        HttpServletResponse.SC_NOT_FOUND
                );

                response.getWriter().write(
                        gson.toJson(
                                new ErrorResponse(
                                        "Không tìm thấy phòng ban có ID = "
                                                + id
                                )
                        )
                );

                return;
            }

            String json =
                    request.getReader()
                            .lines()
                            .reduce("", (acc, line) ->
                                    acc + line
                            );

            Department department =
                    gson.fromJson(
                            json,
                            Department.class
                    );

            if (department == null
                    || department.getName() == null
                    || department.getName().trim().isEmpty()) {

                response.setStatus(
                        HttpServletResponse.SC_BAD_REQUEST
                );

                response.getWriter().write(
                        gson.toJson(
                                new ErrorResponse(
                                        "Tên phòng ban không được để trống"
                                )
                        )
                );

                return;
            }

            department.setId(id);

            boolean success =
                    departmentDAO.update(department);

            if (success) {

                response.setStatus(
                        HttpServletResponse.SC_OK
                );

                response.getWriter().write(
                        gson.toJson(department)
                );

            } else {

                response.setStatus(
                        HttpServletResponse.SC_INTERNAL_SERVER_ERROR
                );

                response.getWriter().write(
                        gson.toJson(
                                new ErrorResponse(
                                        "Update thất bại"
                                )
                        )
                );
            }

        } catch (NumberFormatException e) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    "ID phải là số nguyên"
                            )
                    )
            );

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    e.getMessage()
                            )
                    )
            );
        }
    }

    // =========================
    // DELETE
    // =========================

    @Override
    protected void doDelete(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(
                "application/json;charset=UTF-8"
        );

        String pathInfo =
                request.getPathInfo();

        if (pathInfo == null
                || pathInfo.equals("/")
                || pathInfo.isEmpty()) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    "Phải cung cấp ID"
                            )
                    )
            );

            return;
        }

        try {

            int id = Integer.parseInt(
                    pathInfo.substring(1)
            );

            Department department =
                    departmentDAO.getById(id);

            if (department == null) {

                response.setStatus(
                        HttpServletResponse.SC_NOT_FOUND
                );

                response.getWriter().write(
                        gson.toJson(
                                new ErrorResponse(
                                        "Không tìm thấy phòng ban có ID = "
                                                + id
                                )
                        )
                );

                return;
            }

            boolean success =
                    departmentDAO.delete(id);

            if (success) {

                response.setStatus(
                        HttpServletResponse.SC_OK
                );

                response.getWriter().write(
                        gson.toJson(
                                new SuccessResponse(
                                        "Xóa phòng ban thành công"
                                )
                        )
                );

            } else {

                response.setStatus(
                        HttpServletResponse.SC_INTERNAL_SERVER_ERROR
                );

                response.getWriter().write(
                        gson.toJson(
                                new ErrorResponse(
                                        "Xóa phòng ban thất bại"
                                )
                        )
                );
            }

        } catch (NumberFormatException e) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    "ID phải là số nguyên"
                            )
                    )
            );

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    e.getMessage()
                            )
                    )
            );
        }
    }

    // =========================
    // GET ALL
    // =========================

    private void getAll(
            HttpServletResponse response)
            throws IOException {

        try {

            List<Department> departments =
                    departmentDAO.getAll();

            response.setStatus(
                    HttpServletResponse.SC_OK
            );

            response.getWriter().write(
                    gson.toJson(departments)
            );

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    e.getMessage()
                            )
                    )
            );
        }
    }

    // =========================
    // GET BY ID
    // =========================

    private void getById(
            int id,
            HttpServletResponse response)
            throws IOException {

        try {

            Department department =
                    departmentDAO.getById(id);

            if (department == null) {

                response.setStatus(
                        HttpServletResponse.SC_NOT_FOUND
                );

                response.getWriter().write(
                        gson.toJson(
                                new ErrorResponse(
                                        "Không tìm thấy phòng ban có ID = "
                                                + id
                                )
                        )
                );

                return;
            }

            response.setStatus(
                    HttpServletResponse.SC_OK
            );

            response.getWriter().write(
                    gson.toJson(department)
            );

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            );

            response.getWriter().write(
                    gson.toJson(
                            new ErrorResponse(
                                    e.getMessage()
                            )
                    )
            );
        }
    }

    // =========================
    // RESPONSE CLASS
    // =========================

    private static class ErrorResponse {

        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private static class SuccessResponse {

        private String message;

        public SuccessResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}