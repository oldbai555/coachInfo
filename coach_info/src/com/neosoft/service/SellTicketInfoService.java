package com.neosoft.service;

import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.SellTicketInfo;

import java.util.List;

public interface SellTicketInfoService {

    int getPages();

    List<SellTicketInfo> findAllPage(int page);
}
