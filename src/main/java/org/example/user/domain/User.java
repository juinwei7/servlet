package org.example.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String address;
    private String phone;
    private String email;

    @Override
    public String toString() {
        return "id" + id + "\n name" + name + "\n gender" + gender +
                "\n age" + age + "\n address" + address + "\n phone" + phone;
    }
}
