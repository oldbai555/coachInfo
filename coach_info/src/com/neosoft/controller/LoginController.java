package com.neosoft.controller;

import com.neosoft.entity.Admin;
import com.neosoft.service.AdminService;
import com.neosoft.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("admin");
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(username);
        System.out.println(pwd);
        AdminService admin = new AdminServiceImpl();
        Admin admin1 = admin.login(username, pwd);
        if(admin1!=null){
            req.getSession().setAttribute("admin",admin1);
            resp.getWriter().write("OK");
        }else{
            resp.getWriter().write("NO");
        }

//        resp.sendRedirect("index.jsp");

    }
}
