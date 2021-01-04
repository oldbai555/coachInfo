package com.neosoft.service;

import com.neosoft.entity.CarType;

import java.util.List;

public interface CarTypeService {

    int getPages();

    List<CarType> findAllPage(int page);

}
