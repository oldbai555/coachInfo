package com.neosoft.dao;

import com.neosoft.entity.CarInfo;
import com.neosoft.entity.CarTicketInfo;

import java.util.List;

public interface ICarTicketInfoDao {
    /**
     * 通过Id查找
     *
     * @param id
     * @return
     */
    CarTicketInfo findById(int id);

    /**
     * 通过 汽车类型Id（car_type表中的 id） 进行查找
     *
     * @param carId
     * @return
     */
    CarTicketInfo findByCarId(int carId);

    /**
     * 分页查询
     *
     * @param index 从第几项开始查询
     * @param limit 一次查询几个
     * @return
     */
    List<CarTicketInfo> findAllPage(int index, int limit);

    /**
     * 查找所有
     *
     * @return
     */
    List<CarTicketInfo> findAll();

    /**
     * 三重级联   carTicketInfo的CarInfo属性要有
     * CarInfo属性的CarType属性要有
     * 否则carTicketInfo.getCarInfo().getCarType().getId()
     * 获取不到值
     *
     * @param carTicketInfo
     * @return
     */
    int insert(CarTicketInfo carTicketInfo);

    /**
     * 三重级联   carTicketInfo的CarInfo属性要有
     * CarInfo属性的CarType属性要有
     * 否则carTicketInfo.getCarInfo().getCarType().getId()
     * 获取不到值
     *
     * @param carTicketInfo
     * @return
     */
    int update(CarTicketInfo carTicketInfo);

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
