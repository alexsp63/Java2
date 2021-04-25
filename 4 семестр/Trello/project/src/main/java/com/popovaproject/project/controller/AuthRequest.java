package com.popovaproject.project.controller;

import lombok.Data;

@Data
public class AuthRequest {

    //проверка будет идти по этим полям
    private String username;
    private String password;

    public String getLogin() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
