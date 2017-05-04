package com.codecool.shop.model;
/**
 * Created by Peter Bognar on 2017.05.03..
 */
public abstract class OrderList {
    public enum Status {newOrder, inCart, inCheckOut, payed}
    private Status status;
    private Order order;

    public void OrdeList(){
        this.status = Status.newOrder;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public Order getOrder() {
        return order;
    }
}

