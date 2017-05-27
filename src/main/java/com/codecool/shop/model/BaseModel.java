package com.codecool.shop.model;


import java.lang.reflect.Field;

/**
 * BaseModel contains basic informations from product and supplier.
 * @author szilniczky
 */

public class BaseModel {

    protected int id;
    protected String name;
    protected String description;

    /**
     * Construct and initialize a name.
     * @param name name
     */

    public BaseModel(String name) {
        this.name = name;
    }

    /**
     * Construct and initialize a name and description.
     * @param name name
     * @param description description
     */

    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
                if (value != null) {
                    sb.append(field.getName() + ":" + value + ",");
                }
            } catch (IllegalAccessException e) {

            }
        }
        return sb.toString();
    }

}
