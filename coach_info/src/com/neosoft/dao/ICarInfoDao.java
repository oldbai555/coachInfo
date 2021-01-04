package com.neosoft.dao;

import com.neosoft.entity.CarInfo;
import com.neosoft.entity.CarStartTab;

import java.util.List;

public interface ICarInfoDao {

    CarInfo findById(int id);

    CarInfo findByCarId(int carId);

    List<CarInfo> findAllPage(int index, int limit);

    List<CarInfo> findAll();

    int insert(CarInfo carInfo);

    int update(CarInfo carInfo);

    int deleteById(int id);

    int count();

}
