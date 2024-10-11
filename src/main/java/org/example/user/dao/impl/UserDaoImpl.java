package org.example.user.dao.impl;

import org.example.user.dao.UserDao;
import org.example.user.domain.User;
import org.example.user.util.DateBase;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public User getUserById(int id) {
        String sql = "select * from user where id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        } catch (Exception e) {
            return null; // 如果找不到對應的用戶，返回 null
        }
    }

    @Override
    public void addUser(User user) {
            String sql = "INSERT INTO user (name, gender, age, address, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getPhone(), user.getEmail());
    }

    @Override
    public boolean reviseUser(User user) {
        String sql = "UPDATE user SET name = ?, gender = ?, age = ?, address = ?, phone = ?, email = ? WHERE id = ?";
        Integer count = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getPhone(), user.getEmail(), user.getId());
        return count > 0;
    }

    @Override
    public boolean checkEmail(String email) {
        String sql = "select count(*) from user where email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{email}, Integer.class);
        return count != null && count > 0;
    }

    @Override
    public boolean removeUser(String id) {
        String sql = "DELETE from user where id = ?";
        int count = jdbcTemplate.update(sql, id);
        return count > 0;
    }

    @Override
    public int totoUserCount() {
        String sql = "select count(*) from user";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;  // 如果沒有結果，返回0
        }
    }

    @Override
    public List<User> getUserLimit(int start, int limit) {
        String sql = "SELECT * FROM user LIMIT ?, ?";
        return jdbcTemplate.query(sql, new Object[]{start, limit}, new BeanPropertyRowMapper<>(User.class));
    }
}
