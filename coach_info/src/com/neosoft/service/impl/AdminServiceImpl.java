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
        if(adm!=null){
            System.out.println("管理员登录成功");
            return adm;
        }
        else{
            return null;
        }
    }
}
