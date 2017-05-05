package com.codecool.shop.dao;

import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderList;

import java.util.ArrayList;

/**
 * Created by Peter Bognar on 2017.05.02..
 */
public interface OrderProcess {
    Order addToCart(Order order, OrderList orderList);
    ArrayList<Order> checkOut(OrderList orderList);
    ArrayList<Order> payment(OrderList orderList);
    ArrayList<Order> feedBack(OrderList orderList);

}
