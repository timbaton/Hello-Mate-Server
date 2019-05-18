package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.entitties.Token;

/**
 * Created by timurbadretdinov on May, 2019
 **/
public interface TokenRepository extends JpaRepository<Token, Long> {
}
