package org.example.user.dao;


import org.example.user.domain.User;

import java.util.List;

/**
 * 用戶操作的Dao
 */
public interface UserDao {

    public List<User> findAll();

    public User getUserById(int id);

    public void addUser(User user);

    public boolean reviseUser(User user);

    public boolean checkEmail(String email);

    public boolean removeUser(String id);

    public int totoUserCount();

    public List<User> getUserLimit(int start, int limit);

}
