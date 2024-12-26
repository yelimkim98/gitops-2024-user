package naver.kiel0103.gitops2024user.controller;


import jakarta.annotation.PostConstruct;
import naver.kiel0103.gitops2024user.domain.UserDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final Map<Long, UserDomain> users = new HashMap<>();

    @PostConstruct
    void setUp() {
        users.put(1L, new UserDomain(1L, "user1", "user1"));
        users.put(2L, new UserDomain(2L, "user2", "user2"));
        users.put(3L, new UserDomain(3L, "user3", "user3"));
    }

    @GetMapping("/users")
    public ResponseEntity<Map<Long, UserDomain>> getAll() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDomain> get(@PathVariable Long id) {
        return ResponseEntity.ok(users.get(id));
    }
}
