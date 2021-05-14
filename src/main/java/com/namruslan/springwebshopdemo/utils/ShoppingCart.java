package com.namruslan.springwebshopdemo.utils;

import com.namruslan.springwebshopdemo.entities.OrderItem;
import com.namruslan.springwebshopdemo.entities.Product;
import com.namruslan.springwebshopdemo.service.ProductService;
import com.namruslan.springwebshopdemo.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {

    private List<OrderItem> items;

    private ProductService productService;

    @Autowired
    public ShoppingCart(ProductService productService) {
        this.productService = productService;
    }

    public Collection<OrderView> getView() {
        return OrderViewUtil.toView(items);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void addProductById(Long id) {
        Product product = productService.getProductById(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        items.add(orderItem);
    }
}
