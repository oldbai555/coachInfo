package com.neosoft.dao;

import com.neosoft.entity.CarInfo;
import com.neosoft.entity.CarTicketInfo;

import java.util.List;

public interface ICarTicketInfoDao {
    CarTicketInfo findById(int id);

    CarTicketInfo findByCarId(int carId);

    List<CarTicketInfo> findAllPage(int index, int limit);

    List<CarTicketInfo> findAll();

    int insert(CarTicketInfo carTicketInfo);

    int update(CarTicketInfo carTicketInfo);

    int deleteById(int id);

    int count();

}
