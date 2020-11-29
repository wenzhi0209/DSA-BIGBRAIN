/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Scanner;
import adt.SortedArrayList;
import entity.Score;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Chin Yew
 */
public class Scoreboard {

    //For highest scoreboard
    public static SortedArrayList<Score> scoreList = new SortedArrayList<Score>();

    //For game scoreboard (multiplayer)
    public static SortedArrayList<Score> gameScore = new SortedArrayList<Score>();

    Scanner scanner = new Scanner(System.in);

    public Scoreboard() {
        //Hardcode Score
        scoreList.add(new Score("Jimin", 0));
        scoreList.add(new Score("Rose", 80));
        scoreList.add(new Score("Panda", 0));
        scoreList.add(new Score("Bubu", 30));
        scoreList.add(new Score("Doja Cat", 20));
        scoreList.add(new Score("RM", 50));
        scoreList.add(new Score("Grizz", 40));
        scoreList.add(new Score("Ice Bear", 10));

    }

    public void scoreMenu() {

        System.out.println("\nSCOREBOARD");
        System.out.println("--------------------");
        System.out.println("1. Top 10 Scoreboard");
        System.out.println("2. Reset Scoreboard");
        System.out.println("3. Exit Scoreboard");
        System.out.println("--------------------");
        System.out.print("Enter your choice     >");
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("\n" + choice + " is not a valid choice.\n");
            System.out.print("Enter choice (1/2/3)            >");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                displayHighestScore();
                break;

            case 2:
                System.out.print("Are you sure to reset scoreboard? (Y/N)            >");
                char clearBoard = scanner.next().toUpperCase().charAt(0);
                while (clearBoard != 'Y' && clearBoard != 'N') {
                    System.out.println("\n" + clearBoard + " is not a valid choice.\n");
                    System.out.print("Enter choice (Y/N)            >");
                    clearBoard = scanner.next().toUpperCase().charAt(0);
                }

                if (clearBoard == 'Y') {
                    clearScoreboard();
                }
                break;
        }

    }

    public void updateScore(String name, int score) {
        Score temp = new Score(name, score);

        //Top 10 Scoreboard
        if (scoreList.contains(temp)) {
            if (scoreList.compareTo(temp) == -1) { //new high score
                scoreList.remove(temp);//remove old score
                scoreList.add(temp); //update new high score
            }
        } else {
            scoreList.add(temp);
        }

        //Game Scoreboard
        gameScore.add(temp);

    }

    public void displayHighestScore() { //add player after end game with highest score
        int position = 1;
        System.out.println("\n**********************************");
        System.out.println("*         Top 10 Scoreboard      *");
        System.out.println("**********************************");
        System.out.println("NO.     NAME                 SCORE");
        System.out.println("---     -----------------    -----");
        for (int i = 0; i < scoreList.getLength(); i++) {
            if (position <= 10) {
                System.out.println(position++ + scoreList.toString(i));
            }
        }
    }

    public void displayGameScore() { //display end game scoreboard
        int position = 1;
        System.out.println("\n**********************************");
        System.out.println("*         Game Scoreboard        *");
        System.out.println("**********************************");
        System.out.println("NO.     NAME                 SCORE");
        System.out.println("---     -----------------    -----");
        for (int i = 0; i < gameScore.getLength(); i++) {
            System.out.println(position++ + gameScore.toString(i));
        }
        //Clear after display
        gameScore.clear();
    }

    public void clearScoreboard() {
        //Clear List
        scoreList.clear();
        //Delete file
        File file = new File("HighestScore.dat");
        file.delete();
        System.out.println("Scoreboard successfully reset!");


    }

    public void readScoreFile() {
        try {
            File file = new File("HighestScore.dat");
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            scoreList = (SortedArrayList) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("!! File not found !!");
        } catch (IOException ex) {
            System.out.println("!! Cannot read from file !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("!! Class not found !!");
        }

    }

    public void writeScoreFile() {
        try {
            File file = new File("HighestScore.dat");
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(scoreList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("!! File not found !!");
        } catch (IOException ex) {
            System.out.println("!! Cannot save to file !!");
        }
    }

    public int isFileFound() {
        int found = 0;
        File file = new File("HighestScore.dat");
        if (file.exists()) {
            found = 1;
        }
        return found;
    }

    public boolean isFileEmpty() {
        boolean isEmpty = false;
        File file = new File("HighestScore.dat");
        if (file.length() == 0) {
            isEmpty = true;
            return isEmpty; //return true
        } else {
            return isEmpty; //return false
        }
    }

}
