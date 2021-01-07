package com.neosoft.controller;

import com.neosoft.entity.*;
import com.neosoft.service.CarTicketInfoService;
import com.neosoft.service.CarTicketTabService;
import com.neosoft.service.SellTicketInfoService;
import com.neosoft.service.impl.CarTicketInfoServiceImpl;
import com.neosoft.service.impl.CarTicketTabServiceImpl;
import com.neosoft.service.impl.SellTicketInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/carTicketTab")
public class CarTicketTabController extends HttpServlet {

    private CarTicketTabService service = new CarTicketTabServiceImpl();
    private CarTicketInfoService service1 = new CarTicketInfoServiceImpl();
    private SellTicketInfoService service2 = new SellTicketInfoServiceImpl();

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
                List<CarTicketTab> list = service.findAllPage(page);
                for (CarTicketTab tab : list) {
                    tab.setTicketInfo(service1.findById(tab.getTicketInfoId()));
                }
                session.setAttribute("list", list);
                session.setAttribute("dataPrePage", 10);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", service.getPages());
                resp.sendRedirect("carTicketTab.jsp");
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
         * 买票流程：
         * 登记购票人信息
         * 已售 + 1
         * 如果已售 = 总数
         * 不让购买
         */
        switch (method) {
            case "findAll":
                resp.sendRedirect("/carType?page=1");
                break;
            case "add":
                CarTicketTab tab = service.findById(Integer.parseInt(req.getParameter("id")));
                if (tab.getTicketNum() == tab.getTicketSum()) {
                    resp.getWriter().write("No");
                    resp.sendRedirect("/carTicketTab?page=1");
                    break;
                } else {
                    int ticketInfoId = Integer.parseInt(req.getParameter("ticketInfoId"));
                    String peopleName = req.getParameter("peopleName");
                    String peopleIdCard = req.getParameter("peopleIdCard");
                    int insert = service2.insert(new SellTicketInfo(ticketInfoId, peopleName, peopleIdCard));
                    if (insert != 0) {
                        tab.setTicketSum(tab.getTicketSum() + 1);
                        service.update(tab);
                    }
                    resp.sendRedirect("/carTicketTab?page=1");
                }
                break;
            case "delete":
                service.delete(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("/carTicketTab?page=1");
                break;
        }
    }
}
