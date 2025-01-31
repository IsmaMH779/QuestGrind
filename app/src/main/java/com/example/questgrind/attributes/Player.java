package com.example.questgrind.attributes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "player")
public class Player {
    @PrimaryKey(autoGenerate = true)
    private int id;

    // datos generales
    private String name;
    private int level;

    private int xp;
    private int xpToNextLevel;

    // atributos
    private int vitality;
    private int strength;
    private int intelligence;
    private int agility;
    private int perception;

    // puntos disponibles
    private int aviableSkillPoints;

    public Player() {
        this.name = "Isma";
        this.level = 1;
        this.xp = 0;
        this.xpToNextLevel = 50;
        this.vitality = 10;
        this.strength = 10;
        this.intelligence = 10;
        this.agility = 10;
        this.perception = 10;
        this.aviableSkillPoints = 0;
    }

    public void giveXP(int xp) {
        this.xp += xp;
        levelUP();
    }

    public void levelUP() {
        if (xp == xpToNextLevel) {
            level++;
            xp = 0;
            xpToNextLevel += 50;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpToNextLevel() {
        return xpToNextLevel;
    }

    public void setXpToNextLevel(int xpToNextLevel) {
        this.xpToNextLevel = xpToNextLevel;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getAviableSkillPoints() {
        return aviableSkillPoints;
    }

    public void setAviableSkillPoints(int aviableSkillPoints) {
        this.aviableSkillPoints = aviableSkillPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
