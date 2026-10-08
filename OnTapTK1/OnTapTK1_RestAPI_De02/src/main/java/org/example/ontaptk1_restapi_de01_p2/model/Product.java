package org.example.ontaptk1_restapi_de01_p2.model;

public class Product {
    private String productId;
    private String name;
    private int soLuong;

    public Product(String productId, String name, int soLuong) {
        this.productId = productId;
        this.name = name;
        this.soLuong = soLuong;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
