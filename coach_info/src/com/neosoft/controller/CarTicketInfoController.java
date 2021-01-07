package com.neosoft.controller;

import com.neosoft.dao.impl.CarInfoDaoImpl;
import com.neosoft.dao.impl.CarTicketTabDaoImpl;
import com.neosoft.dao.impl.CarTypeDaoImpl;
import com.neosoft.entity.*;
import com.neosoft.service.CarTicketInfoService;
import com.neosoft.service.impl.CarTicketInfoServiceImpl;
import com.neosoft.service.impl.CarTicketTabServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/carTicketInfo")
public class CarTicketInfoController extends HttpServlet {

    private CarTicketInfoService service = new CarTicketInfoServiceImpl();

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
                List<CarTicketInfo> list = service.findAllPage(page);
                session.setAttribute("list", list);
                session.setAttribute("dataPrePage", 10);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", service.getPages());
                resp.sendRedirect("carTicketInfo.jsp");
                break;
            case "delete":
                /**
                 * 车票信息删除后，购票信息页也得删除
                 */
                service.delete(Integer.parseInt(req.getParameter("id")));
                new CarTicketTabDaoImpl().deleteByTicket_info_id(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("/carTicketInfo?page=1");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAll";
        }
        /**
         * 添加操作，
         * 获取车牌号，获取到车辆信息
         * 写上票名
         * 获取车辆的最大承载量
         * 放入车票表
         *
         * 更新操作
         * 更新车票名
         */
        switch (method){
            case "findAll":
                resp.sendRedirect("/carTicketInfo?page=1");
                break;
            case "add":
                String licensePlate = req.getParameter("licensePlate");
                String ticketName = req.getParameter("ticketName");
                CarInfo carInfo = new CarInfoDaoImpl().findByCarId(new CarTypeDaoImpl().findByCard(licensePlate).getId());
                CarTicketInfo ticketInfo = new CarTicketInfo(carInfo,ticketName);
                service.insert(ticketInfo);
                CarTicketInfo info1 = service.findByCarId(carInfo.getCarType().getId());
                new CarTicketTabDaoImpl().insert(new CarTicketTab(info1.getId(),carInfo.getCarType().getPeopleNum(),0));
                resp.sendRedirect("/carTicketInfo?page=1");
                break;
            case "update":
                int id = Integer.parseInt(req.getParameter("id"));
                CarTicketInfo info = service.findById(id);
                info.setTicketName(req.getParameter("ticketName"));
                service.update(info);
                resp.sendRedirect("/carTicketInfo?page=1");
                break;
        }
    }
}
