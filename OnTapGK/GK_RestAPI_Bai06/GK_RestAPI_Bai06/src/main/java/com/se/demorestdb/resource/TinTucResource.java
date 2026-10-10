package com.se.demorestdb.resource;

import com.se.demorestdb.dto.TinTucDanhMuc;
import com.se.demorestdb.model.TinTuc;
import com.se.demorestdb.service.TinTucService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tintuc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TinTucResource {
    private final TinTucService service;

    public TinTucResource() {
        service = new TinTucService();
    }

    @GET
    public Response getAll(){
        List<TinTuc> list = service.getAll();
        return Response.ok(list).build();
    }

    //query 1
    @GET
    @Path("/tintucdanhmuc")
    public Response getTinTucDanhMuc(){
        List<TinTucDanhMuc> list = service.getTinTucDanhMuc();
        return Response.ok(list).build();
    }

    //query 2
    @GET
    @Path("/{tenDanhMuc}")
    public Response getTinTucDanhMucByTenDM(@PathParam("tenDanhMuc") String tenDanhMuc){
        List<TinTucDanhMuc> list = service.getTinTucDanhMucByTenDM(tenDanhMuc);
        return Response.ok(list).build();
    }

    @GET
    @Path("/soluongtt")
    public Response getSoLuongTT(){
        List<TinTucDanhMuc> list = service.getSoLuongTT();
        return Response.ok(list).build();
    }

    @GET
    @Path("/soluongttlonhon2")
    public Response getSoLuongTTLonHonHoacBangHai(){
        List<TinTucDanhMuc> list = service.getSoLuongTTLonHonHoacBangHai();
        return Response.ok(list).build();
    }

    @GET
    @Path("/soluongmax")
    public Response getSoLongTTMax(){
        List<TinTucDanhMuc> list = service.getSoLongTTMax();
        return Response.ok(list).build();
    }
}
