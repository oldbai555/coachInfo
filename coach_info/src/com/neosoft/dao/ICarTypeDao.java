package com.neosoft.dao;

import com.neosoft.entity.CarType;

import java.util.List;

public interface ICarTypeDao {

    CarType findById(int id);

    List<CarType> findAllPage(int index, int limit);

    List<CarType> findAll();

    int insert(CarType carType);

    int update(CarType carType);

    int deleteById(int id);

    int count();
}
