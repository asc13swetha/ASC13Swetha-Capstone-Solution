package com.atslogin.service;

import com.atslogin.model.LoginModel;

import java.util.List;

public interface LoginService {
    String login(LoginModel loginModel);
    List<LoginModel> getAllLogin();
    LoginModel getLoginById(Long id);
}

