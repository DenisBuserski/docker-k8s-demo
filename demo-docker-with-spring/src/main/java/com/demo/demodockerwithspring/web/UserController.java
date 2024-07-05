package com.demo.demodockerwithspring.web;

import com.demo.demodockerwithspring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        this.userServiceImpl.createUser("Denis", 25);
        return "Created!";
    }
}
