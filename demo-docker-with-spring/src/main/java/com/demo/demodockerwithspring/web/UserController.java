package com.demo.demodockerwithspring.web;

import com.demo.demodockerwithspring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/create")
    public String createUser() {
        this.userServiceImpl.createUser("User-1", 25);
        this.userServiceImpl.createUser("User-2", 30);
        this.userServiceImpl.createUser("User-3", 35);
        this.userServiceImpl.createUser("User-4", 45);
        this.userServiceImpl.createUser("User-5", 50);
        return "test";
    }

}
