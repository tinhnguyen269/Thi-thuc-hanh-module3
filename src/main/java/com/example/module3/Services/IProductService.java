package com.example.module3.Services;

import com.example.module3.Models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);
}
