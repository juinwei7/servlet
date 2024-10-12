package org.example.user.service.impl;

import org.example.user.dao.UserDao;
import org.example.user.dao.impl.UserDaoImpl;
import org.example.user.domain.PageBean;
import org.example.user.domain.User;
import org.example.user.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao Dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return Dao.findAll();
    }

    @Override
    public int totoUserCount(Map<String, Object> map) {
        return Dao.totoUserCount(map);
    }

    @Override
    public User getUserById(int id) {
        return Dao.getUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        if (Dao.checkEmail(user.getEmail())) {
            return false;
        }
        Dao.addUser(user);
        return true;
    }

    @Override
    public boolean reviseUser(int id, Map<String, String[]> inputMap) {

        User user = Dao.getUserById(id);
        if (user == null) return false;

        String inputName = inputMap.get("inputName")[0];
        String inputGender = inputMap.get("inputGender")[0];
        String inputAge = inputMap.get("inputAge")[0];
        String inputAdderss = inputMap.get("inputAdderss")[0];
        String inputPhone = inputMap.get("inputPhone")[0];
        String inputEmail = inputMap.get("inputEmail")[0];

        // 如果输入值有问题，返回false
        if (inputName == null || inputGender == null || inputAge == null || inputAdderss == null
                || inputPhone == null || inputEmail == null) {
            return false;
        }

        //先檢查mail
        if (Dao.checkEmail(inputEmail)) {
            if (!user.getEmail().equalsIgnoreCase(inputEmail)) {
                return false;
            }
        }

        user.setEmail(inputEmail);
        user.setName(inputName);
        user.setGender(inputGender);
        user.setAge(Integer.parseInt(inputAge));
        user.setAddress(inputAdderss);
        user.setPhone(inputPhone);
        user.setEmail(inputEmail);

        return Dao.reviseUser(user);
    }

    @Override
    public boolean removeUser(String id) {
        return Dao.removeUser(id);
    }

    @Override
    public PageBean<User> getUserByPage(int currentPage, int rows, Map<String, String[]> inputMap) {
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        int start = (currentPage - 1) * rows;

        Map<String, Object> params = new HashMap<>();
        if (inputMap != null) {
            if (inputMap.get("name") != null) {
                params.put("name", inputMap.get("name")[0]);
            }
            if (inputMap.get("address") != null) {
                params.put("address", inputMap.get("address")[0]);
            }
            if (inputMap.get("email") != null) {
                params.put("email", inputMap.get("email")[0]);
            }
        }
        pageBean.setTotalCount(Dao.totoUserCount(params));
        pageBean.setList(Dao.getUserLimitByCondition(start, rows, params));

        int totoPage = totoUserCount(params) / rows + (totoUserCount(params) % rows == 0 ? 0 : 1);
        pageBean.setTotalPage(totoPage);
        return pageBean;
    }
}
