package com.neosoft.controller;

import com.neosoft.entity.CarStartTab;
import com.neosoft.entity.CarType;
import com.neosoft.service.CarStartTabService;
import com.neosoft.service.impl.CarStartTabServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/carStartTab")
public class CarStartTabController extends HttpServlet {

    private CarStartTabService service = new CarStartTabServiceImpl();

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
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
