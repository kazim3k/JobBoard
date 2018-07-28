package com.github.kazim3k.service.impl;

import com.github.kazim3k.entity.User;
import com.github.kazim3k.repository.UserRepository;
import com.github.kazim3k.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(String login, String email, String password) {
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    public User findOneByEmail(String name) {
        return userRepository.findOneByEmail(name);
    }
}
