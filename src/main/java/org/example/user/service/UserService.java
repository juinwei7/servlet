package org.example.user.service;

/*
    用戶管理接口
 */

import org.example.user.domain.PageBean;
import org.example.user.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {


    /**
     * 查詢所有用戶
     * @return
     */
    public List<User> findAll();

    public int totoUserCount(Map<String, Object> map);

    public User getUserById(int id);

    public boolean addUser(User user);

    public boolean reviseUser(int id, Map<String, String[]> inputMap);

    public boolean removeUser(String id);

    /**
     * 依據頁碼獲取用戶
     * @param currentPage 頁碼
     * @param rows  共幾條數據
     * @return
     */
    public PageBean<User> getUserByPage(int currentPage, int rows, Map<String, String[]> inputMap);
}
