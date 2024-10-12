package org.example.user.dao;


import org.example.user.domain.User;

import java.util.List;
import java.util.Map;

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

    public int totoUserCount(Map<String, Object> condition);

    public List<User> getUserLimitByCondition(int start, int limit, Map<String, Object> condition);

}
