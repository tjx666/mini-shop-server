package com.ytj.minishop.controller;

import com.ytj.minishop.entity.User;
import com.ytj.minishop.service.UserService;
import com.ytj.minishop.util.Result;
import com.ytj.minishop.util.ResultGenerator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", consumes = "*/*")
    public Result<String> register(@RequestBody RegisterPostBody body) {
        userService.register(new User(body.getEmail(), body.getName(), body.getPassword(), body.getPhone()));
        return ResultGenerator.genSuccessResult("注册成功!");
    }
}

@Getter
@Setter
class RegisterPostBody {
    private String email;
    private String name;
    private String password;
    private String phone;
}
