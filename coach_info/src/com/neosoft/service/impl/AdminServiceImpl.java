package com.neosoft.service.impl;

import com.neosoft.dao.IAdminDao;
import com.neosoft.dao.impl.AdminDaoImpl;
import com.neosoft.entity.Admin;
import com.neosoft.service.AdminService;

public class AdminServiceImpl implements AdminService {
    @Override
    public Admin login(String username, String pwd) {
        IAdminDao admin = new AdminDaoImpl();
        Admin adm = admin.findByUsernameAndPassword(username,pwd);
        System.out.println(adm);
        if(adm!=null){
            System.out.println("管理员登录成功");
            return adm;
        }
        else{
            System.out.println("管理员不存在或密码错误");
            return null;
        }
    }

    @Override
    public int register(String username, String pwd) {
        IAdminDao admin = new AdminDaoImpl();
        int flag = admin.insert(username,pwd);
        if(flag!=0){
            System.out.println("用户添加成功");
            return 1;
        }else{
            System.out.println("用户添加失败");
        }
        return 0;
    }
}
