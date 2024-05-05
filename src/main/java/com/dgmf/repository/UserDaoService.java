package com.dgmf.repository;

import com.dgmf.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();

    static {
        users.addAll(List.of(
                User.builder()
                        .id(1L)
                        .name("Adam")
                        .birthDate(LocalDate.now().minusYears(30))
                        .build(),
                User.builder()
                        .id(2L)
                        .name("Guy")
                        .birthDate(LocalDate.now().minusYears(25))
                        .build(),
                User.builder()
                        .id(3L)
                        .name("Manuella")
                        .birthDate(LocalDate.now().minusYears(20))
                        .build(),
                User.builder()
                        .id(4L)
                        .name("Eve")
                        .birthDate(LocalDate.now().minusYears(10))
                        .build(),
                User.builder()
                        .id(5L)
                        .name("Jim")
                        .birthDate(LocalDate.now().minusYears(40))
                        .build()
        ));
    }

    public List<User> findAll() {
        return users;
    }
}
