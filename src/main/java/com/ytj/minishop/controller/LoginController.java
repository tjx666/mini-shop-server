package com.ytj.minishop.controller;

import com.ytj.minishop.service.UserService;
import com.ytj.minishop.util.Result;
import com.ytj.minishop.util.ResultGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class LoginController {
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
}

@Getter
@Setter
@ToString
class LoginPostBody {
    private String email;
    private String password;
}
