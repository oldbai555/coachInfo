package com.neosoft.dao.impl;

import com.neosoft.dao.IAdminDao;
import com.neosoft.entity.Admin;
import com.neosoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminDaoImpl implements IAdminDao {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String sqlStr = null;


    @Override
    public Admin findById(int id) {
        Admin admin = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from admin where id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                admin = new Admin(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeConnection(connection,statement,resultSet);
        }
        return admin;
    }

    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        Admin admin = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from admin where username = ? and password = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                admin = new Admin(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeConnection(connection,statement,resultSet);
        }
        return admin;
    }

    @Override
    public Admin findByUsername(String username) {
        Admin admin = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from admin where username = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                admin = new Admin(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeConnection(connection,statement,resultSet);
        }
        return admin;
    }
}
