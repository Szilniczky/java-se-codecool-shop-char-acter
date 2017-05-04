package com.codecool.shop.dao.implementation;
import com.codecool.shop.dao.OrderProcess;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderList;

import java.util.ArrayList;

/**
 * Created by Peter Bognar on 2017.05.02..
 */
public class OrderProcessMethods implements OrderProcess {
    public OrderProcessMethods(Order order, OrderList orderList){
        switch(orderList.getStatus()){
            case newOrder:
                orderList.setStatus(OrderList.Status.newOrder);
                break;
            case inCheckOut:
                orderList.setStatus(OrderList.Status.inCheckOut);
                break;
            case inCart:
                orderList.setStatus(OrderList.Status.inCart);
                break;
            case payed:
                orderList.setStatus(OrderList.Status.inCart);
        }
    }

    @Override
    public Order addToCart(Order order, OrderList orderList) {
        if (orderList.getOrder().getProduct() == order.getProduct()){
            order.setQuantity(order.getQuantity()+1);
            orderList.setStatus(OrderList.Status.inCart);
        }else{
            order.setQuantity(order.getQuantity());
            orderList.setStatus(OrderList.Status.inCart);
        }

        return null;
    }

    @Override
    public ArrayList<Order> checkOut(OrderList orderList) {
        orderList.setStatus(OrderList.Status.inCheckOut);
        return null;
    }

    @Override
    public ArrayList<Order> payment(OrderList orderList) {
        orderList.setStatus(OrderList.Status.payed);
        return null;
    }

    @Override
    public ArrayList<Order> feedBack(OrderList orderList) {
        orderList.setStatus(OrderList.Status.payed);
        return null;
    }

}
