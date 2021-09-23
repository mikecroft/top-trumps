package io.mikecroft.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class Player extends PanacheEntity {
    
    public String firstName;
    public String lastName;
    public int gamesPlayed;
    public int gamesWon;
    public int gamesLost;

}