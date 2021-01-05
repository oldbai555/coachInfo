package com.neosoft;

import com.neosoft.dao.impl.*;
import com.neosoft.entity.CarInfo;
import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.CarTicketTab;
import com.neosoft.entity.CarType;
import com.neosoft.service.CarTicketTabService;
import com.neosoft.service.impl.CarTicketTabServiceImpl;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 老白
 */
public class Main {



    public static void main(String[] args) {
        //获取当前系统时间
        Timestamp dateNow = new Timestamp(System.currentTimeMillis());
        Date reDate = new Date(System.currentTimeMillis());
////        admin Dao层
//        AdminDaoImpl adminDao = new AdminDaoImpl();
//        System.out.println(adminDao.findById(1));
//        System.out.println(adminDao.findByUsername("admin"));
//        System.out.println(adminDao.findByUsernameAndPassword("admin","123456"));
//        System.out.println(adminDao.findByUsername("admin10"));
//        System.out.println(adminDao.findByUsernameAndPassword("admin10","123456"));
//        System.out.println(adminDao.findByUsernameAndPassword("admin","1234561"));
//        CarType 的查询
//        CarTypeDaoImpl typeDao = new CarTypeDaoImpl();
//        System.out.println(typeDao.findById(1));
//        System.out.println(typeDao.findById(17));
//        System.out.println(typeDao.findAll());
//        System.out.println(typeDao.count());
//        System.out.println(typeDao.findAllPage(0,6));
//        System.out.println(typeDao.findAllPage(6,6));
//        System.out.println(typeDao.findAllPage(12,6));
//        System.out.println(typeDao.insert(new CarType("天青牛蟒",100,"桂A-0017")));
//        CarType carType = typeDao.findById(17);
//        carType.setCarName("巨龙战车");
//        System.out.println(typeDao.update(carType));
//        System.out.println(typeDao.deleteById(17));
//        发车记录的dao
//        System.out.println(new CarStartTabDaoImpl().findById(1));
//        System.out.println(new CarStartTabDaoImpl().findAll());
//        System.out.println(new CarStartTabDaoImpl().findAllPage(0,6));
//        System.out.println(new CarStartTabDaoImpl().findAllPage(6,6));
//        System.out.println(new CarStartTabDaoImpl().insert(new CarStartTab(new CarTypeDaoImpl().findById(8),30,reDate)));
//        CarStartTab startTab = new CarStartTabDaoImpl().findById(8);
//        startTab.setActualNum(29);
//        System.out.println(new CarStartTabDaoImpl().update(startTab));
//        System.out.println(new CarStartTabDaoImpl().count());
//        System.out.println(new CarStartTabDaoImpl().deleteById(8));
//        发车信息表
//        System.out.println(new CarInfoDaoImpl().findById(1));
//        System.out.println(new CarInfoDaoImpl().findByCarId(1));
//        System.out.println(new CarInfoDaoImpl().findAll());
//        System.out.println(new CarInfoDaoImpl().findAllPage(0,6));
//        System.out.println(new CarInfoDaoImpl().count());
//        System.out.println(new CarInfoDaoImpl().insert(new CarInfo(17, new CarType("火箭筒",100,"桂A-0018"), "柳州", "吐鲁番", "9:00", 8)));
//        CarInfo carInfo = new CarInfoDaoImpl().findById(16);
//        carInfo.setCar_start_time("9:01");
//        System.out.println(new CarInfoDaoImpl().update(carInfo));
//        System.out.println(new CarInfoDaoImpl().deleteById(17));
//        车票信息表
//        System.out.println(new CarTicketInfoDaoImpl().findById(1));
//        System.out.println(new CarTicketInfoDaoImpl().findByCarId(1));
//        System.out.println(new CarTicketInfoDaoImpl().findAll());
//        System.out.println(new CarTicketInfoDaoImpl().findAllPage(0, 6));
        System.out.println(new SellTicketInfoDaoImpl().findAllPage(0,6));
//        System.out.println(new CarTicketTabDaoImpl().findById(1));
//        CarTicketTabService obj = new CarTicketTabServiceImpl();
//        obj.findAll();
    }

}
