package com.neosoft.service;

import com.neosoft.entity.Admin;

public interface AdminService {
     Admin login(String username, String pwd);

     int register(String username, String pwd);
}
