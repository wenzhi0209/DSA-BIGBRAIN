/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author wenzh
 */
public class SpecialSkill {

    private String id;
    private String name;
    private String description;
    private int useTimes;
    private char grade;
    private static int num = 1;

    public SpecialSkill() {
        this.id = "SSK" + num;
        num++;
    }

    // only skill with full parameter will give an ID
    public SpecialSkill(String name, String description, int useTimes, char grade) {
        this.id = "SSK" + num;
        this.name = name;
        this.description = description;
        this.useTimes = useTimes;
        this.grade = grade;
        num++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getUseTimes() {
        return useTimes;
    }

    public char getGrade() {
        return grade;
    }

    public static int getNum() {
        return num;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUseTimes(int useTimes) {
        this.useTimes = useTimes;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public static void setNum(int num) {
        SpecialSkill.num = num;
    }

    public boolean deductUseTimes() {
        if (useTimes != 0) {
            this.useTimes--;
            return true;
        }
        return false;
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
        final SpecialSkill other = (SpecialSkill) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    //nescessary data
    public String skillDesc() {
        String str = "";
        str += "Grade " + grade + " Skill\n";
        str += name + "\n";
        str += description + "\n";
        str += "Available use times : " + useTimes + "\n";
        return str;

    }

    @Override
    public String toString() {
        return "SpecialSkill :" + "id=" + id + "\n name=" + name + "\n description=" + description + "\n useTimes=" + useTimes + "\n grade=" + grade + '}';
    }

}
