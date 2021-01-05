package com.neosoft.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class CountPeopleListener implements ServletContextListener, HttpSessionListener {


    private ServletContext context = null;

    /**
     * 创建的监听
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        context.setAttribute("countPeo", -4);
    }

    /**
     * 销毁的监听
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    /**
     * session创建
     *
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int num = (int) context.getAttribute("countPeo");
        num = num + 1 ;
        context.setAttribute("countPeo", num);
    }

    /**
     * session创建
     *
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
