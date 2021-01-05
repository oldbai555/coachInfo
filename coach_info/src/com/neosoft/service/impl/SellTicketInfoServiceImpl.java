package com.neosoft.service.impl;

import com.neosoft.dao.impl.SellTicketInfoDaoImpl;
import com.neosoft.entity.SellTicketInfo;
import com.neosoft.service.SellTicketInfoService;

import java.util.List;

public class SellTicketInfoServiceImpl implements SellTicketInfoService {

    private final int LIMIT = 10;
    private SellTicketInfoDaoImpl info = new SellTicketInfoDaoImpl();


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
    public List<SellTicketInfo> findAllPage(int page) {
        int index = (page - 1) * LIMIT;
        return info.findAllPage(index,LIMIT);
    }
}
