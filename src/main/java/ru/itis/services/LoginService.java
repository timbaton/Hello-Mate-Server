package ru.itis.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.entitties.Token;
import ru.itis.entitties.User;
import ru.itis.forms.LoginForm;
import ru.itis.repositories.TokenRepository;
import ru.itis.repositories.UserRepository;
import ru.itis.transfer.TokenDto;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@Component
public class LoginService {
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    UserRepository userRepository;

    public TokenDto login(LoginForm loginForm) {
        Optional<User> possibleUser = userRepository.getUserByLogin(loginForm.getLogin());

        if (possibleUser.isPresent()) {
            User user = possibleUser.get();

            if (user.getPassword().equals(loginForm.getPassword())) {
                Token token = Token.builder()
                        .responsibleUser(user)
                        .token(RandomStringUtils.random(10))
                        .build();
                tokenRepository.save(token);

                return TokenDto.from(token);
            } else throw new IllegalArgumentException("Password is not correct");
        }
        throw new IllegalArgumentException("User not found");
    }
}
