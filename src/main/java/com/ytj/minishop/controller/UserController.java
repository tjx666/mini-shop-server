package com.ytj.minishop.controller;

import com.ytj.minishop.dto.user.LoginPostBody;
import com.ytj.minishop.dto.user.RegisterPostBody;
import com.ytj.minishop.entity.User;
import com.ytj.minishop.service.UserService;
import com.ytj.minishop.util.Result;
import com.ytj.minishop.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 暂时不搞 token 认证
     * @param body
     * @return
     */
    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginPostBody body) {
        if (userService.checkLogin(body.getEmail(), body.getPassword())) {
            return ResultGenerator.genSuccessResult("登入成功！");
        } else {
            return ResultGenerator.genFailResult("登入失败，请检查您的邮箱和密码！");
        }
    }

    @PostMapping(value = "/register")
    public Result<String> register(@RequestBody RegisterPostBody body) {
        if (userService.register(new User(body.getEmail(), body.getName(), body.getPassword(), body.getPhone()))) {
            return ResultGenerator.genSuccessResult("注册成功!");
        } else {
            return ResultGenerator.genFailResult("注册失败，用户可能已存在。");
        }
    }
}




