package com.neosoft.listener;

import com.neosoft.util.FlowCount;

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
        int num = FlowCount.findFlow();
        num = num - 4 ;
        context = sce.getServletContext();
        context.setAttribute("countPeo", num);
    }

    /**
     * 销毁的监听
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        int num = (int) context.getAttribute("countPeo");
        FlowCount.addFlow(num);
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
     * session销毁
     *
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
