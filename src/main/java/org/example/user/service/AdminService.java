package org.example.user.service;

import org.example.user.domain.Admin;

public interface AdminService {
    public Admin getAdmin(String account, String password);

    public boolean checkPassword(Admin admin, String password);

}
