package com.neosoft.service.impl;

import com.neosoft.entity.CarTicketTab;
import com.neosoft.service.CarTicketTabService;
import com.neosoft.dao.ICarTicketTabDao;
import com.neosoft.dao.impl.CarTicketTabDaoImpl;

import java.util.List;

public class CarTicketTabServiceImpl implements CarTicketTabService {

    ICarTicketTabDao info = new CarTicketTabDaoImpl();
    private final int LIMIT = 10;

    @Override
    public List<CarTicketTab> findAll() {

        List<CarTicketTab> detail = info.findAll();
        System.out.println(detail);
        int a = detail.get(0).getTicketNum();
        int b = detail.get(0).getTicketSum();
        System.out.println(a - b);
        return detail;
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
    public List<CarTicketTab> findAllPage(int page) {
        int index = (page - 1) * LIMIT;
        return info.findAllPage(index,LIMIT);
    }

    @Override
    public int update(CarTicketTab tab) {
        return info.update(tab);
    }

    @Override
    public CarTicketTab findById(int id) {
        return info.findById(id);
    }

    @Override
    public CarTicketTab findByInfoId(int id) {
        return info.findByInfoId(id);
    }

    @Override
    public int delete(int id) {
        return info.deleteById(id);
    }
}
