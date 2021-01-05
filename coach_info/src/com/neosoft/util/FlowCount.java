package com.neosoft.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FlowCount {

    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    private static String sqlStr = null;

    public static int findFlow() {

        int num = 0;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select flow from flow_count";
            statement = connection.prepareStatement(sqlStr);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                num = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return num;
    }

    public static int addFlow(int num) {
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "update flow_count SET flow = ? where id = 1 ";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1,num);
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return 0;
    }
}
