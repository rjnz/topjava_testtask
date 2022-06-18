package com.game.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "player")
public class Player {
    @Id
    Long id;
    String name;
    String title;
    @Enumerated
    Race race;
    @Enumerated
    Profession profession;
    Integer experience;
    Integer level;
    Integer untilNextLevel;
    Date birthday;
    Boolean banned;
}
