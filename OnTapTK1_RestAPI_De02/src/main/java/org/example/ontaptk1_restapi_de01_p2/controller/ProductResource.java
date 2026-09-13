package org.example.ontaptk1_restapi_de01_p2.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.ontaptk1_restapi_de01_p2.model.Product;

import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductSession productSession;

    @GET
    public Response getAll(){
        return Response.ok(productSession.getProductList()).build();
    }

    @GET
    @Path("/{productId}")
    public Response getByid(@PathParam("productId") String productId){
        Product product = productSession.findById(productId);
        if(product == null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Không có id : "+productId)
                    .build();
        }
        return Response.ok(product).build();
    }

    @POST
    public Response create(Product product){
        productSession.addProduct(product);

        return Response.status(Response.Status.CREATED)
                .entity(product)
                .build();
    }

    @PUT
    @Path("/{productId}")
    public Response updateProduct(@PathParam("productId") String productId,Product product){
        for (int i = 0; i < productSession.getProductList().size() ; i++){
            if(productSession.getProductList().get(i).getProductId().equals(productId)){
                product.setProductId(productId);
                productSession.getProductList().set(i,product);
                return Response.ok(product).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Không tìm thấy id : "+productId)
                .build();
    }

    @DELETE
    @Path("/{productId}")
    public Response deleteProduct(@PathParam("productId") String productId ){
        for(Product product : productSession.getProductList()){
            if(product.getProductId().equals(productId)){
                productSession.getProductList().remove(product);
                return Response.ok()
                        .entity("Đã xóa product : "+productId)
                        .build();
            }
        }
        return Response.ok(Response.Status.NOT_FOUND)
                .entity("Không tìm thấy id : "+productId)
                .build();
    }
}
