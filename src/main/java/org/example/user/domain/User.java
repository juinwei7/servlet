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

    public User() {}

    public User setUser(int id, String name, String gender, int age, String address, String phone, String email) {
        if (name == null || gender == null || age < 0 || address == null || phone == null) {
            return null;
        }else {
            this.setId(id);
            this.setName(name);
            this.setGender(gender);
            this.setAge(age);
            this.setAddress(address);
            this.setPhone(phone);
            this.setEmail(email);
            return this;
        }
    }
}
