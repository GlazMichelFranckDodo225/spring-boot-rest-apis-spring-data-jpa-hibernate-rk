package com.dgmf.controller;

import com.dgmf.entity.User;
import com.dgmf.repository.UserDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserResourceController {
    private final UserDaoService userDaoService;

    // Retrieve All Users REST API
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }
}
