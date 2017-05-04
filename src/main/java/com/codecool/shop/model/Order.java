package com.codecool.shop.model;

public class Order {
    private static int nextId = 1;

    private int id = 0;
    private Product product;
    private int quantity;

    public Order() {

    }


    public Order(Product product, int quantity){
        this.id = nextId;
        nextId++;
        this.product = product;
        this.quantity = quantity;

    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
