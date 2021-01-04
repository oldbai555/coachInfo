package com.neosoft.dao;

import com.neosoft.entity.Admin;

public interface IAdminDao {

    Admin findById(int id);

    Admin findByUsernameAndPassword(String username, String password);

    Admin findByUsername(String username);

}
