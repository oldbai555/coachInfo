package com.neosoft.dao;

import com.neosoft.entity.CarStartTab;

import java.util.List;


public interface ICarStartTabDao {

    CarStartTab findById(int id);

    List<CarStartTab> findAllPage(int index, int limit);

    List<CarStartTab> findAll();

    int insert(CarStartTab carStartTab);

    int update(CarStartTab carStartTab);

    int deleteById(int id);

    int count();

}
