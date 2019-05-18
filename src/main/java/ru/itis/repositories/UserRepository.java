package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.entitties.User;

import java.util.Optional;

/**
 * Created by timurbadretdinov on May, 2019
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM my_user u WHERE u.login = ?")
    Optional<User> getUserByLogin(String login);
}
