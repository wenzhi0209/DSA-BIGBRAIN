/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Winnie wong
 */
public class Player implements Serializable {

    static int pCount = 0;
    String name;
    int id = 1000;
    char gender;
    int age;
    int score;
    public Achievement achievement;
    
    public Player() {

    }

    public Player(String name, char gender, int age, int score, Achievement achievement) {
        pCount++;
        this.name = name;
        this.id = id + pCount;
        this.gender = gender;
        this.age = age;
        this.score = score;
        this.achievement = achievement;
        
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public static int getpCount() {
        return pCount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public char getGender() {
        return gender;
    }

    public int getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }

    public static void setpCount(int pCount) {
        Player.pCount = pCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("P%-9s %-20s %-9s %-7s %-5s", id, name, gender, age, score);

    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.achievement, other.achievement)) {
            return false;
        }
        return true;
    }

    

}
