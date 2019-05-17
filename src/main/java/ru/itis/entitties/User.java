package ru.itis.entitties;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "my_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String login;
    private String password;
    private String sername;
    private String mail;
    private String phone;
    private String hobbies;
    private int age;

    @OneToMany(mappedBy = "user")
    List<Token> tokens;
}
