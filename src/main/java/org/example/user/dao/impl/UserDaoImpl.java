package org.example.user.dao.impl;

import org.example.user.dao.UserDao;
import org.example.user.domain.User;
import org.example.user.util.DateBase;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public int totoUserCount(Map<String, Object> condition) {
        String sql = "select count(*) from user where 1 = 1";

        StringBuilder sb = new StringBuilder(sql);
        Set<String> keys = condition.keySet();
        List<Object> params = new ArrayList<>();

        // 動態添加查詢條件
        for (String key : keys) {
            String value = condition.get(key).toString();
            if (value != null && !"".equals(value)) {
                sb.append(" AND " + key + " LIKE ?");
                params.add("%" + value + "%");  // 使用 LIKE 查詢時需要加上 %
            }
        }

        String finalSql = sb.toString();

        // 使用 try-catch 保護查詢操作
        try {
            // 傳遞參數時使用 params.toArray()
            return jdbcTemplate.queryForObject(finalSql, params.toArray(), Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;  // 如果沒有結果，返回 0
        }
    }


    @Override
    public List<User> getUserLimitByCondition(int start, int limit, Map<String, Object> condition) {
        String sql = "SELECT * FROM user WHERE 1 = 1";

        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();

        for (String key : condition.keySet()) {
            String value = condition.get(key).toString();
            if (value != null && !"".equals(value)) {
                sb.append(" AND " + key + " LIKE ?");
                params.add("%" + value + "%");
            }
        }

        sb.append(" LIMIT ?, ?");
        params.add(start);
        params.add(limit);

        String finalSql = sb.toString();

        return jdbcTemplate.query(finalSql, params.toArray(), new BeanPropertyRowMapper<>(User.class));
    }
}