package com.educando.course.dto.user;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serial;
import java.io.Serializable;


public class UserPostRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;
    @NotEmpty(message = "the User name can't be empty ")
    private String name;
    @NotEmpty(message = "the User email can't be empty ")
    private String email;
    @NotEmpty(message = "the User phone can't be empty ")
    private String phone;
    @NotEmpty(message = "the User password can't be empty ")
    private String password;

    public UserPostRequest(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
