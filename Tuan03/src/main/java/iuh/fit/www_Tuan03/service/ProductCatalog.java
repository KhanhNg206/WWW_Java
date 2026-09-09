package iuh.fit.www_Tuan03.service;

import iuh.fit.tranngocoanh_tuan02.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductCatalog {

    private final List<Product> products = new ArrayList<>();

    public ProductCatalog() {
        products.add(new Product(1, "Laptop Dell", new BigDecimal("15000000")));
        products.add(new Product(2, "Laptop HP", new BigDecimal("12000000")));
        products.add(new Product(3, "Chuột Logitech", new BigDecimal("500000")));
        products.add(new Product(4, "Bàn phím cơ", new BigDecimal("1000000")));
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(long id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
}
