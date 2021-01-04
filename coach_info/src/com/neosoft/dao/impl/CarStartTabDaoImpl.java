package com.neosoft.dao.impl;

import com.neosoft.dao.ICarStartTabDao;
import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.CarType;
import com.neosoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarStartTabDaoImpl implements ICarStartTabDao {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String sqlStr = null;

    @Override
    public CarStartTab findById(int id) {

        CarStartTab carStartTab = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_start_tab , car_type where car_id = car_type.id and car_start_tab.id = ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carStartTab = new CarStartTab(resultSet.getInt(1),
                        new CarType(resultSet.getInt(5),
                                resultSet.getString(6),
                                resultSet.getInt(7),
                                resultSet.getString(8)),
                        resultSet.getInt(3),
                        resultSet.getDate(4));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return carStartTab;
    }

    @Override
    public List<CarStartTab> findAllPage(int index, int limit) {
        List<CarStartTab> list = new ArrayList<>();
        CarStartTab carStartTab = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_start_tab , car_type where car_id = car_type.id limit ? , ?";
            statement = connection.prepareStatement(sqlStr);
            statement.setInt(1,index);
            statement.setInt(2,limit);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carStartTab = new CarStartTab(resultSet.getInt(1),
                        new CarType(resultSet.getInt(5),
                                resultSet.getString(6),
                                resultSet.getInt(7),
                                resultSet.getString(8)),
                        resultSet.getInt(3),
                        resultSet.getDate(4));
                list.add(carStartTab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<CarStartTab> findAll() {
        List<CarStartTab> list = new ArrayList<>();
        CarStartTab carStartTab = null;
        try {
            connection = JdbcUtil.getConnection();
            sqlStr = "select * from car_start_tab , car_type where car_id = car_type.id";
            statement = connection.prepareStatement(sqlStr);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carStartTab = new CarStartTab(resultSet.getInt(1),
                        new CarType(resultSet.getInt(5),
                                resultSet.getString(6),
                                resultSet.getInt(7),
                                resultSet.getString(8)),
                        resultSet.getInt(3),
                        resultSet.getDate(4));
                list.add(carStartTab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int insert(CarStartTab carStartTab) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "insert into car_start_tab(car_id,actual_num,start_time)VALUE(?,?,?)";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1,carStartTab.getCarType().getId());
            statement.setInt(2,carStartTab.getActualNum());
            statement.setDate(3,carStartTab.getStartTime());
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection, statement, resultSet);
        }
        return 0;
    }

    @Override
    public int update(CarStartTab carStartTab) {
        try {
            connection = JdbcUtil.getConnection();
            String strSql = "update car_start_tab SET car_id = ? ,actual_num = ? , start_time = ? where id = ? ";
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, carStartTab.getCarType().getId());
            statement.setInt(2, carStartTab.getActualNum());
            statement.setDate(3, carStartTab.getStartTime());
            statement.setInt(4,carStartTab.getId());
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
            String strSql = "delete from car_start_tab where id = ?";
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
            String strSql = "select count(*) from car_start_tab";
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
