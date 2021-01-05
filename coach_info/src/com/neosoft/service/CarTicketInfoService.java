package com.neosoft.service;

import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.CarTicketInfo;

import java.util.List;

public interface CarTicketInfoService {
    int getPages();

    List<CarTicketInfo> findAllPage(int page);

    CarTicketInfo findById(int Id);
}
