package com.codecool.shop.dao.implementation;
import com.codecool.shop.dao.OrderProcess;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderList;
import freemarker.core._ArrayIterator;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Peter Bognar on 2017.05.02..
 */
public class OrderProcessMethods implements OrderProcess {
    public OrderProcessMethods(Order order, OrderList orderList){
        switch(orderList.getStatus()){
            case newOrder:
                new OrderProcessMethods(order, orderList).addToCart(order, orderList);
                break;
            case inCheckOut:
                new OrderProcessMethods(order, orderList).checkOut(orderList);
                break;
            case inCart:
                new OrderProcessMethods(order, orderList).payment(orderList);
                break;
            case payed:
                new OrderProcessMethods(order, orderList).feedBack(orderList);
        }
    }

    @Override
    public Order addToCart(Order order, OrderList orderList) {
        if (orderList.getOrder().getProduct() == order.getProduct()){

        }

        return null;
    }

    @Override
    public ArrayList<Order> checkOut(OrderList orderList) {
        return null;
    }

    @Override
    public ArrayList<Order> payment(OrderList orderList) {
        return null;
    }

    @Override
    public ArrayList<Order> feedBack(OrderList orderList) {
        return null;
    }

}
