/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//------------------------------------------------------------------------------
// MAIN CONTROL FOR THE WHOLE APPLICATION
//------------------------------------------------------------------------------
package client;

import entity.Player;
import entity.SpecialSkill;
import java.util.Scanner;
import java.util.Random;

public class Game {

    Player player;
    int life;
    int score;
    SpecialSkill skill;

    Scanner scan = new Scanner(System.in);

    public Game(Player player) {
        //it should pass by parameter since
        this.player = player;
        this.life = 3;
        this.score = 0;
        this.skill = SkillsFunction.getSkill(player.getName());
    }

    public Player getPlayer() {
        return player;
    }

    public int getLife() {
        return life;
    }

    public int getScore() {
        return score;
    }

    public SpecialSkill getSkill() {
        return skill;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSkill(SpecialSkill skill) {
        this.skill = skill;
    }

    public void addMark() {
        score += 5;
    }

    public void lifeMinus() {

        //check use times
        if (skill.getUseTimes() == 0) {
            life--;
        } //check for skill
        else {
            //no need deduct life
            if (skill.getName().equals("PROTECTION")) {
                System.out.println(skill.getDescription());
                skill.deductUseTimes();
            }
            //other situation deduct life
            life--;
            //if player die
            if (life == 0) {
                //they have respawn skill will incrase life
                if (skill.getName().equals("LIFE")) {
                    life++;
                    System.out.println("\n\n" + skill.getDescription());
                    System.out.println("Respawn ! Your Life now: "+life);
                    skill.deductUseTimes();
                } else if (skill.getName().equals("REAL LIFE")) {
                    life = 3;
                    System.out.println("\n\n" + skill.getDescription());
                    System.out.println("Respawn ! Your Life now: "+life);
                    skill.deductUseTimes();
                }

            }

        }

    }

    //pass answer to here to return the hints of answer
    //and also the option length/number of option
    public void useSkill(int rightAns, int numOption) {
        //way to implement use skill
        //check id before using skill
        //Instead of remove the skill when usetimes empty, keep it for future enchance
        //enhance= use coin to get extra usetimes
        char replyAns;
        String nameSkill;
        //the reason of using name instead of ID is for minimise the chance of error when combining
        //avoid the errors caused by sequence change on hard code array
        nameSkill = skill.getName();

        System.out.println("This is your SKILL in this round of game \n");
        System.out.println(skill.skillDesc());
        // Life Skill- respawn
        if (nameSkill.equals("LIFE") || nameSkill.equals("REAL LIFE") || nameSkill.equals("PROTECTION")) {
            System.out.println("This SKILL will automatic use\n");
        } else if (skill.getUseTimes() != 0) {
            System.out.printf("Do you want to use it (Y for comfirm)?? \n");
            replyAns = scan.next().toUpperCase().charAt(0);
            if (replyAns == 'Y') {
                if (nameSkill.equals("PACK_ONE")) {
                    skill.deductUseTimes();

                    int[] availableOption = findAns(rightAns, numOption, 1);
                    System.out.printf("The answer you should choose are : ");
                    for (int i = 0; i < availableOption.length; i++) {
                        System.out.printf(" %d ", availableOption[i]);
                    }

                    System.out.printf("\nRemaining use times : %d \n", skill.getUseTimes());
                } else if (nameSkill.equals("HALF")) {
                    skill.deductUseTimes();
                    // Do something
                    int[] availableOption = findAns(rightAns, numOption, 2);
                    System.out.printf("The answer you should choose are : ");
                    for (int i = 0; i < availableOption.length; i++) {
                        System.out.printf(" %d ", availableOption[i]);
                    }

                    //
                    System.out.printf("\nRemaining use times : %d \n", skill.getUseTimes());
                } //heal skill
                else if (nameSkill.equals("HEAL")) {
                    skill.deductUseTimes();
                    life++;
                    System.out.println("Your Life now + 1. Your Life: "+life);
                    System.out.printf("Remaining use times : %d \n", skill.getUseTimes());
                } else if (nameSkill.compareTo("ONE") == 0) {
                    skill.deductUseTimes();

                    int[] availableOption = findAns(rightAns, numOption, 1);
                    System.out.printf("The answer you should choose are : ");
                    for (int i = 0; i < availableOption.length; i++) {
                        System.out.printf(" %d ", availableOption[i]);
                    }

                    System.out.printf("\nRemaining use times : %d \n", skill.getUseTimes());
                } //nothing
                else if (nameSkill.equals("NOTHING")) {
                    skill.deductUseTimes();
                    System.out.println("You might more confident now, maybe?");
                    System.out.printf("Remaining use times : %d \n", skill.getUseTimes());
                } else if (nameSkill.compareTo("ONLY_ONE") == 0) {
                    skill.deductUseTimes();
                    int[] availableOption = findAns(rightAns, numOption, 3);
                    System.out.printf("The answer you should choose are : ");
                    for (int i = 0; i < availableOption.length; i++) {
                        System.out.printf(" %d ", availableOption[i]);
                    }
                    System.out.printf("\nRemaining use times : %d \n", skill.getUseTimes());
                } else {
                    System.out.println("Invalid Skill in the code");
                }

            }

        } else {
            System.out.println("Your Skill is not available");
        }

    }

    //pass in real answer ,numOption for detect the size of option,and number of choice need to deduct
    private int[] findAns(int realAns, int numOption, int deduct) {
        // means if number need to deduct more than option just return answer
        if (numOption - deduct <= 1) {
            int ansReturn[] = {realAns};
            return ansReturn;
        }

        int ansArray[] = {1, 2, 3, 4};
        int ansReturn[] = new int[numOption - deduct];

        int deductTemp = deduct;
        //random select wrong answer to remove
        while (deductTemp != 0) {
            Random rand = new Random();
            int n = rand.nextInt(4);
            if (ansArray[n] != realAns && ansArray[n]!=0) {
                ansArray[n] = 0;
                deductTemp--;
            }
        }

        int j = 0;
        for (int i = 0; i < ansArray.length; i++) {

            if (ansArray[i] != 0 && j < ansReturn.length) {
                ansReturn[j] = ansArray[i];
                j++;
            }
        }
        return ansReturn;
    }

    @Override
    public String toString() {
        return "Game{" + "player=" + player.getName() + ", score=" + score + ", skill=" + skill + '}';
    }

}
