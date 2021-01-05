package com.neosoft.controller;

import com.neosoft.dao.impl.CarTicketInfoDaoImpl;
import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.CarTicketInfo;
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
                for (SellTicketInfo info : list){
                    info.setTicketInfo(new CarTicketInfoDaoImpl().findById(info.getTicketInfoId()));
                }
                session.setAttribute("list", list);
                session.setAttribute("dataPrePage", 10);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", service.getPages());
                resp.sendRedirect("sellTicketInfo.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
