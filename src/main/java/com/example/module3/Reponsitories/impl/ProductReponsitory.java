package com.example.module3.Reponsitories.impl;

import com.example.module3.Models.Product;
import com.example.module3.Reponsitories.IProductReponsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductReponsitory implements IProductReponsitory {
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        if (connection == null) {
            throw new RuntimeException("Database connection is null");
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_product, name_product, price,discount, quantity FROM product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String name = resultSet.getString("name_product");
                double price = resultSet.getLong("price");
                double discount = resultSet.getDouble("discount");
                int quantity = resultSet.getInt("quantity");
             Product product = new Product(  id, discount,  name,  price,  quantity);
             products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void save(Product product) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("insert into product(name_product, price, discount,quantity) value (?, ?, ?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3,product.getDiscount());
            preparedStatement.setInt(4,product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
