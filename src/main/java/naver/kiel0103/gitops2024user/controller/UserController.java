package naver.kiel0103.gitops2024user.controller;


import jakarta.annotation.PostConstruct;
import naver.kiel0103.gitops2024user.domain.UserDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/user")
    public ResponseEntity<UserDomain> get(
            @RequestParam("username") String username,
            @RequestParam("pw") String password
    ) {
        Optional<UserDomain> userOptional = users.values().stream()
                .filter(user -> user.getUsername().equals(username)
                        && user.getPassword().equals(password))
                .findFirst();

        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok(null));
    }
}
