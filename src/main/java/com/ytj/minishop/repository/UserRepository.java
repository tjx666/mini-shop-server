package com.ytj.minishop.repository;

import com.ytj.minishop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
