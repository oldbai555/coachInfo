package com.neosoft.service.impl;

import com.neosoft.dao.impl.CarTicketInfoDaoImpl;
import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.CarTicketInfo;
import com.neosoft.service.CarTicketInfoService;
import com.neosoft.service.CarTicketTabService;

import java.util.List;

public class CarTicketInfoServiceImpl implements CarTicketInfoService {

    private final int LIMIT = 10;
    private CarTicketInfoDaoImpl info = new CarTicketInfoDaoImpl();

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
    public List<CarTicketInfo> findAllPage(int page) {
        int index = (page - 1) * LIMIT;
        return info.findAllPage(index,LIMIT);
    }

    @Override
    public CarTicketInfo findById(int Id) {
        return info.findById(Id);
    }
}
