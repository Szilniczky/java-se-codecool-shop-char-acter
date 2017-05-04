package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bence on 2017. 05. 04..
 */
public class OrderController {

    public static ModelAndView renderOrder(Request req, Response res) {




        Map params = new HashMap<>();
        return new ModelAndView(params, "product/index");
    }
}

