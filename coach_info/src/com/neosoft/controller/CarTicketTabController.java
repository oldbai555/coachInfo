package com.neosoft.controller;

import com.neosoft.entity.CarInfo;
import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.CarTicketInfo;
import com.neosoft.entity.CarTicketTab;
import com.neosoft.service.CarTicketInfoService;
import com.neosoft.service.CarTicketTabService;
import com.neosoft.service.impl.CarTicketInfoServiceImpl;
import com.neosoft.service.impl.CarTicketTabServiceImpl;

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
                for (CarTicketTab tab : list){
                    tab.setTicketInfo(service1.findById(tab.getId()));
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
        super.doPost(req, resp);
    }
}
