package com.dgmf.controller;

import com.dgmf.entity.Post;
import com.dgmf.entity.User;
import com.dgmf.exception.UserNotFoundException;
import com.dgmf.repository.UserDaoService;
import com.dgmf.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa")
public class UserJpaResourceController {
    private final UserRepository userRepository;

    // Retrieve All Users REST API
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve User By Id REST API
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable("id") Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()) throw new UserNotFoundException(
                    "User Not Found with the Given Id : " + userId
            );

        // HATEOAS
        EntityModel<User> userEntityModel = EntityModel.of(user.get());
        // Create a Link which Pointed to Controller Method
        WebMvcLinkBuilder link = linkTo(
                    methodOn(this.getClass())
                    .retrieveAllUsers()
                );
        userEntityModel.add(link.withRel("all-users"));

        return userEntityModel;
    }

    // Delete User By Id REST API
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long userId) {
        userRepository.deleteById(userId);
    }

    // Retrieve Posts By User Id REST API
    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsByUserId(@PathVariable("id") Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()) throw new UserNotFoundException(
                "User Not Found with the Given Id : " + userId
        );

        return user.get().getPosts();
    }

    // Create User REST API
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

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
