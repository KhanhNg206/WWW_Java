package com.se.demorestdb.resource;

import com.se.demorestdb.dto.ThuocDTO;
import com.se.demorestdb.model.Thuoc;
import com.se.demorestdb.service.ThuocService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/thuoc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ThuocResource {
    private ThuocService service;

    public ThuocResource() {
        service = new ThuocService();
    }

    @GET
    public Response getAll(){
        List<Thuoc> list = service.getAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/{tenloai}")
    public Response getTheoKhoangGia(@PathParam("tenloai") String tenLoai,@QueryParam("khoangGia") String khoangGia){
        Double gia = (khoangGia == null || khoangGia.isBlank()) ? null : Double.parseDouble(khoangGia);
        List<ThuocDTO> list = service.getTheoKhoangGia(tenLoai,gia);
        return Response.ok(list).build();
    }

    @GET
    @Path("/ngay")
    public Response getTheoNgay(@QueryParam("ngayBatDau") String ngayBatDau, @QueryParam("ngayKetThuc") String ngayKetThuc) {

        LocalDate bd = (ngayBatDau == null || ngayBatDau.isBlank()) ? null : LocalDate.parse(ngayBatDau);

        LocalDate kt = (ngayKetThuc == null || ngayKetThuc.isBlank()) ? null : LocalDate.parse(ngayKetThuc);

        List<Thuoc> list = service.getTheoNgay(bd, kt);
        return Response.ok(list).build();
    }
}
