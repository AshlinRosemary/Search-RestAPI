package com.filter.springboot.service;

import com.filter.springboot.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);
}
