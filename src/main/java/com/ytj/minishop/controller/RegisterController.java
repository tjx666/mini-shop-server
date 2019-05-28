package com.ytj.minishop.controller;

import com.ytj.minishop.entity.User;
import com.ytj.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public void register() {
        User user = new User("2713151713@qq.com", "ly", "5391848");
        userService.register(user);
    }
}
