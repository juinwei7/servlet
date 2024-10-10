package org.example.user.dao.impl;

import org.example.user.dao.AdminDao;
import org.example.user.domain.Admin;
import org.example.user.util.DateBase;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DateBase.getDataSource());


    @Override
    public Admin AdminLogin(String account, String password) {
        try {
            String sql = "select * from admin where account = ? and password = ?";
            Admin admin = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Admin.class), account, password);
            return admin;
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
