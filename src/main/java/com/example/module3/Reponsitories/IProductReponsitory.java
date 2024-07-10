package com.example.module3.Reponsitories;

import com.example.module3.Models.Product;

import java.util.List;

public interface IProductReponsitory {
    List<Product> findAll();

    void save(Product product);
}
