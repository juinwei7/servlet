package org.example.user.dao;

import org.example.user.domain.Admin;
import org.example.user.domain.User;

import java.util.List;

public interface AdminDao {

    public Admin AdminLogin(String account, String password);
}
