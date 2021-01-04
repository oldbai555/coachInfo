package com.neosoft.controller;

import com.neosoft.dao.impl.CarTypeDaoImpl;
import com.neosoft.entity.CarType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        HttpSession session = req.getSession();
        List<CarType> list = new CarTypeDaoImpl().findAllPage(0,6);
        session.setAttribute("list",list);
        resp.sendRedirect("index.jsp");
    }
}
