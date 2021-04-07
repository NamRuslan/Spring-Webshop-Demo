package com.namruslan.springwebshopdemo.utils;

import com.namruslan.springwebshopdemo.entities.Product;
import com.namruslan.springwebshopdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {

    private ProductService productService;

    @Autowired
    public ShoppingCart(ProductService productService) {
        this.productService = productService;
    }

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }

    public void addProductById(Long id) {
        Product product = productService.getProductById(id);
        products.add(product);
    }
}
