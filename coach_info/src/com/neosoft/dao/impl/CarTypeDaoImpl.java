package com.neosoft.dao.impl;

import com.neosoft.dao.ICarTypeDao;
import com.neosoft.entity.Admin;
import com.neosoft.entity.CarType;
import com.neosoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarTypeDaoImpl implements ICarTypeDao {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String sqlStr = null;

    @Override
    public CarType findById(int id) {
        CarType carType = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_type where id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carType = new CarType(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return carType;
    }

    @Override
    public List<CarType> findAllPage(int index, int limit) {
        List<CarType> carTypes = new ArrayList<>();
        CarType carType = null;
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "select * from car_type limit ?,?";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, index);
            statement.setInt(2, limit);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carType = new CarType(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
                carTypes.add(carType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return carTypes;
    }


    @Override
    public List<CarType> findAll() {
        List<CarType> carTypes = new ArrayList<>();
        CarType carType = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_type";
            statement = connection.prepareStatement(sqlStr);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carType = new CarType(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
                carTypes.add(carType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return carTypes;
    }

    @Override
    public int insert(CarType carType) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "insert into car_type(car_name,people_num,license_plate)VALUE(?,?,?)";
            statement = connection.prepareStatement(strSql);
            statement.setString(1, carType.getCarName());
            statement.setInt(2, carType.getPeopleNum());
            statement.setString(3, carType.getLicensePlate());
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return 0;
    }

    @Override
    public int update(CarType carType) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "update car_type SET car_name = ? ,people_num = ? , license_plate = ? where id = ? ";
            statement = connection.prepareStatement(strSql);
            statement.setString(1, carType.getCarName());
            statement.setInt(2, carType.getPeopleNum());
            statement.setString(3, carType.getLicensePlate());
            statement.setInt(4,carType.getId());
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
            String strSql = "delete from car_type where id = ?";
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
            String strSql = "select count(*) from car_type";
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
