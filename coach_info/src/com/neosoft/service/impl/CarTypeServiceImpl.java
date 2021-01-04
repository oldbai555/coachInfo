package com.neosoft.service.impl;

import com.neosoft.dao.impl.CarTypeDaoImpl;
import com.neosoft.entity.CarType;
import com.neosoft.service.CarTypeService;

import java.util.List;

public class CarTypeServiceImpl implements CarTypeService {

    private CarTypeDaoImpl carTypeDao = new CarTypeDaoImpl();
    private final int LIMIT = 10;

    @Override
    public int getPages() {
        int count = carTypeDao.count();
        int page = 0;
        if (count % LIMIT == 0) {
            page = count / LIMIT;
        } else {
            page = count / LIMIT + 1;
        }
        return page;
    }

    @Override
    public List<CarType> findAllPage(int page) {
        int index = (page - 1) * LIMIT;
        return carTypeDao.findAllPage(index,LIMIT);
    }
}
