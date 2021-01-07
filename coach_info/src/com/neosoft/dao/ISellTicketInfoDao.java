package com.neosoft.dao;

import com.neosoft.entity.CarTicketTab;
import com.neosoft.entity.SellTicketInfo;

import java.util.List;

public interface ISellTicketInfoDao {
    /**
     * 通过Id查找
     *
     * @param id
     * @return
     */
    SellTicketInfo findById(int id);

    SellTicketInfo findByTicketInfoId(int ticketInfoId);

    List<SellTicketInfo> findAllPageLike(int index, int limit ,String str);

    /**
     * @param index 从第几项开始查询
     * @param limit 一次查询几个
     * @return
     */
    List<SellTicketInfo> findAllPage(int index, int limit);

    /**
     * 查找所有
     *
     * @return
     */
    List<SellTicketInfo> findAll();

    /**
     * 插入一条数据
     *
     * @param sellTicketInfo
     * @return
     */
    int insert(SellTicketInfo sellTicketInfo);

    /**
     * 更新数据
     *
     * @param sellTicketInfo
     * @return
     */
    int update(SellTicketInfo sellTicketInfo);

    /**
     * 通过Id删除数据
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 计算所有数据的数目
     *
     * @return
     */
    int count();

}
