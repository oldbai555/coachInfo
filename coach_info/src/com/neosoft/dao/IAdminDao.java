package com.neosoft.dao;

import com.neosoft.entity.Admin;

public interface IAdminDao {
    /**
     * 通过Id查询
     *
     * @param id
     * @return
     */
    Admin findById(int id);

    /**
     * 通过账号密码查询
     *
     * @param username
     * @param password
     * @return
     */
    Admin findByUsernameAndPassword(String username, String password);

    /**
     * 通过用户名查询
     *
     * @param username
     * @return
     */
    Admin findByUsername(String username);

    int insert(String username,String pwd);

}
