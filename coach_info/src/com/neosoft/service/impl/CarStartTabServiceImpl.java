package com.neosoft.service.impl;

import com.neosoft.entity.CarTicketTab;
import com.neosoft.service.CarStartTabService;
import com.neosoft.entity.CarStartTab;
import com.neosoft.dao.ICarStartTabDao;
import com.neosoft.dao.impl.CarStartTabDaoImpl;
import com.neosoft.service.CarTicketTabService;

import java.util.List;

public class CarStartTabServiceImpl implements CarStartTabService{
    @Override
    public List<CarStartTab> findAll() {
        ICarStartTabDao info = new CarStartTabDaoImpl();
        List<CarStartTab> records = info.findAll();
        System.out.println(records);
        return records;
    }
}
