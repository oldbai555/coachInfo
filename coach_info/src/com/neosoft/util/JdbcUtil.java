package com.neosoft.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author 老白
 */
public class JdbcUtil {

    /**
     * 定义一个 DataSource 对象
     */
    private static DataSource dataSource;

    /**
     * 静态代码块 加载 连接信息
     */
    static {
        dataSource = new ComboPooledDataSource("testc3p0");
    }

    private static String sqlUrl = "jdbc:mysql://192.168.82.41:7777/coach_info?useUnicode=true&amp";
    private static String sqlUser = "root";
    private static String sqlPassword = "root";

    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return connection;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
