package com.namruslan.springwebshopdemo.service;

import com.namruslan.springwebshopdemo.entities.Product;
import com.namruslan.springwebshopdemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById (Long id) {
        return productRepository.getProducts().get(id.intValue() - 1);
    }

    public List<Product> getAllProducts () {
        return productRepository.getProducts();
    }

    public void deleteProductById (Long id) {
        productRepository.deleteById(id);
    }
}
