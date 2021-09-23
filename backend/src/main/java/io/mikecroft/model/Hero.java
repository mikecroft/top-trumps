package io.mikecroft.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Hero extends PanacheEntity {

  public int hp = 100;
  public String name;
  public String power;
  public String weakness;
  public int strength;
  public int magic;
  public int telekinesis;
  public int speed;
  public int iq;

}