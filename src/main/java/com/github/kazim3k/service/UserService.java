package com.github.kazim3k.service;

import com.github.kazim3k.entity.User;

public interface UserService {
    void create(String login,String email,String password);
    User findOneByEmail(String name);

}
