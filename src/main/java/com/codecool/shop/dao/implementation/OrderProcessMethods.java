package com.codecool.shop.dao.implementation;
import com.codecool.shop.dao.OrderProcess;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Peter Bognar on 2017.05.02..
 */
public class OrderProcessMethods implements OrderProcess {
    @Override
    public Order addToCart(Order order, ArrayList orderList) {
        Iterator iterator = orderList.iterator();
        while (iterator.hasNext()){
            if(order.getProduct() == iterator.next()){
                int quantity = order.getQuantity();
                order.setQuantity(quantity + 1);
                orderList.add(order);
                

            }
            else {
                int quantity = order.getQuantity();
                order.setQuantity(quantity);
                orderList.add(order);

            }
        }
        return null;
    }

    @Override
    public ArrayList<Order> checkOut(ArrayList orderList) {
        Iterator iterator = orderList.iterator();
        while (iterator.hasNext()){
            if (order.getProduct() == iterator.next() && order.getStatus() == "inCart"){
                order.setStatus("inCheckOut");
            }
        }
        return null;
    }

    @Override
    public ArrayList<Order> payment(ArrayList orderList) {
        Iterator iterator = orderList.iterator();
        while (iterator.hasNext()){
            if (order.getProduct() == iterator.next() && order.getStatus() == "inCheckOut"){
                order.setStatus("payed");
            }
        }

        return null;
    }

    @Override
    public ArrayList<Order> feedBack(ArrayList orderList) {
        Iterator iterator = orderList.iterator();
        if (order.getProduct() == iterator.next() && order.getStatus() == "payed"){
            order.setStatus("payed");
        }
        return null;
    }
}
