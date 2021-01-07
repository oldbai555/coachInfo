package com.neosoft.controller;

import com.neosoft.dao.impl.CarTicketInfoDaoImpl;
import com.neosoft.dao.impl.CarTicketTabDaoImpl;
import com.neosoft.dao.impl.CarTypeDaoImpl;
import com.neosoft.dao.impl.SellTicketInfoDaoImpl;
import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.CarTicketInfo;
import com.neosoft.entity.CarTicketTab;
import com.neosoft.entity.SellTicketInfo;
import com.neosoft.service.SellTicketInfoService;
import com.neosoft.service.impl.SellTicketInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/sellTicketInfo")
public class SellTicketInfoController extends HttpServlet {

    private SellTicketInfoService service = new SellTicketInfoServiceImpl();

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
                List<SellTicketInfo> list = service.findAllPage(page);
                for (SellTicketInfo info : list) {
                    info.setTicketInfo(new CarTicketInfoDaoImpl().findById(info.getTicketInfoId()));
                }
                session.setAttribute("list", list);
                session.setAttribute("dataPrePage", 10);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", service.getPages());
                resp.sendRedirect("sellTicketInfo.jsp");
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                SellTicketInfo ticketInfo = new SellTicketInfoDaoImpl().findById(id);
                CarTicketTab ticketTab = new CarTicketTabDaoImpl().findByInfoId(ticketInfo.getTicketInfoId());
                ticketTab.setTicketSum(ticketTab.getTicketSum() - 1);
                new CarTicketTabDaoImpl().update(ticketTab);
                new SellTicketInfoDaoImpl().deleteById(id);
                resp.sendRedirect("/sellTicketInfo?page=1");
                break;
            case "like":
                list = new SellTicketInfoDaoImpl().findAllPageLike(0,50,req.getParameter("likeName"));
                for (SellTicketInfo info : list) {
                    info.setTicketInfo(new CarTicketInfoDaoImpl().findById(info.getTicketInfoId()));
                }
                session.setAttribute("list", list);
                session.setAttribute("currentPage", 1);
                session.setAttribute("pages", 1);
                session.setAttribute("dataPrePage", 50);
                resp.sendRedirect("sellTicketInfo.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 改签操作
         * 获取车牌号
         * 需要改签的车牌号
         * 原有的车票号的已售数量 - 1
         * 现有的车票号的已售数量 +1
         * 更新乘客的乘坐车辆
         */
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAll";
        }
        switch (method) {
            case "findAll":
                resp.sendRedirect("/sellTicketInfo?page=1");
                break;
            case "update":
                String plate = req.getParameter("licensePlate1");
                String plate1 = req.getParameter("licensePlate");
//                得到车票信息表的 id
                int id = new CarTicketInfoDaoImpl().findByCarId(new CarTypeDaoImpl().findByCard(plate).getId()).getId();
                int id1 = new CarTicketInfoDaoImpl().findByCarId(new CarTypeDaoImpl().findByCard(plate1).getId()).getId();
                CarTicketTab tab = new CarTicketTabDaoImpl().findByInfoId(id);
                CarTicketTab tab1 = new CarTicketTabDaoImpl().findByInfoId(id1);
                tab.setTicketSum(tab.getTicketSum() - 1);
                tab1.setTicketSum(tab1.getTicketSum() + 1);
                new CarTicketTabDaoImpl().update(tab);
                new CarTicketTabDaoImpl().update(tab1);
//                更新用户信息
                int id2 = Integer.parseInt(req.getParameter("id"));
                SellTicketInfo ticketInfo = new SellTicketInfoDaoImpl().findById(id2);
                ticketInfo.setTicketInfoId(id1);
                new SellTicketInfoDaoImpl().update(ticketInfo);
                resp.sendRedirect("/sellTicketInfo?page=1");
                break;
        }
    }
}
