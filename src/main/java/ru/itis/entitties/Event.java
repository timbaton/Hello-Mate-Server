package ru.itis.entitties;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@Entity
@Data
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
}
