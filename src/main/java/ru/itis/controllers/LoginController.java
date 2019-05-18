package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.entitties.Token;
import ru.itis.forms.LoginForm;
import ru.itis.services.LoginService;
import ru.itis.services.UserService;
import ru.itis.transfer.TokenDto;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@RestController
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(loginService.login(loginForm));
    }
}
