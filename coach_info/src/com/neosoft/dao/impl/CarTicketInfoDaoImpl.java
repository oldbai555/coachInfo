package com.neosoft.dao.impl;

import com.neosoft.dao.ICarTicketInfoDao;
import com.neosoft.entity.CarInfo;
import com.neosoft.entity.CarTicketInfo;
import com.neosoft.entity.CarType;
import com.neosoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarTicketInfoDaoImpl implements ICarTicketInfoDao {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String sqlStr = null;

    @Override
    public CarTicketInfo findById(int id) {
        CarTicketInfo ticketInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_ticket_info , car_type , car_info where car_ticket_info.car_id = car_type.id and car_ticket_info.car_id = car_info.id and car_ticket_info.id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ticketInfo = new CarTicketInfo(resultSet.getInt(1),
                        new CarInfo(resultSet.getInt(8),
                                new CarType(resultSet.getInt(4),
                                        resultSet.getString(5),
                                        resultSet.getInt(6),
                                        resultSet.getString(7)),
                                resultSet.getString(10),
                                resultSet.getString(11),
                                resultSet.getString(12),
                                resultSet.getDouble(13)
                        ),
                        resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return ticketInfo;
    }

    @Override
    public CarTicketInfo findByCarId(int carId) {
        CarTicketInfo ticketInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_ticket_info , car_type , car_info where car_ticket_info.car_id = car_type.id and car_ticket_info.car_id = car_info.id and car_ticket_info.car_id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, carId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ticketInfo = new CarTicketInfo(resultSet.getInt(1),
                        new CarInfo(resultSet.getInt(8),
                                new CarType(resultSet.getInt(4),
                                        resultSet.getString(5),
                                        resultSet.getInt(6),
                                        resultSet.getString(7)),
                                resultSet.getString(10),
                                resultSet.getString(11),
                                resultSet.getString(12),
                                resultSet.getDouble(13)
                        ),
                        resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return ticketInfo;
    }

    @Override
    public List<CarTicketInfo> findAllPage(int index, int limit) {
        List<CarTicketInfo> list = new ArrayList<>();
        CarTicketInfo ticketInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_ticket_info , car_type , car_info where car_ticket_info.car_id = car_type.id and car_ticket_info.car_id = car_info.id limit ? , ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1,index);
            statement.setInt(2,limit);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ticketInfo =  ticketInfo = new CarTicketInfo(resultSet.getInt(1),
                        new CarInfo(resultSet.getInt(8),
                                new CarType(resultSet.getInt(4),
                                        resultSet.getString(5),
                                        resultSet.getInt(6),
                                        resultSet.getString(7)),
                                resultSet.getString(10),
                                resultSet.getString(11),
                                resultSet.getString(12),
                                resultSet.getDouble(13)
                        ),
                        resultSet.getString(3));
                list.add(ticketInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<CarTicketInfo> findAll() {
        List<CarTicketInfo> list = new ArrayList<>();
        CarTicketInfo ticketInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_ticket_info , car_type , car_info where car_ticket_info.car_id = car_type.id and car_ticket_info.car_id = car_info.id";
            statement = connection.prepareStatement(sqlStr);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ticketInfo =  ticketInfo = new CarTicketInfo(resultSet.getInt(1),
                        new CarInfo(resultSet.getInt(8),
                                new CarType(resultSet.getInt(4),
                                        resultSet.getString(5),
                                        resultSet.getInt(6),
                                        resultSet.getString(7)),
                                resultSet.getString(10),
                                resultSet.getString(11),
                                resultSet.getString(12),
                                resultSet.getDouble(13)
                        ),
                        resultSet.getString(3));
                list.add(ticketInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int insert(CarTicketInfo carTicketInfo) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "insert into car_ticket_info(car_id,ticket_name)VALUE(?,?)";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1,carTicketInfo.getCarInfo().getCarType().getId());
            statement.setString(2,carTicketInfo.getTicketName());
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return 0;
    }

    @Override
    public int update(CarTicketInfo carTicketInfo) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "update car_ticket_info SET car_id = ?,ticket_name = ?where id = ? ";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1,carTicketInfo.getCarInfo().getCarType().getId());
            statement.setString(2,carTicketInfo.getTicketName());
            statement.setInt(3,carTicketInfo.getId());
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
            String strSql = "delete from car_ticket_info where id = ?";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1,id);
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
            String strSql = "select count(*) from car_ticket_info";
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
