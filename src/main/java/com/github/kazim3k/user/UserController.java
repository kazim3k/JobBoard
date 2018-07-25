package com.github.kazim3k.user;

import com.github.kazim3k.ad.AdService;
import com.github.kazim3k.dto.CreateUserDto;
import com.github.kazim3k.dto.PostAdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;



    @Autowired
    public UserController(UserService userService, AdService adService) {
        this.userService = userService;
    }

    @GetMapping("{name}")
    public User findOnByEmail(@PathVariable String name) {
        return userService.findOneByEmail(name);
    }

    @PostMapping
    public void register(@ModelAttribute @Valid CreateUserDto createUserDto) {
        userService.create(createUserDto.getLogin(),createUserDto.getEmail(),createUserDto.getPassword());
    }
}
