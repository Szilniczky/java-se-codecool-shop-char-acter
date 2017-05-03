package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import spark.Request;
import spark.Response;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

public class ProductController {

    public static ModelAndView renderProducts(Request req, Response res) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDao = SupplierDaoMem.getInstance();
        Map params = new HashMap<>();
        params.put("category", productCategoryDataStore.find(1));

        int id2 = Integer.parseInt(req.queryParams("id2"));
        params.put("supplier", productDataStore.getBy(supplierDao.find(id2)));

        int id = Integer.parseInt(req.queryParams("id"));
        params.put("products", productDataStore.getBy(productCategoryDataStore.find(id)));

        /*String search = req.queryParams("search-bar");
        params.put("products", productDataStore.getBy(productCategoryDataStore.find(search)));*/


        return new ModelAndView(params, "product/index");
    }

}
