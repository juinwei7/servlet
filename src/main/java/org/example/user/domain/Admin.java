package org.example.user.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private int id;
    private String account;
    private String password;
    private String adminName;

    @Override
    public String toString() {
        return "id" + id + "\n account" + account + "\n password" + password +
                "\n adminName" + adminName;
    }
}
