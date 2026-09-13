package org.example.ontaptk1_restapi_de01_p2.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import org.example.ontaptk1_restapi_de01_p2.model.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductSession implements Serializable {

    private List<Product> productList = new ArrayList<>();

    public ProductSession() {
        productList.add(new Product("123","coca",100));
        productList.add(new Product("124","pepsi",200));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product findById(String productId) {
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}