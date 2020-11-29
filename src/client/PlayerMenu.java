/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.*;
import adt.ArrayList;
import entity.Achievement;
import entity.Player;
import java.util.Scanner;

/**
 *
 * @author Winnie wong
 */
public class PlayerMenu {

    public ArrayList<Player> playerList = new ArrayList<Player>();

    public PlayerMenu() {

        Achievement[] ac = new Achievement[9];
        ac[1] = new Achievement(2, 3, 0, 0, 0, 0, 0, 0, 0, 0);
        ac[2] = new Achievement(0, 3, 1, 0, 0, 0, 0, 0, 0, 0);
        ac[3] = new Achievement(0, 0, 2, 1, 0, 0, 0, 0, 0, 0);
        ac[4] = new Achievement(0, 0, 0, 4, 1, 0, 0, 0, 0, 0);
        ac[5] = new Achievement(0, 0, 0, 0, 5, 1, 0, 0, 0, 0);
        ac[6] = new Achievement(0, 0, 0, 0, 0, 4, 1, 0, 0, 0);
        ac[7] = new Achievement(0, 0, 0, 0, 0, 0, 3, 1, 0, 0);
        ac[8] = new Achievement(0, 0, 0, 0, 0, 0, 0, 2, 1, 0);

        playerList.add(new Player("Jimin", 'M', 25, 40, ac[1]));
        playerList.add(new Player("Rose", 'F', 23, 50, ac[2]));
        playerList.add(new Player("Panda", 'M', 20, 70, ac[3]));
        playerList.add(new Player("Bubu", 'F', 20, 160, ac[4]));
        playerList.add(new Player("Doja Cat", 'F', 24, 250, ac[5]));
        playerList.add(new Player("RM", 'M', 27, 260, ac[6]));
        playerList.add(new Player("Grizz", 'M', 21, 250, ac[7]));
        playerList.add(new Player("Ice Bear", 'M', 19, 220, ac[8]));
    }

    public boolean PlayerModule() {
        String rewind, confirm;
        Scanner scanner = new Scanner(System.in);
        int option;
        Achievement ac = new Achievement(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        do {

            System.out.printf("\nPLAYER MODULE\n");
            System.out.printf("CHOOSE AN OPTION \n");
            System.out.printf("---------------------------\n");
            System.out.println("1. Select Player(s)");
            System.out.println("2. Add Player");
            System.out.println("3. Delete Player");
            System.out.println("0. Exit");

            System.out.printf("Enter your choice (0-3) : ");

            while (!scanner.hasNextInt()) {
                System.out.print("\n!! Please Enter a Valid Number !! : ");
                scanner.next();
            }

            option = scanner.nextInt();

            if (option < 0 || option > 3) {

                System.out.println("\n!! Invalid option, please try again. !!");

            }

            if (option == 2) {
                for (int i = 0; i < playerList.getLength(); i++) {
                    if (playerList.getEntry(i + 1) != null) {
                        System.out.println("\n********************");
                        System.out.println("*    ADD PLAYER    *");
                        System.out.println("********************\n");

                        rewind = scanner.nextLine();
                        System.out.print("Enter Name                    > ");
                        String name = scanner.nextLine();

                        while (!isAlpha(name)) {

                            System.out.println("\n" + name + " is not a valid name.\n");
                            System.out.print("Enter Name                    > ");
                            name = scanner.nextLine();
                        }

                        System.out.print("Enter Gender (M/F)            > ");
                        char gender = scanner.nextLine().toUpperCase().charAt(0);

                        while ((gender != 'M' && gender != 'F') && (gender != 'm' && gender != 'f')) {
                            System.out.println("\n" + gender + " is not a valid gender.\n");
                            System.out.print("Enter Gender (M/F)            > ");
                            gender = scanner.nextLine().toUpperCase().charAt(0);
                        }

                        System.out.print("Enter Age                     > ");

                        while (!scanner.hasNextInt()) {
                            System.out.println("!! Please Enter a Valid Number !!");
                            System.out.print("Enter Age                     > ");
                            scanner.next();

                        }

                        int age = scanner.nextInt();

                        System.out.println("\nNEW PLAYER DETAILS ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~\n");

                        System.out.println("Player Name   = " + name);
                        System.out.println("Player Gender = " + gender);
                        System.out.println("Player Age    = " + age);

                        System.out.println("\nDo you confirm to add this player (Y/N)?");
                        System.out.print("\nAns: ");

                        rewind = scanner.nextLine();
                        confirm = scanner.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {

                            addPlayer(name, gender, age, ac);

                            System.out.println("\n< New Player is successfully ADDED. >\n");

                            displayPlayer();

                        } else if (confirm.equalsIgnoreCase("N")) {
                            System.out.println("\n< ADD process aborted. >\n");

                        } else {

                            do {
                                System.out.println("\n!! Invalid option, please try again. !!");

                                System.out.println("\nDo you confirm to add this player (Y/N)?");
                                System.out.print("\nAns: ");

                                confirm = scanner.nextLine();

                            } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

                            if (confirm.equalsIgnoreCase("Y")) {

                                addPlayer(name, gender, age, ac);

                                System.out.println("\n< New Player is successfully ADDED. >\n");

                                displayPlayer();

                            } else if (confirm.equalsIgnoreCase("N")) {
                                System.out.println("\n< ADD process aborted. >\n");
                            }

                        }
                        System.out.println("\n!! PRESS ENTER TO CONTINUE !!");
                        rewind = scanner.nextLine();

                        break;
                    }

                }

            } else if (option == 3) {
                int choice, tempChoice;

                System.out.println("\n********************");
                System.out.println("*  DELETE PLAYER   *");
                System.out.println("********************\n");

                displayPlayer();

                System.out.println("\nWhich player do you want to delete (No.) ? ");
                System.out.print("\nAns: ");

                do {

                    while (!scanner.hasNextInt()) {
                        System.out.print("\n!! Please Enter a Valid Number !! : ");
                        scanner.next();
                    }

                    tempChoice = scanner.nextInt();

                    if (tempChoice < 1 || tempChoice > playerList.getLength()) {
                        System.out.print("\n!! Please Enter a Valid Player !! : ");
                    }

                } while (tempChoice < 1 || tempChoice > playerList.getLength());

                choice = tempChoice;

                System.out.println("NO.   ID         NAME                 GENDER    AGE     SCORE");
                System.out.println("---   --------   ------------------   -------   -----   -------");
                System.out.println(choice + "     " + playerList.getEntry(choice).toString());

                System.out.println("\nDo you confirm to delete this player (Y/N)?");
                System.out.print("\nAns: ");
                rewind = scanner.nextLine();
                confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {

                    deletePlayer(choice);

                    System.out.println("\n< Player successfully DELETED.   >\n");

                    displayPlayer();

                } else if (confirm.equalsIgnoreCase("N")) {
                    System.out.println("\n< DELETE process aborted.   >\n");
                } else {

                    do {
                        System.out.println("\n!! Invalid option, please try again. !!");

                        System.out.println("\nDo you confirm to delete this player (Y/N)?");
                        System.out.print("\nAns: ");
                        confirm = scanner.nextLine();

                    } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

                    if (confirm.equalsIgnoreCase("Y")) {

                        deletePlayer(choice);

                        System.out.println("\n< Player successfully DELETED.   >\n");

                        displayPlayer();

                    } else if (confirm.equalsIgnoreCase("N")) {
                        System.out.println("\n< DELETE process aborted.   >\n");

                    }
                }

                System.out.println("\n!! PRESS ENTER TO CONTINUE !!");
                rewind = scanner.nextLine();

            } else if (option == 0) {
                return true;
            }

        } while (option != 1);
        return false;
    }

    public void readPlayerFile() {
        try {
            File file = new File("players.dat");
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            playerList = (ArrayList) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("!! File not found !!");
        } catch (IOException ex) {
            System.out.println("!! Cannot read from file !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("!! Class not found !!");
        }

    }

    public void writePlayerFile() {
        try {
            File file = new File("players.dat");
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(playerList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("!! File not found !!");
        } catch (IOException ex) {
            System.out.println("!! Cannot save to file !!");
        }
    }

    public void addPlayer(String name, char gender, int age, Achievement ac) {
        if (!playerList.isFull()) {
            playerList.add(new Player(name, gender, age, 0, ac));
        }

    }

    public void deletePlayer(int pIndex) {
        if (!playerList.isEmpty()) {
            playerList.remove(pIndex);
        } else {
            System.out.println("\n!! No player to delete !!\n");
        }
    }

    public void displayPlayer() {
        int pCount = 0;
        System.out.println("\n*******************");
        System.out.println("*   PLAYER LIST   *");
        System.out.println("*******************\n");
        System.out.println("NO.   ID         NAME                 GENDER    AGE     SCORE");
        System.out.println("---   --------   ------------------   -------   -----   -------");
        for (int i = 0; i < playerList.getLength(); i++) {
            if (playerList.getEntry(i + 1) != null) {
                System.out.println(pCount + 1 + "     " + playerList.getEntry(i + 1).toString());
                pCount++;
            }
        }
        System.out.println("\n < Total : " + playerList.getLength() + " player(s) in the system. >\n");

    }

    public int getLength() {
        return playerList.getLength();
    }

    public boolean isAlpha(String name) {
        if (name.matches("[a-zA-Z]+") || name.contains(" ")) {
            return true;
        } else {
            return false;
        }
    }

    public int isFoundFile() {
        int found = 0;
        File file = new File("players.dat");
        if (file.exists()) {
            found = 1;
        }
        return found;
    }
}
