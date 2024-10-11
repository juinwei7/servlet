package org.example.user.service;

/*
    用戶管理接口
 */

import org.example.user.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {


    /**
     * 查詢所有用戶
     * @return
     */
    public List<User> findAll();

    public int totoUserCount();

    public List<User> userByPage(int page, int limit);

    public User getUserById(int id);

    public boolean addUser(User user);

    public boolean reviseUser(int id, Map<String, String[]> inputMap);

    public boolean removeUser(String id);
}
