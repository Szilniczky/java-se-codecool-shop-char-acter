package com.codecool.shop.model;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;

import java.util.HashMap;

/**
 * OrderList handle the cart actions like "add to cart".
 * It has Status, nextId and inCartId.
 * @author szilniczky
 */

public class OrderList {
    public enum Status {newOrder, inCart, inCheckOut, payed}
    private Integer nextId = 1;
    private Integer inCartId;

    private Status status = Status.newOrder;
    private HashMap <Integer, Product> inCart = new HashMap();

    /**
     * Basic constructor.
     */

    public void OrdeList(){
        this.status = Status.newOrder;
    }

    /**
     * Construct and initialize inCart
     * @param inCart inCart hashMap
     */

    public void Orderlist(HashMap inCart){
        this.status = Status.newOrder;
        this.inCart = inCart;

    }

    public void orderProcess(int productId){
        switch (getStatus()){
            case newOrder:
                addProductToCart(productId);
                break;
            case inCart:
                //doublecheck products, change quantity, delete, etc...
                break;
            case inCheckOut:
                //payment method
                break;
            case payed:
                //sending email about purchased products
                break;

            default:
                break;
        }
    }

    /**
     * addProductToCart fill the cart.
     * @param productId productId
     */

    private void addProductToCart (int productId) {
        inCartId = nextId;
        nextId++;
        if (productId != 0){
            ProductDao productDataStore = ProductDaoMem.getInstance();
            inCart.put(inCartId, productDataStore.find(productId));
            setStatus(Status.newOrder);
        }
    }

    public HashMap<Integer, Product> getInCart() {
        return inCart;
    }
    public Status getStatus() {
        return status;
    }
    private void setStatus(Status status) {
        this.status = status;
    }
}

