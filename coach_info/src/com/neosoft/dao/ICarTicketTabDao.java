package com.neosoft.dao;

import com.neosoft.entity.CarTicketInfo;
import com.neosoft.entity.CarTicketTab;

import java.util.List;

public interface ICarTicketTabDao {
    /**
     * 通过Id查询
     *
     * @param id
     * @return
     */
    CarTicketTab findById(int id);

    CarTicketTab findByInfoId(int infoId);
    /**
     * 分页查询
     *
     * @param index 从第几项开始查询
     * @param limit 一次查询几个
     * @return
     */
    List<CarTicketTab> findAllPage(int index, int limit);

    /**
     * 查询所有
     *
     * @return
     */
    List<CarTicketTab> findAll();

    /**
     * 插入一条数据
     *
     * @param ticketTab
     * @return
     */
    int insert(CarTicketTab ticketTab);

    /**
     * 更新一条数据
     *
     * @param ticketTab
     * @return
     */
    int update(CarTicketTab ticketTab);

    /**
     * 通过Id删除
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    int deleteByTicket_info_id(int id);

    /**
     * 获取所有数据的数量
     *
     * @return
     */
    int count();
}
