package com.codecool.shop.model;
/**
 * Created by Peter Bognar on 2017.05.02..
 */
public class Order extends Cart {
    private static int nextId = 1;

    private int id = 1;
    private Product product;
    private int quantity;
    private String status;

    public void Order(){}

    public void Order(Product product, int quantity){
        this.id = nextId;
        nextId++;
        this.product = product;
        this.quantity = quantity;
        this.status = "new";
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
