package com.ytj.minishop.dto.user;

import lombok.Getter;
import lombok.Setter;

public @Getter
@Setter
class RegisterPostBody {
    private String email;
    private String name;
    private String password;
    private String phone;
}