package com.neosoft.controller;

import com.neosoft.dao.impl.CarTicketInfoDaoImpl;
import com.neosoft.dao.impl.CarTypeDaoImpl;
import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.CarTicketTab;
import com.neosoft.entity.CarType;
import com.neosoft.service.CarStartTabService;
import com.neosoft.service.CarTicketTabService;
import com.neosoft.service.impl.CarStartTabServiceImpl;
import com.neosoft.service.impl.CarTicketTabServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/carStartTab")
public class CarStartTabController extends HttpServlet {

    private CarStartTabService service = new CarStartTabServiceImpl();
    private CarTypeDaoImpl dao = new CarTypeDaoImpl();
    private CarTicketTabService service1 = new CarTicketTabServiceImpl();
    /**
     * 获取当前系统时间
     */
    private Timestamp dateNow = new Timestamp(System.currentTimeMillis());
    private Date reDate = new Date(System.currentTimeMillis());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAll";
        }
        HttpSession session = req.getSession();
        switch (method) {
            case "findAll":
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                List<CarStartTab> list = service.findAllPage(page);
                session.setAttribute("list", list);
                session.setAttribute("dataPrePage", 10);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", service.getPages());
                resp.sendRedirect("carStartTab.jsp");
                break;
            case "delete":
                service.delete(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("/carStartTab?page=1");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAll";
        }
        switch (method) {
            case "findAll":
                resp.sendRedirect("/carStartTab?page=1");
                break;
            case "add":
                /**
                 * 发车记录表 需要的数据
                 * 从购票信息表获取购票人数量
                 * 通过车牌号  licensePlate 获取车辆信息存入
                 * 后台自动获取登记时间
                 */
                System.out.println(req.getParameter("licensePlate"));
                CarType carType = dao.findByCard(req.getParameter("licensePlate"));
                int actualNum = service1
                        .findByInfoId(new CarTicketInfoDaoImpl()
                                .findByCarId(carType.getId())
                                .getId())
                        .getTicketSum();
                Date startTime = reDate;
                service.insert(new CarStartTab(carType, actualNum, startTime));
                resp.sendRedirect("/carStartTab?page=1");
                break;
            case "update":
                /**
                 * 更新 ，传入这一数据的id
                 * 输入的人数 actualNum
                 * 获取车牌号 licensePlate
                 */
                carType = dao.findByCard(req.getParameter("licensePlate"));
                CarStartTab tab = service.findById(Integer.parseInt(req.getParameter("id")));
                int num = Integer.parseInt(req.getParameter("actualNum"));
                int sum = Integer.parseInt(req.getParameter("peopleNum"));
                if (sum < num){
                    resp.sendRedirect("/carStartTab?page=1");
                }else {
                    tab.setActualNum(num);
                    tab.setStartTime(reDate);
                    service.update(tab);
                    resp.sendRedirect("/carStartTab?page=1");
                }
                break;

        }
    }
}
