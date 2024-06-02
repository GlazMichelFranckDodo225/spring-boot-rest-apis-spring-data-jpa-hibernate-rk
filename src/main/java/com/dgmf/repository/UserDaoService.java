package com.dgmf.repository;

import com.dgmf.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();
    private static Long userCount = 0L;

    // Whenever the Server Restart, this Code will be Executed
    static {
        users.addAll(List.of(
                User.builder()
                        .id(++userCount)
                        .name("Adam")
                        .birthDate(LocalDate.now().minusYears(30))
                        .build(),
                User.builder()
                        .id(++userCount)
                        .name("Guy")
                        .birthDate(LocalDate.now().minusYears(25))
                        .build(),
                User.builder()
                        .id(++userCount)
                        .name("Manuella")
                        .birthDate(LocalDate.now().minusYears(20))
                        .build(),
                User.builder()
                        .id(++userCount)
                        .name("Eve")
                        .birthDate(LocalDate.now().minusYears(10))
                        .build(),
                User.builder()
                        .id(++userCount)
                        .name("Jim")
                        .birthDate(LocalDate.now().minusYears(40))
                        .build()
        ));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);

        return user;
    }

    public User findOne(Long userId) {
        Predicate<? super User> predicate = user -> user.getId().equals(userId);

        return users.stream().filter(predicate).findFirst().orElse(null);
        // .orElseThrow(() -> new RuntimeException("User Not Found with the Given Id : " + userId))
    }

    public void deleteById(Long userId) {
        Predicate<? super User> predicate = user -> user.getId().equals(userId);

        users.removeIf(predicate);
    }
}
