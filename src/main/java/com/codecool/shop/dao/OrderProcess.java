package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.OrderProcessMethods;
import com.codecool.shop.model.Order;
import java.util.ArrayList;

/**
 * Created by Peter Bognar on 2017.05.02..
 */
public interface OrderProcess {
    Order addToCart(Order order, ArrayList orderList);
    Order checkOut(Order order);
    Order payment(Order order);
    Order feedBack(Order order);

}
