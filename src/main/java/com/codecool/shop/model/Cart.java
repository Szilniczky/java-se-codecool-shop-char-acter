package com.codecool.shop.model;
import com.codecool.shop.dao.implementation.OrderProcessMethods;
import java.util.ArrayList;

/**
 * Created by Peter Bognar on 2017.05.02..
 */
public class Cart {
    Order order = new Order();
    ArrayList<Order> orderList = new ArrayList<>();

    public Cart(){
        Order ordering = new OrderProcessMethods().addToCart(order, orderList);
        Order checking = new OrderProcessMethods().checkOut(order, orderList);
        Order paying = new OrderProcessMethods().payment(order, orderList);
        Order feeding = new OrderProcessMethods().feedBack(order, orderList);
    }


}
