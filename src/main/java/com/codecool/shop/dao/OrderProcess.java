package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.OrderProcessMethods;
import com.codecool.shop.model.Order;
import java.util.ArrayList;

/**
 * Created by Peter Bognar on 2017.05.02..
 */
public interface OrderProcess {
    Order addToCart(Order order, ArrayList orderList);
    ArrayList<Order> checkOut(ArrayList orderList);
    ArrayList<Order> payment(ArrayList orderList);
    ArrayList<Order> feedBack(ArrayList orderList);

}
