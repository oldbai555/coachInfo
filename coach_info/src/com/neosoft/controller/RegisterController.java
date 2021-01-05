package com.neosoft.controller;

import com.neosoft.service.AdminService;
import com.neosoft.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(username+pwd);
        AdminService admin = new AdminServiceImpl();
        int flag = admin.register(username,pwd);
        System.out.println(flag);
        if(flag==1){
            resp.getWriter().write("OK");
        }else{
            resp.getWriter().write("NO");
        }
    }
}
