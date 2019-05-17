package ru.itis.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itis.entitties.Token;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@Data
@AllArgsConstructor
public class TokenDto {
    private String value;

    public static TokenDto from(Token token) {
        return new TokenDto(token.getToken());
    }
}
