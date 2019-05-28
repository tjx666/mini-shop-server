package com.ytj.minishop.repository;

import com.ytj.minishop.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
