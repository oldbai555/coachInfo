package com.neosoft.dao.impl;

import com.neosoft.dao.ISellTicketInfoDao;
import com.neosoft.entity.CarTicketTab;
import com.neosoft.entity.SellTicketInfo;
import com.neosoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SellTicketInfoDaoImpl implements ISellTicketInfoDao {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String sqlStr = null;


    @Override
    public SellTicketInfo findById(int id) {
        SellTicketInfo sellTicketInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from sell_ticket_info where id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                sellTicketInfo = new SellTicketInfo(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return sellTicketInfo;
    }

    @Override
    public List<SellTicketInfo> findAllPage(int index, int limit) {
        List<SellTicketInfo> list = new ArrayList<>();
        SellTicketInfo sellTicketInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from sell_ticket_info limit ? , ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, index);
            statement.setInt(2, limit);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                sellTicketInfo = new SellTicketInfo(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
                list.add(sellTicketInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<SellTicketInfo> findAll() {
        List<SellTicketInfo> list = new ArrayList<>();
        SellTicketInfo sellTicketInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from sell_ticket_info";
            statement = connection.prepareStatement(sqlStr);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                sellTicketInfo = new SellTicketInfo(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
                list.add(sellTicketInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int insert(SellTicketInfo sellTicketInfo) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "insert into sell_ticket_info(ticket_info_id,people_name,people_id_card)VALUE(?,?,?)";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, sellTicketInfo.getTicketInfoId());
            statement.setString(2, sellTicketInfo.getPeopleName());
            statement.setString(3, sellTicketInfo.getPeopleIdCard());
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return 0;
    }

    @Override
    public int update(SellTicketInfo sellTicketInfo) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "update sell_ticket_info SET ticket_info_id = ?,people_name = ?,people_id_card=? where id = ? ";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, sellTicketInfo.getTicketInfoId());
            statement.setString(2, sellTicketInfo.getPeopleName());
            statement.setString(3, sellTicketInfo.getPeopleIdCard());
            statement.setInt(4, sellTicketInfo.getId());
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return 0;
    }

    @Override
    public int deleteById(int id) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "delete from sell_ticket_info where id = ?";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return 0;
    }

    @Override
    public int count() {
        int num = 0;
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "select count(*) from sell_ticket_info";
            statement = connection.prepareStatement(strSql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                num = resultSet.getInt(1);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return num;
    }
}
