package com.neosoft;

import com.neosoft.dao.impl.*;
import com.neosoft.entity.*;
import com.neosoft.service.CarTicketTabService;
import com.neosoft.service.impl.CarStartTabServiceImpl;
import com.neosoft.service.impl.CarTicketTabServiceImpl;
import com.neosoft.service.impl.SellTicketInfoServiceImpl;

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
//        System.out.println(new SellTicketInfoDaoImpl().findAllPage(0,6));
//        System.out.println(new CarTicketTabDaoImpl().findById(1));
//        CarTicketTabService obj = new CarTicketTabServiceImpl();
//        obj.findAll();
//  +++001
//        CarType carType = new CarType("测试一号车", 300, "桂A-0050");
//        //将车种添加进入表，添加成功则进行下一步。
//        int insert = 0;
//        try {
//            insert = new CarTypeDaoImpl().insert(carType);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //车种信息添加成功后获取该车种的 id
//        if (insert == 0) {
//            System.out.println("no");
//        } else {
//            CarType carType1 = new CarTypeDaoImpl().findByCard(carType.getLicensePlate());
//            CarInfo carInfo = new CarInfo(carType1,"routeStart","routeEnd","car_start_time",2);
//            System.out.println(new CarInfoDaoImpl().insert(carInfo));
//        }
//  +++001
//        CarTicketTab tab = new CarTicketTabServiceImpl().findById(1);
//        if (tab.getTicketNum() == tab.getTicketSum()){
//            System.out.println("NO");
//        }else {
//            int ticketInfoId = 1;
//            String peopleName = "王小明";
//            String peopleIdCard = "45222000100010005";
//            int insert = new SellTicketInfoServiceImpl().insert(new SellTicketInfo(ticketInfoId, peopleName, peopleIdCard));
//            if (insert != 0){
//                tab.setTicketSum(tab.getTicketSum()+1);
//                System.out.println(new CarTicketTabServiceImpl().update(tab));
//            }
//        }
//         --------1
//        CarType carType = new CarTypeDaoImpl().findByCard("桂A-0001");
//        int actualNum = new CarTicketTabServiceImpl()
//                .findByInfoId(new CarTicketInfoDaoImpl()
//                        .findByCarId(carType.getId())
//                        .getId())
//                .getTicketSum();
//        Date startTime = reDate;
//        System.out.println(new CarStartTabServiceImpl().insert(new CarStartTab(carType, actualNum, startTime)));

        CarType carType = new CarTypeDaoImpl().findByCard("桂A-0001");
        CarStartTab tab = new CarStartTabServiceImpl().findById(17);
        tab.setActualNum(5);
        tab.setStartTime(reDate);
        System.out.println(new CarStartTabServiceImpl().update(tab));

    }

}
