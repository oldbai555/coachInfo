package com.neosoft.dao.impl;

import com.neosoft.dao.ICarTicketTabDao;
import com.neosoft.entity.CarTicketTab;
import com.neosoft.entity.CarType;
import com.neosoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarTicketTabDaoImpl implements ICarTicketTabDao {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String sqlStr = null;

    @Override
    public CarTicketTab findById(int id) {
        CarTicketTab ticketTab = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_ticket_tab where id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ticketTab = new CarTicketTab(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return ticketTab;
    }

    @Override
    public CarTicketTab findByInfoId(int infoId) {
        CarTicketTab ticketTab = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_ticket_tab where ticket_info_id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, infoId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ticketTab = new CarTicketTab(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return ticketTab;
    }

    @Override
    public List<CarTicketTab> findAllPage(int index, int limit) {
        List<CarTicketTab> list = new ArrayList<>();
        CarTicketTab ticketTab = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_ticket_tab limit ? ,?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, index);
            statement.setInt(2, limit);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ticketTab = new CarTicketTab(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4));
                list.add(ticketTab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<CarTicketTab> findAll() {
        List<CarTicketTab> list = new ArrayList<>();
        CarTicketTab ticketTab = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_ticket_tab";
            statement = connection.prepareStatement(sqlStr);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ticketTab = new CarTicketTab(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4));
                list.add(ticketTab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int insert(CarTicketTab ticketTab) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "insert into car_ticket_tab(ticket_info_id,ticket_num,ticket_sum)VALUE(?,?,?)";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, ticketTab.getTicketInfoId());
            statement.setInt(2, ticketTab.getTicketNum());
            statement.setInt(3, ticketTab.getTicketSum());
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return 0;
    }

    @Override
    public int update(CarTicketTab ticketTab) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "update car_ticket_tab SET ticket_info_id = ?,ticket_num = ?,ticket_sum=? where id = ? ";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, ticketTab.getTicketInfoId());
            statement.setInt(2, ticketTab.getTicketNum());
            statement.setInt(3, ticketTab.getTicketSum());
            statement.setInt(4, ticketTab.getId());
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
            String strSql = "delete from car_ticket_tab where id = ?";
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
            String strSql = "select count(*) from car_ticket_tab";
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
