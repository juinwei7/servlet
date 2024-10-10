package org.example.user.service.impl;

import org.example.user.dao.AdminDao;
import org.example.user.dao.UserDao;
import org.example.user.dao.impl.AdminDaoImpl;
import org.example.user.dao.impl.UserDaoImpl;
import org.example.user.domain.Admin;
import org.example.user.domain.User;
import org.example.user.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin getAdmin(String account, String password) {
        return adminDao.AdminLogin(account, password);
    }

    @Override
    public boolean checkPassword(Admin admin, String password) {
        return admin.getPassword().equals(password);
    }


}

