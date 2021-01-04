package com.neosoft.dao;

import com.neosoft.entity.CarType;

import java.util.List;

public interface ICarTypeDao {
    /**
     * 通过Id查找
     *
     * @param id
     * @return
     */
    CarType findById(int id);

    /**
     * 分页查询
     *
     * @param index 从第几项开始查询
     * @param limit 一次查询几个
     * @return
     */
    List<CarType> findAllPage(int index, int limit);

    /**
     * 查找所有
     *
     * @return
     */
    List<CarType> findAll();

    /**
     * 插入一条数据
     *
     * @param carType
     * @return
     */
    int insert(CarType carType);

    /**
     * 更新一条数据
     *
     * @param carType
     * @return
     */
    int update(CarType carType);

    /**
     * 删除一条数据通过Id
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 获取所有数据的总和
     *
     * @return
     */
    int count();
}
