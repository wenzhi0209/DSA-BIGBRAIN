/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Ethan
 */
public class Achievement implements Serializable {

    private int racoonAcvm;
    private int dogAcvm;
    private int parrotAcvm;
    private int OctopusAcvm;
    private int pigAcvm;
    private int dolphinAcvm;
    private int gorillasAcvm;
    private int elephantAcvm;
    private int chimpanzeeAcvm;
    private int ravenAndCrowAcvm;

    public Achievement() {

    }

    public Achievement(int racoonAcvm, int dogAcvm, int parrotAcvm, int OctopusAcvm, int pigAcvm, int dolphinAcvm, int gorillasAcvm, int elephantAcvm, int chimpanzeeAcvm, int ravenAndCrowAcvm) {
        this.racoonAcvm = racoonAcvm;
        this.dogAcvm = dogAcvm;
        this.parrotAcvm = parrotAcvm;
        this.OctopusAcvm = OctopusAcvm;
        this.pigAcvm = pigAcvm;
        this.dolphinAcvm = dolphinAcvm;
        this.gorillasAcvm = gorillasAcvm;
        this.elephantAcvm = elephantAcvm;
        this.chimpanzeeAcvm = chimpanzeeAcvm;
        this.ravenAndCrowAcvm = ravenAndCrowAcvm;
    }

    public int getRacoonAcvm() {
        return racoonAcvm;
    }

    public int getDogAcvm() {
        return dogAcvm;
    }

    public int getParrotAcvm() {
        return parrotAcvm;
    }

    public int getOctopusAcvm() {
        return OctopusAcvm;
    }

    public int getPigAcvm() {
        return pigAcvm;
    }

    public int getDolphinAcvm() {
        return dolphinAcvm;
    }

    public int getGorillasAcvm() {
        return gorillasAcvm;
    }

    public int getElephantAcvm() {
        return elephantAcvm;
    }

    public int getChimpanzeeAcvm() {
        return chimpanzeeAcvm;
    }

    public int getRavenAndCrowAcvm() {
        return ravenAndCrowAcvm;
    }

    public void setRacoonAcvm(int racoonAcvm) {
        this.racoonAcvm = racoonAcvm;
    }

    public void setDogAcvm(int dogAcvm) {
        this.dogAcvm = dogAcvm;
    }

    public void setParrotAcvm(int parrotAcvm) {
        this.parrotAcvm = parrotAcvm;
    }

    public void setOctopusAcvm(int OctopusAcvm) {
        this.OctopusAcvm = OctopusAcvm;
    }

    public void setPigAcvm(int pigAcvm) {
        this.pigAcvm = pigAcvm;
    }

    public void setDolphinAcvm(int dolphinAcvm) {
        this.dolphinAcvm = dolphinAcvm;
    }

    public void setGorillasAcvm(int gorillasAcvm) {
        this.gorillasAcvm = gorillasAcvm;
    }

    public void setElephantAcvm(int elephantAcvm) {
        this.elephantAcvm = elephantAcvm;
    }

    public void setChimpanzeeAcvm(int chimpanzeeAcvm) {
        this.chimpanzeeAcvm = chimpanzeeAcvm;
    }

    public void setRavenAndCrowAcvm(int ravenAndCrowAcvm) {
        this.ravenAndCrowAcvm = ravenAndCrowAcvm;
    }

    public void updateAcvm(int animalIndex) {
        switch (animalIndex) {
            case 2:
                racoonAcvm++;
                break;
            case 3:
                dogAcvm++;
                break;
            case 4:
                parrotAcvm++;
                break;
            case 5:
                OctopusAcvm++;
                break;
            case 6:
                pigAcvm++;
                break;
            case 7:
                dolphinAcvm++;
                break;
            case 8:
                gorillasAcvm++;
                break;
            case 9:
                elephantAcvm++;
                break;
            case 10:
                chimpanzeeAcvm++;
                break;
            case 11:
                ravenAndCrowAcvm++;
                break;
            default:;
        }
    }

    public int[] getAllAcvm() {
        int[] count = new int[11];
        count[0] = 0;
        count[1] = getRacoonAcvm();
        count[2] = getDogAcvm();
        count[3] = getParrotAcvm();
        count[4] = getOctopusAcvm();
        count[5] = getPigAcvm();
        count[6] = getDolphinAcvm();
        count[7] = getGorillasAcvm();
        count[8] = getElephantAcvm();
        count[9] = getChimpanzeeAcvm();
        count[10] = getRavenAndCrowAcvm();
        return count;
    }

    public String[] getAllName() {
        String[] name = new String[11];
        name[0] = "nothing (IQ: 0-4)";
        name[1] = "a Racoon (IQ: 5-9)";
        name[2] = "a Dog (IQ: 10-19)";
        name[3] = "a Parrot (IQ: 20-29)";
        name[4] = "an Octopus (IQ: 30-39)";
        name[5] = "a Pig (IQ: 40-49)";
        name[6] = "a Dolphin (IQ: 50-59)";
        name[7] = "a Gorillas (IQ: 60-69)";
        name[8] = "an Elephant (IQ: 70-79)";
        name[9] = "a Chimpanzee (IQ: 80-99)";
        name[10] = "Raven & Crow (IQ: >100)";
        return name;
    }

    public String showHighestAchieve() {
        String str = "";
        int[] count = getAllAcvm();
        String[] name = getAllName();
        int highest = count[0];
        for (int i = 0; i < 10; i++) {
            if (highest < count[i]) {
                highest = count[i];
                str = "This player truly represent " + name[i] + " of " + highest + " times!";
            } else if (highest == 0) {
                str = "This player has no achivement yet...";
            }
        }
        return str;
    }

    public int getHighestCount(int animalIndex) {
        int count = 0;
        switch (animalIndex) {
            case 2:
                count = getRacoonAcvm();
                break;
            case 3:
                count = getDogAcvm();
                break;
            case 4:
                count = getParrotAcvm();
                break;
            case 5:
                count = getOctopusAcvm();
                break;
            case 6:
                count = getPigAcvm();
                break;
            case 7:
                count = getDolphinAcvm();
                break;
            case 8:
                count = getGorillasAcvm();
                break;
            case 9:
                count = getElephantAcvm();
                break;
            case 10:
                count = getChimpanzeeAcvm();
                break;
            case 11:
                count = getRavenAndCrowAcvm();
                break;
            default:;
        }
        return count;
    }

    @Override
    public String toString() {
        String str = "";
        str = "racoonAchievement = " + racoonAcvm + "\n"
                + "dogAchievement = " + dogAcvm + "\n"
                + "parrotAchievement = " + parrotAcvm + "\n"
                + "octopusAchievement = " + OctopusAcvm + "\n"
                + "pigAchievement = " + pigAcvm + "\n"
                + "dolphinAchievement = " + dolphinAcvm + "\n"
                + "gorillasAchievement = " + gorillasAcvm + "\n"
                + "elephantAchievement = " + elephantAcvm + "\n"
                + "chimpanzeeAchievement = " + chimpanzeeAcvm + "\n"
                + "ravenAndCrowAchievement = " + ravenAndCrowAcvm + "\n";
        return str;
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
        final Achievement other = (Achievement) obj;
        if (this.racoonAcvm != other.racoonAcvm) {
            return false;
        }
        if (this.dogAcvm != other.dogAcvm) {
            return false;
        }
        if (this.parrotAcvm != other.parrotAcvm) {
            return false;
        }
        if (this.OctopusAcvm != other.OctopusAcvm) {
            return false;
        }
        if (this.pigAcvm != other.pigAcvm) {
            return false;
        }
        if (this.dolphinAcvm != other.dolphinAcvm) {
            return false;
        }
        if (this.gorillasAcvm != other.gorillasAcvm) {
            return false;
        }
        if (this.elephantAcvm != other.elephantAcvm) {
            return false;
        }
        if (this.chimpanzeeAcvm != other.chimpanzeeAcvm) {
            return false;
        }
        if (this.ravenAndCrowAcvm != other.ravenAndCrowAcvm) {
            return false;
        }
        return true;
    }
}
