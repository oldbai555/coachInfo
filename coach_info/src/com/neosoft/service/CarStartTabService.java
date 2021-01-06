package com.neosoft.service;

import com.neosoft.entity.CarStartTab;

import java.util.List;

public interface CarStartTabService {
    CarStartTab findById(int id);

    List<CarStartTab> findAll();

    int getPages();

    List<CarStartTab> findAllPage(int page);

    int insert(CarStartTab tab);

    int update(CarStartTab tab);

    int delete(int id);

}
