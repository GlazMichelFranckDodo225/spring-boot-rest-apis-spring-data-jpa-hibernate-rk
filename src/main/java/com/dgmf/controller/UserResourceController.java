package com.dgmf.controller;

import com.dgmf.entity.User;
import com.dgmf.exception.UserNotFoundException;
import com.dgmf.repository.UserDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    // Retrieve User By Id REST API
    @GetMapping("/users/{id}")
    public User retrieveUserById(@PathVariable("id") Long userId) {
        User user = userDaoService.findOne(userId);

        if(user == null) {
            throw new UserNotFoundException(
                    "User Not Found with the Given Id : " + userId
            );
        }

        return user;
    }

    // Create User REST API
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);

        // To the URI of the Current Request
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                // We had the Path "/id"
                .path("/{id}")
                // We Replace the Path Variable "id" by the Id of the Created User
                .buildAndExpand(savedUser.getId())
                // Convert into a URI and Returned Back the URI
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
