package com.neosoft.service;

import com.neosoft.entity.CarInfo;

import java.util.List;

public interface CarInfoService {

    int getPages();

    List<CarInfo> findAllPage(int page);

    int insert(CarInfo carInfo);

    int update(CarInfo carInfo);

    int delete(int id);

}
