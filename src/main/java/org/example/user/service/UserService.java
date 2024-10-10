package org.example.user.service;

/*
    用戶管理接口
 */

import org.example.user.domain.User;

import java.util.List;

public interface UserService {


    /**
     * 查詢所有用戶
     * @return
     */
    public List<User> findAll();
}
