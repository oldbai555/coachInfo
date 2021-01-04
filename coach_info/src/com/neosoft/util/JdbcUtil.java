package com.neosoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 老白
 */
public class JdbcUtil {
    private static String sqlUrl = "jdbc:mysql://192.168.82.41:7777/coach_info?useUnicode=true&amp";
    private static String sqlUser = "root";
    private static String sqlPassword = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {

                connection.close();
            }
            if (statement != null) {

                statement.close();
            }
            if (resultSet != null) {

                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
