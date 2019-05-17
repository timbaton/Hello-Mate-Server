package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.repositories.UserRepository;
import ru.itis.entitties.User;

import java.util.List;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@RestController
public class UsersController {

    @Autowired
    UserRepository repository;

    @RequestMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(User user) {
        repository.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/{user-login}")
    public User getUserByLogin(@PathVariable(name = "user-login") String login) {
        return repository.getUserByLogin(login);
    }
}
