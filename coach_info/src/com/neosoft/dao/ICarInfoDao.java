package com.neosoft.dao;

import com.neosoft.entity.CarInfo;
import com.neosoft.entity.CarStartTab;

import java.util.List;

public interface ICarInfoDao {
    /**
     * 通过Id查询
     *
     * @param id
     * @return
     */
    CarInfo findById(int id);

    /**
     * 通过 汽车型号 也就是 car_type表的id查询
     *
     * @param carId
     * @return
     */
    CarInfo findByCarId(int carId);

    /**
     * 分页查询
     *
     * @param index 从第几项开始查询
     * @param limit 一次查询几个
     * @return
     */
    List<CarInfo> findAllPage(int index, int limit);

    /**
     * 查找所有
     *
     * @return
     */
    List<CarInfo> findAll();

    /**
     * 插入一个 carInfo对象
     * 这个carInfo对象的属性carType必须有，
     * 而且是car_type中数据
     * 否则获取不到 carInfo.getCarType().getId()
     *
     * @param carInfo
     * @return
     */
    int insert(CarInfo carInfo);

    /**
     * 更新一个 carInfo对象
     * 这个carInfo对象的属性carType必须有，
     * 而且是car_type中数据
     * 否则获取不到 carInfo.getCarType().getId()
     *
     * @param carInfo
     * @return
     */
    int update(CarInfo carInfo);

    /**
     * 通过Id删除 这个没什么要求
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
