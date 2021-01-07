package com.neosoft.dao.impl;

import com.neosoft.dao.ICarInfoDao;
import com.neosoft.entity.CarInfo;
import com.neosoft.entity.CarType;
import com.neosoft.entity.Series4;
import com.neosoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarInfoDaoImpl implements ICarInfoDao {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String sqlStr = null;

    @Override
    public CarInfo findById(int id) {

        CarInfo carInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_info , car_type where car_id = car_type.id and car_info.id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carInfo = new CarInfo(resultSet.getInt(1),
                        new CarType(resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getInt(9),
                                resultSet.getString(10)),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return carInfo;

    }

    @Override
    public List<Series4> findPTime() {
        List<Series4> list = new ArrayList<>();
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select route_start , route_end ,probably_time from car_info , car_type where car_id = car_type.id";
            statement = connection.prepareStatement(sqlStr);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1)+"-"+resultSet.getString(2);
                list.add(new Series4(name,resultSet.getDouble(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public CarInfo findByCarId(int carId) {
        CarInfo carInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_info , car_type where car_id = car_type.id and car_info.car_id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, carId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carInfo = new CarInfo(resultSet.getInt(1),
                        new CarType(resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getInt(9),
                                resultSet.getString(10)),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return carInfo;
    }

    @Override
    public List<CarInfo> findAllPage(int index, int limit) {
        List<CarInfo> list = new ArrayList<>();
        CarInfo carInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_info , car_type where car_id = car_type.id limit ?,?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, index);
            statement.setInt(2, limit);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carInfo = new CarInfo(resultSet.getInt(1),
                        new CarType(resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getInt(9),
                                resultSet.getString(10)),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6)
                );
                list.add(carInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<CarInfo> findAll() {

        List<CarInfo> list = new ArrayList<>();
        CarInfo carInfo = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_info , car_type where car_id = car_type.id";
            statement = connection.prepareStatement(sqlStr);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carInfo = new CarInfo(resultSet.getInt(1),
                        new CarType(resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getInt(9),
                                resultSet.getString(10)),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6)
                );
                list.add(carInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int insert(CarInfo carInfo) {

        try {
            connection = JdbcUtil.getConnection();
            String strSql = "insert into car_info(car_id,route_start,route_end,car_start_time,probably_time)VALUE(?,?,?,?,?)";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, carInfo.getCarType().getId());
            statement.setString(2, carInfo.getRouteStart());
            statement.setString(3, carInfo.getRouteEnd());
            statement.setString(4, carInfo.getCar_start_time());
            statement.setDouble(5, carInfo.getProbably_time());
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return 0;
    }

    @Override
    public int update(CarInfo carInfo) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "update car_info SET car_id = ?,route_start = ?,route_end = ?,car_start_time = ?,probably_time = ? where id = ? ";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, carInfo.getCarType().getId());
            statement.setString(2, carInfo.getRouteStart());
            statement.setString(3, carInfo.getRouteEnd());
            statement.setString(4, carInfo.getCar_start_time());
            statement.setDouble(5, carInfo.getProbably_time());
            statement.setInt(6, carInfo.getId());
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
            String strSql = "delete from car_info where id = ?";
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
            String strSql = "select count(*) from car_info";
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
