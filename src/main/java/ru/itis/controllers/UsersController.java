package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.repositories.UserRepository;
import ru.itis.entitties.User;
import ru.itis.services.UserService;
import ru.itis.transfer.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    List<UserDto> all() {
        return userService.findAll().stream().map(UserDto::from).collect(Collectors.toList());
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/{user-login}")
    public UserDto getUserByLogin(@PathVariable(name = "user-login") String login) {
        Optional<User> userByLogin = userService.getUserByLogin(login);
        if (userByLogin.isPresent()) {
            return UserDto.from(userByLogin.get());
        } else throw new IllegalArgumentException("User not found");
    }
}
