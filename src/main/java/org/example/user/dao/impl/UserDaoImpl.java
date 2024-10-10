package org.example.user.dao.impl;

import org.example.user.dao.UserDao;
import org.example.user.domain.User;
import org.example.user.util.DateBase;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DateBase.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void addUser(User user) {
            String sql = "INSERT INTO user (name, gander, age, address, phone, email) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAddress(), user.getPhone(), user.getEmail());
    }
}
