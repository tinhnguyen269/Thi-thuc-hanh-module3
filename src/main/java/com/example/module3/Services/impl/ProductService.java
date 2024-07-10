package com.example.module3.Services.impl;

import com.example.module3.Models.Product;
import com.example.module3.Reponsitories.IProductReponsitory;
import com.example.module3.Reponsitories.impl.ProductReponsitory;
import com.example.module3.Services.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductReponsitory productReponsitory = new ProductReponsitory();
    @Override
    public List<Product> findAll() {
        return productReponsitory.findAll();
    }

    @Override
    public void save(Product product) {
        productReponsitory.save(product);
    }
}
