package com.ytj.minishop.service.impl;

import com.ytj.minishop.entity.User;
import com.ytj.minishop.repository.UserRepository;
import com.ytj.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean register(User user) {
        Optional<User> oldUser = userRepository.findById(user.getEmail());
        if (oldUser.isPresent()) return false;
        userRepository.save(user);
        return true;
    }
}
