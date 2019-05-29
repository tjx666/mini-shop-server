package com.ytj.minishop.service;

import com.ytj.minishop.entity.User;

public interface UserService {
    public boolean register(User user);
    public boolean checkLogin(String email, String password);
}
