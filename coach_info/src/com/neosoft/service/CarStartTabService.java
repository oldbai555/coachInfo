package com.neosoft.service;

import com.neosoft.entity.CarStartTab;

import java.util.List;

public interface CarStartTabService {
    List<CarStartTab> findAll();

    int getPages();

    List<CarStartTab> findAllPage(int page);

}
