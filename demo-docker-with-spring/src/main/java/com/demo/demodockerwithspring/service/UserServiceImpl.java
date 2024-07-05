package com.demo.demodockerwithspring.service;

import com.demo.demodockerwithspring.model.User;
import com.demo.demodockerwithspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String name, int age) {
        User user = new User(name, age);
        this.userRepository.save(user);
    }
}
