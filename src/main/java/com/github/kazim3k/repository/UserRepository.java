package com.github.kazim3k.repository;

import com.github.kazim3k.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByEmail(String email);
    User findOneByLogin(String login);

}
