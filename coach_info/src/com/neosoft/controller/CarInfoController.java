package com.neosoft.controller;

import com.google.gson.Gson;
import com.neosoft.dao.impl.CarTypeDaoImpl;
import com.neosoft.entity.CarInfo;
import com.neosoft.entity.CarType;
import com.neosoft.service.CarInfoService;
import com.neosoft.service.impl.CarInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/carType")
public class CarInfoController extends HttpServlet {
    private CarInfoService service = new CarInfoServiceImpl();
    private CarTypeDaoImpl dao = new CarTypeDaoImpl();

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
                List<CarInfo> list = service.findAllPage(page);
                session.setAttribute("list", list);
                session.setAttribute("dataPrePage", 10);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", service.getPages());
                resp.sendRedirect("carType.jsp");
                break;
            case "toIndex":
                pageStr = req.getParameter("page");
                page = Integer.parseInt(pageStr);
                list = service.findAllPage(page);
                session.setAttribute("list", list);
                session.setAttribute("dataPrePage", 10);
                session.setAttribute("currentPage", page);
                session.setAttribute("pages", service.getPages());
                resp.sendRedirect("carType.jsp");
                break;
            case "delete":
                /**
                 * 删除该车型
                 */
                dao.deleteById(dao.findByCard(req.getParameter("licensePlate")).getId());
                service.delete(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("/carType?page=1");
                break;
            case "select":
                List<CarType> all = dao.findAll();
                Gson gson = new Gson();
//                System.out.println(all);
                session.setAttribute("selectCarType",all);
                resp.getWriter().write(gson.toJson(all));
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "findAll";
        }
        switch (method) {
            case "findAll":
                resp.sendRedirect("/carType?page=1");
                break;
            case "add":
                CarType carType = new CarType(req.getParameter("carName"),
                        Integer.parseInt(req.getParameter("peopleNum")),
                        req.getParameter("licensePlate"));
                //将车种添加进入表，添加成功则进行下一步。
                int insert = dao.insert(carType);
                //车种信息添加成功后获取该车种的 id
                if (insert == 0) {
                    resp.getWriter().write("NO");
                } else {
                    CarType carType1 = dao.findByCard(carType.getLicensePlate());
                    //把car_info的信息完善
                    CarInfo carInfo = new CarInfo(carType1,
                            req.getParameter("routeStart"),
                            req.getParameter("routeEnd"),
                            req.getParameter("car_start_time"),
                            Double.parseDouble(req.getParameter("probably_time")));
                    service.insert(carInfo);
                    resp.sendRedirect("/carType?page=1");
                }
                break;
            case "update":
                CarType carTypeUpdate = dao.findByCard(req.getParameter("licensePlate"));
                carTypeUpdate.setCarName(req.getParameter("carName"));
                carTypeUpdate.setPeopleNum(Integer.parseInt(req.getParameter("peopleNum")));
                //将车种添加进入表，添加成功则进行下一步。
                int update = dao.update(carTypeUpdate);
                //车种信息添加成功后获取该车种的 id
                if (update == 0) {
                    resp.getWriter().write("NO");
                } else {
                    CarType carType1 = dao.findByCard(carTypeUpdate.getLicensePlate());
                    //把car_info的信息完善
                    CarInfo carInfo = new CarInfo(carType1,
                            req.getParameter("routeStart"),
                            req.getParameter("routeEnd"),
                            req.getParameter("car_start_time"),
                            Double.parseDouble(req.getParameter("probably_time")));
                    service.update(carInfo);
                    resp.sendRedirect("/carType?page=1");
                }

                break;

        }
    }
}
