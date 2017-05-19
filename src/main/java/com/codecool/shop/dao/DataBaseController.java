package com.codecool.shop.dao;

import java.sql.*;

/**
 * Created by Peter Bognar on 2017.05.17..
 */
public interface DataBaseController {

    public void makeTables() throws SQLException;
    public void updateElement(int id);
    public void removeElement(int id);
    public void findElement(int id);

    public void uploadBaseData();
    public void uploadElements() throws SQLException;

}
