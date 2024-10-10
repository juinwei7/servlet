package org.example.user.dao;


import org.example.user.domain.User;

import java.util.List;

/**
 * 用戶操作的Dao
 */
public interface UserDao {

    public List<User> findAll();

    public void addUser(User user);

}
