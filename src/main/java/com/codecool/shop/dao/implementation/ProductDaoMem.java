package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoMem implements ProductDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoMem.class);
    private List<Product> DATA = new ArrayList<>();
    private static ProductDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private ProductDaoMem() {
    }

    public static ProductDaoMem getInstance() {
        if (instance == null) {
            instance = new ProductDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Product product) {
        product.setId(DATA.size() + 1);
        DATA.add(product);
        logger.debug("Add a specific product.");
    }

    @Override
    public Product find(int id) {
        logger.debug("Find a specific product.");
        return DATA.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        DATA.remove(find(id));
        logger.debug("Remove a specific product.");
    }

    @Override
    public List<Product> getAll() {
        logger.debug("List all product.");
        return DATA;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        logger.debug("List all products by supplier.");
        return DATA.stream().filter(t -> t.getSupplier().equals(supplier)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        logger.debug("List all products by category.");
        return DATA.stream().filter(t -> t.getProductCategory().equals(productCategory)).collect(Collectors.toList());
    }
}
