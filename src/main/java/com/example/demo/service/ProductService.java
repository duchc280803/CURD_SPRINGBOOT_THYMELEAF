package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product findById(Integer id);

    Product create(Product product);

    Product update(Product product);

    boolean delete(Integer id);
}
