/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Random;
import adt.LinkedStack;
import entity.SpecialSkill;
import java.util.Scanner;

/**
 *
 * @author wenzh
 */
public class SkillsFunction {

    //simulate card set
    private static LinkedStack<SpecialSkill> skillSet = new LinkedStack();
    //data from array at driver
    public static SpecialSkill[] arrSkill;

    //simulate the data get from file
    //easier maintain hardcode data
    public static void initialSkillSet() {
        Random rand = new Random();
        // reset all usetimes
        for(int i=0;i<arrSkill.length;i++)
        {
            if(arrSkill[i].getName().equals("PACK_ONE"))
            {
                arrSkill[i].setUseTimes(2);
            }
            arrSkill[i].setUseTimes(1);
        }
        
        //to test specific skill operation
        //skill=arrSkill[n];
        //disorganised   
        for (int i = 0; i < arrSkill.length; i++) {
            int n = rand.nextInt(10);
            SpecialSkill temp = arrSkill[i];
            arrSkill[i] = arrSkill[n];
            arrSkill[n] = temp;
        }

        //put in stack
        skillSet.pushAll(arrSkill);

    }

    public static SpecialSkill getSkill(String name) {
        // Skill Card Set
        LinkedStack<SpecialSkill> tempSet = new LinkedStack();

        Scanner scan = new Scanner(System.in);
        SpecialSkill selectionA;
        SpecialSkill selectionB;
        SpecialSkill skill = null;

        int choice;

        //select one of the skill
        selectionA = (SpecialSkill) skillSet.pop();
        selectionB = (SpecialSkill) skillSet.pop();

        System.out.println(name + ". Plese choose one of the skill for your game");
        System.out.println("1)Skill A    2)Skill B");

        do {
            System.out.print("Please enter 1/2 to chosse your skill : ");
            while (!scan.hasNextInt()) {
                System.out.print("Please Enter 1/2 to chosse your skill : ");
                scan.next();
            }
            choice = scan.nextInt();

            // simulation draw card the card not seleted put in the bottom of set
            // the previous cardset will put on top of the not selected card
            // always last in first out
            if (choice == 1) {
                skill = selectionA;
                tempSet.push(selectionB);
                tempSet.combine(skillSet);
                skillSet = tempSet;
                tempSet = null;

            } else if (choice == 2) {
                skill = selectionB;
                tempSet.push(selectionA);
                tempSet.combine(skillSet);
                skillSet = tempSet;
                tempSet = null;

            }
        } while (choice < 1 || choice > 2);

        //Get a skill
        System.out.printf("\n\nCongragulation! This is a Grade %c Skill\n", skill.getGrade());
        System.out.printf("This is the skill you get ** %s ** \n", skill.getName());
        System.out.printf("        %s \n", skill.getDescription());
        System.out.printf("Use times : %d \n", skill.getUseTimes());
        System.out.printf("Card Remaining : %d \n\n\n", skillSet.size());

        return skill;

    }
    
    public static void resetSkillSet()
    {
        skillSet.clear();
        initialSkillSet();
    }

}
