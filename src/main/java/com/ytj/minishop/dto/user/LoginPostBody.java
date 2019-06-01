package com.ytj.minishop.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginPostBody {
    private String email;
    private String password;
}
