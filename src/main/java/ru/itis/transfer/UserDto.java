package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.mapping.Collection;
import ru.itis.entitties.Token;
import ru.itis.entitties.User;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String login;
    private String password;
    private String sername;
    private String mail;
    private String phone;
    private String hobbies;
    private int age;

    List<String> tokens;

    public static UserDto from(User user) {
        return UserDto.builder()
                .age(user.getAge())
                .hobbies(user.getHobbies())
                .id(user.getId())
                .login(user.getLogin())
                .mail(user.getMail())
                .tokens(user.getTokens().stream().map(token -> TokenDto.from(token).getValue()).collect(Collectors.toList()))
                .name(user.getName())
                .password(user.getPassword())
                .sername(user.getSername())
                .phone(user.getPhone())
                .build();
    }
}
