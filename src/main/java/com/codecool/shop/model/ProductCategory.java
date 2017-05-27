package com.codecool.shop.model;

import java.util.ArrayList;

/**
 * ProductCategory handle ProductCategory actions.
 * It has department and products.
 * @author szilniczky
 */

public class ProductCategory extends BaseModel {
    private String department;
    private ArrayList<Product> products;

    /**
     *Construct and initialize a name, department and a description.
     * @param name name
     * @param department department
     * @param description description
     */

    public ProductCategory(String name, String department, String description) {
        super(name);
        this.department = department;
        this.products = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public String toString() {
        return String.format(
                "id: %1$d," +
                        "name: %2$s, " +
                        "department: %3$s, " +
                        "description: %4$s",
                this.id,
                this.name,
                this.department,
                this.description);
    }
}