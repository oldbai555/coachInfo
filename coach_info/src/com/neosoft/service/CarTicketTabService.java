package com.neosoft.service;
//展示车票、剩余总量 sum-num
import com.neosoft.entity.CarTicketTab;

import java.util.List;

public interface CarTicketTabService {
    List<CarTicketTab> findAll();

    int getPages();

    List<CarTicketTab> findAllPage(int page);

    int update(CarTicketTab tab);

    CarTicketTab findById(int id);

    CarTicketTab findByInfoId(int id);

    int delete(int id);


}
