package com.educando.course.dto.user;

import java.io.Serial;
import java.io.Serializable;

public class UserPutRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;
    private String name;
    private String email;
    private String phone;

    public UserPutRequest(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
