package com.neosoft.dao;

import com.neosoft.entity.CarStartTab;

import java.util.List;


public interface ICarStartTabDao {
    /**
     * 通过Id查询
     *
     * @param id
     * @return
     */
    CarStartTab findById(int id);

    /**
     * 分页查询
     *
     * @param index 从第几项开始查询
     * @param limit 一次查询几个
     * @return
     */
    List<CarStartTab> findAllPage(int index, int limit);

    /**
     * 查找所有
     *
     * @return
     */
    List<CarStartTab> findAll();

    /**
     * 插入一个 carInfo对象
     * 这个carInfo对象的属性carType必须有，
     * 而且是car_type中数据
     * 否则获取不到 carStartTab.getCarType().getId()
     *
     * @param carStartTab
     * @return
     */
    int insert(CarStartTab carStartTab);

    /**
     * 更新一个 carInfo对象
     * 这个carInfo对象的属性carType必须有，
     * 而且是car_type中数据
     * 否则获取不到 carStartTab.getCarType().getId()
     *
     * @param carStartTab
     * @return
     */
    int update(CarStartTab carStartTab);

    /**
     * 通过Id删除
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 获取共有多少条数据
     *
     * @return
     */
    int count();

}
