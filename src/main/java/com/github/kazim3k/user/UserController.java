package com.github.kazim3k.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void register(@ModelAttribute @Valid CreateUserDto createUserDto) {
        userService.create(createUserDto.getLogin(),createUserDto.getEmail(),createUserDto.getPassword());
    }
}
