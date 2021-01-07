package com.neosoft.controller;

import com.google.gson.Gson;
import com.neosoft.dao.impl.CarInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/countNum")
public class CountNumController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "zhexian":
                resp.getWriter().write(new Gson().toJson(new CarInfoDaoImpl().findPTime()));
        }
    }
}
