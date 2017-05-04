package com.codecool.shop.model;
import com.codecool.shop.dao.implementation.OrderProcessMethods;
import java.util.ArrayList;

/**
 * Created by Peter Bognar on 2017.05.02..
 */
public class Cart {
    ArrayList<OrderList> cart = new ArrayList<>();
    public Cart(){    }

    public Cart(Product product, int quantity, ArrayList orderList){
        Order order = new Order (product, quantity);
        new OrderProcessMethods().addToCart(order, orderList);
    }
 /*   public CartMethod(){
        new OrderProcessMethods().checkOut(orderList);
        new OrderProcessMethods().payment(orderList);
        new OrderProcessMethods().feedBack(orderList);
    }*/
 public ArrayList<OrderList> getCart() {
     return cart;
 }

}
