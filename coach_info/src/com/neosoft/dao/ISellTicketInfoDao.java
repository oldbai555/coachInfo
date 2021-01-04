package com.neosoft.dao;

import com.neosoft.entity.CarTicketTab;
import com.neosoft.entity.SellTicketInfo;

import java.util.List;

public interface ISellTicketInfoDao {

    SellTicketInfo findById(int id);

    List<SellTicketInfo> findAllPage(int index, int limit);

    List<SellTicketInfo> findAll();

    int insert(SellTicketInfo sellTicketInfo);

    int update(SellTicketInfo sellTicketInfo);

    int deleteById(int id);

    int count();

}
