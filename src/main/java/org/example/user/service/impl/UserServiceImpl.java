package org.example.user.service.impl;

import org.example.user.dao.UserDao;
import org.example.user.dao.impl.UserDaoImpl;
import org.example.user.domain.User;
import org.example.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao Dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //調用dao
        return Dao.findAll();
    }
}
