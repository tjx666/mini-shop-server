package com.ytj.minishop.service.impl;

import com.ytj.minishop.entity.User;
import com.ytj.minishop.repository.UserRepository;
import com.ytj.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(User user) {
        userRepository.save(user);
    }
}
