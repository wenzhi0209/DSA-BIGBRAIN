package entity;

import java.util.Objects;

public class Animal {

    String name;
    int iq;
    String description;
    String titleHolder;
    int highestCount;

    public Animal() {

    }

    public Animal(String name, int iq, int highestCount, String highestAchiever, String description) {
        this.iq = iq;
        this.name = name;
        this.highestCount = highestCount;
        this.titleHolder = highestAchiever;
        this.description = description;
    }

    public int getHighestCount() {
        return highestCount;
    }

    public void setHighestCount(int highestCount) {
        this.highestCount = highestCount;
    }

    public String getTitleHolder() {
        return titleHolder;
    }

    public void setTitleHolder(String titleHolder) {
        this.titleHolder = titleHolder;
    }

    public int getIq() {
        return iq;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("According to your score, you have an IQ equivalent to " + name + "\n" + description);
    }

    public String showAchievers() {
        return String.format("%-20s %-20s %-2s", name, titleHolder, highestCount);

    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Animal other = (Animal) obj;
        if (this.iq != other.iq) {
            return false;
        }
        if (this.highestCount != other.highestCount) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.titleHolder, other.titleHolder)) {
            return false;
        }
        return true;
    }

}
