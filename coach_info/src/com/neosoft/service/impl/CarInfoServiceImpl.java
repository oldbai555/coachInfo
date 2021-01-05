package com.neosoft.service.impl;

import com.neosoft.dao.ICarInfoDao;
import com.neosoft.dao.impl.CarInfoDaoImpl;
import com.neosoft.entity.CarInfo;
import com.neosoft.service.CarInfoService;

import java.util.List;

public class CarInfoServiceImpl implements CarInfoService {

    private ICarInfoDao info = new CarInfoDaoImpl();
    private final int LIMIT = 10;

    @Override
    public int getPages() {
        int count = info.count();
        int page = 0;
        if (count % LIMIT == 0) {
            page = count / LIMIT;
        } else {
            page = count / LIMIT + 1;
        }
        return page;
    }

    @Override
    public List<CarInfo> findAllPage(int page) {
        int index = (page - 1) * LIMIT;
        return info.findAllPage(index,LIMIT);
    }
}
