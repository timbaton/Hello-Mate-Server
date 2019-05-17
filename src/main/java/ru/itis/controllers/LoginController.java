package ru.itis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.entitties.Token;
import ru.itis.transfer.TokenDto;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@RestController
public class LoginController {

    @PostMapping("/login")
    ResponseEntity<TokenDto> login() {
        return null;
    }

}
