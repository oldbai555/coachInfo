package com.neosoft.service.impl;

import com.neosoft.service.CarStartTabService;
import com.neosoft.entity.CarStartTab;
import com.neosoft.dao.ICarStartTabDao;
import com.neosoft.dao.impl.CarStartTabDaoImpl;

import java.util.List;

public class CarStartTabServiceImpl implements CarStartTabService{

    private final int LIMIT = 10;
    private ICarStartTabDao info = new CarStartTabDaoImpl();


    @Override
    public List<CarStartTab> findAll() {

        List<CarStartTab> records = info.findAll();
        System.out.println(records);
        return records;
    }

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
    public List<CarStartTab> findAllPage(int page) {
        int index = (page - 1) * LIMIT;
        return info.findAllPage(index,LIMIT);
    }
}
