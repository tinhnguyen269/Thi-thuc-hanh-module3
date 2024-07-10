package com.example.module3.Models;

public class Product {
    private int id;
    private String name;
    private double price;
    private double discount;
    private int quantity;

    public Product(int id,double discount, String name, double price, int quantity) {
        this.discount = discount;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public Product() {
    }

    public Product(String name, double price, double discount, int quantity) {
        this.discount = discount;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
