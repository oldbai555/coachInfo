package com.neosoft.service.impl;

import com.neosoft.entity.CarTicketTab;
import com.neosoft.service.CarStartTabService;
import com.neosoft.service.CarTicketTabService;
import com.neosoft.dao.ICarTicketTabDao;
import com.neosoft.dao.impl.CarTicketTabDaoImpl;
import java.util.List;

public class CarTicketTabServiceImpl implements CarTicketTabService{
    @Override
    public List<CarTicketTab> findAll() {
        ICarTicketTabDao info = new CarTicketTabDaoImpl();
        List<CarTicketTab> detail = info.findAll();
        System.out.println(detail);
        int a = detail.get(0).getTicketNum();
        int b = detail.get(0).getTicketSum();
        System.out.println(a-b);
        return detail;
    }
}
