package com.codecool.shop.controller;
import com.codecool.shop.dao.DataBaseController;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
/**
 * Created by Peter Bognar on 2017.05.17..
 */
public class DBCMethods implements DataBaseController {
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/shopdb";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    private static final Logger logger = LoggerFactory.getLogger(DBCMethods.class);

    //Make base data before build site
    @Override
    public void uploadElements() throws SQLException {
        logger.debug("Upload elements.");
    }

    @Override
    public void updateElement(int id) {
   /*
        String query = "UPDATE shopdb SET title = '" + " title" + "' WHERE id = '" + productDataStore.getAll().get(id).getId() + "';";
        executeQuery(query);*/
        logger.debug("Update a specific element.");
    }

    @Override
    public void removeElement(int id) {
        logger.debug("Remove a specific element.");
    }

    @Override
    public void findElement(int id) {
        logger.debug("Find a specific element.");
    }

    @Override
    public void uploadBaseData() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()
        ){

            String categoryQuery = "INSERT INTO CATEGORY VALUES (1, 'Accessories', 'Electronics', 'Computer parts and more like mice and keyboards.')" +
                    "";

            statement.execute(categoryQuery);
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Make base tables before build site
    @Override
    public void makeTables() throws SQLException {
        String categoryQuery = "CREATE TABLE IF NOT EXISTS CATEGORY  " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " department VARCHAR(255), " +
                " description VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        executeQuery(categoryQuery);
        String supplierQuery = "CREATE TABLE IF NOT EXISTS SUPPLIER " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " description VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        executeQuery(supplierQuery);
        String productQuery = "CREATE TABLE IF NOT EXISTS PRODUCT " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " defaultPrice VARCHAR(255), " +
                " defaultCurrency VARCHAR(255), " +
                " productCategory VARCHAR(255), " +
                " supplier VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        executeQuery(productQuery);

        logger.debug("Tables created.");

    }

    private Connection getConnection() throws SQLException {
        logger.info("Connection set up.");
        return DriverManager.getConnection(DATABASE, DB_USER, DB_PASSWORD);
    }

    private void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()
        ){
            statement.execute(query);
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
