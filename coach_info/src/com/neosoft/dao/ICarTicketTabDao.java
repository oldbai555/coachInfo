package com.neosoft.dao;

import com.neosoft.entity.CarTicketInfo;
import com.neosoft.entity.CarTicketTab;

import java.util.List;

public interface ICarTicketTabDao {

    CarTicketTab findById(int id);

    List<CarTicketTab> findAllPage(int index, int limit);

    List<CarTicketTab> findAll();

    int insert(CarTicketTab ticketTab);

    int update(CarTicketTab ticketTab);

    int deleteById(int id);

    int count();
}
