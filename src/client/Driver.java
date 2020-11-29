package client;

import adt.ArrayList;
import adt.CircularArrayQueue;
import adt.PriorityQueue;
import java.util.Scanner;
import entity.Player;
import entity.SpecialSkill;
import entity.Quiz;

public class Driver {

    public static void main(String[] args) {
        //initial your data here before game run if you did not use file: 
        //Here I am using array to stored my unformated data
        //You all can choose start with array first or direct initiallise your data in adt
        //the reason put at here is because the data should only initial once when game start
        SpecialSkill[] arrSkill = new SpecialSkill[10];
        arrSkill[0] = new SpecialSkill("PACK_ONE", "A mystery power can help you remove one wrong answer, Since this is a package means this skill have double use times", 2, 'A');
        arrSkill[1] = new SpecialSkill("PROTECTION", "A mystery power protect your life", 1, 'A');
        arrSkill[2] = new SpecialSkill("HALF", "A mystery power help you delete two wrong answer", 1, 'A');
        arrSkill[3] = new SpecialSkill("LIFE", "Respawn with 1 life", 1, 'A');
        arrSkill[4] = new SpecialSkill("HEAL", "Be happy now your life +1", 1, 'B');
        arrSkill[5] = new SpecialSkill("ONE", "A mystery power can help you remove one wrong answer", 1, 'B');
        arrSkill[6] = new SpecialSkill("NOTHING", "Really Nothing", 1, 'C');
        arrSkill[7] = new SpecialSkill("NOTHING", "Really Nothing", 1, 'C');
        arrSkill[8] = new SpecialSkill("ONLY_ONE", "A mystery power help you remove all wrong answer. \n Just select the answer please.", 1, 'S');
        arrSkill[9] = new SpecialSkill("REAL LIFE", "You will Respawn with full 3 life. \n But it is necessary for you in this short journey ?? ", 1, 'S');
        //here is how you transfer data to your own class
        SkillsFunction.arrSkill = arrSkill;
        //here is my own initial function ignore it
        SkillsFunction.initialSkillSet();


        Scanner scan = new Scanner(System.in);
        PlayerMenu pm = new PlayerMenu();
        AnimalList al = new AnimalList();
        QuizModule qm = new QuizModule();
        Scoreboard sb = new Scoreboard();

        //Read Player File
        if (pm.isFoundFile() == 1) {
            pm.readPlayerFile();

        } else {
            pm.writePlayerFile();

        }
        
        //Read Score File
        if (sb.isFileFound() == 1) {
            if (sb.isFileEmpty() == true) {
                sb.writeScoreFile();
            }
            sb.readScoreFile();
        } else {
            sb.writeScoreFile();
        }

        int choice = 0;
        while (true) {
            System.out.println("\nWELCOME TO BIG BRAIN!");
            System.out.println("Are you a big brain? Test it now!");
            System.out.println("1. START GAME");
            System.out.println("2. ACHIEVEMENTS");
            System.out.println("3. SCOREBOARD");
            System.out.println("4. QUIZ");
            System.out.println("0. EXIT");
            System.out.printf("Enter a selection (0-4): ");

            do {
                while (!scan.hasNextInt()) {
                    System.out.printf("Invalid choice. Please enter a valid choice (0-4) : ");
                    scan.next();

                }

                choice = scan.nextInt();

                if (choice < 0 || choice > 4) {
                    System.out.printf("Invalid choice. Please enter a valid choice (0-4) : ");
                }

            } while (choice < 0 || choice > 4);

            switch (choice) {
                case 1:
                    startGame(pm, al, qm, sb);
                    break;
                case 2:
                    AchievementHolder(al);
                    break;
                case 3:
                    sb.scoreMenu();
                    break;
                case 4:
                    qm.quizMenu();
                    break;
                case 0:
                    sb.writeScoreFile();
                    pm.writePlayerFile();
                    System.exit(0);
                    ;
            }
        }

    }

    public static void startGame(PlayerMenu pm, AnimalList al, QuizModule qm, Scoreboard sb) {
        Scanner scan = new Scanner(System.in);       
        PriorityQueue<Quiz> questionSet = new PriorityQueue<Quiz>();

        //initial the question set
        questionSet = qm.quizSet(1, 20);
        //temporary place to store question get from priority queue

        Quiz tempQues;
        
        pm.displayPlayer();

        if(pm.PlayerModule())
            return;
        

        int totalPlayer = 0;
        int game = 1;

        System.out.println("\n********************");
        System.out.println("* SELECT PLAYER(S) *");
        System.out.println("********************\n");
        System.out.println("GAME MODES ");
        System.out.println("1. 1 player");
        System.out.println("2. 2 players");
        System.out.println("3. 3 players");
        System.out.println("4. 4 players");
        System.out.printf("Choose a game mode: ");

        //Choose game mode + validation
        do {
            while (!scan.hasNextInt()) {
                System.out.printf("please try again: ");
                scan.next();
            }

            totalPlayer = scan.nextInt();

            if (totalPlayer < 1 || totalPlayer > 4) {
                System.out.printf("please try again: ");
            }

        } while (totalPlayer < 1 || totalPlayer > 4);

        ArrayList<Player> playingList = new ArrayList<Player>();
        System.out.println(playingList.toString());

        //Select player + validation
        int selectedPlayer = 0;
        System.out.println("Please Select " + totalPlayer + " Player(s) from the list (1-" + pm.getLength() + ")...");
        for (int i = 0; i < totalPlayer; i++) {
            System.out.printf("Player " + (i + 1) + " will be: ");
            do {
                while (!scan.hasNextInt()) {
                    System.out.printf("please try again: ");
                    scan.next();
                }

                selectedPlayer = scan.nextInt();

                if (selectedPlayer < 1 || selectedPlayer > pm.getLength() || playingList.contains(pm.playerList.getEntry(selectedPlayer))) {
                    System.out.printf("please try again: ");
                }
            } while (selectedPlayer < 1 || selectedPlayer > pm.getLength() || playingList.contains(pm.playerList.getEntry(selectedPlayer)));

            playingList.add(pm.playerList.getEntry(selectedPlayer));

        }

        Game players[] = new Game[totalPlayer];
        for (int i = 0; i < totalPlayer; i++) {
            players[i] = new Game(playingList.getEntry(i + 1));
        }

        ArrayList<Game> gameList = new ArrayList();

        for (int i = 0; i < totalPlayer; i++) {
            gameList.add(players[i]);
        }

        //print selected playingList
        System.out.println("\nPlayer selected are...\n" + playingList);

        CircularArrayQueue line = new CircularArrayQueue(gameList);//123
        CircularArrayQueue score = new CircularArrayQueue(gameList);//123

        int numOfQues = 5 * line.getSize();
        boolean empty = false;
        System.out.println("Total number of question need to answer : " + numOfQues);
        //starting of while loop if still have player alive or question continue
        int qNo=1;
        while (empty != true && numOfQues != 0) {
            Game temp = (Game) line.dequeue(); //temp = 123
            //put question
            //check the life of player
            tempQues = questionSet.poll();
            System.out.println("\n"+qNo+"=> "+tempQues.getQues_desc());
            String[] optionArray = tempQues.getOptions();
            int ansQues = tempQues.getAnswer();
            for (int i = 0; i < optionArray.length; i++) {
                int num = i + 1;
                System.out.println(num + ") " + optionArray[i]);
            }
            //player answer 
            System.out.printf(temp.player.getName() + " please answer 1-4 (9 for use your SKILL): "); //123
            int answer = scan.nextInt();

            //if right add mark
            if (answer == ansQues) {
                System.out.println("Your answer is CORRECT");
                temp.addMark();
            } else if (answer == 9) {
                // WAIT QUESTION
                temp.useSkill(ansQues, optionArray.length);
                System.out.printf("Please enter Your Answer for the Question: ");
                answer = scan.nextInt();
                if (answer == ansQues) {
                    System.out.println("Your answer is CORRECT");
                    temp.addMark();
                } else {
                    System.out.println("Your answer is WRONG." + " The answer is " + ansQues);
                    System.out.println(tempQues.getAnswer_fact());
                    temp.lifeMinus();
                    System.out.println("Your Life now : " + temp.life);
                }

            } //minus life because wrong answer
            else {
                System.out.println("Your answer is WRONG." + " The answer is " + ansQues);
                System.out.println(tempQues.getAnswer_fact());
                 temp.lifeMinus();
                 System.out.println("Your Life now : " + temp.life);
            }

            if (temp.life != 0) {
                line.enqueue(temp);
            }

            numOfQues--;
            qNo++;
            if (line.isEmpty()) {
                empty = true;
            }

        }

        int i = 1;
        while (!score.isEmpty()) {
            Game temp = (Game) score.dequeue();
            System.out.println("");

            //add setScore to playerList(i)
            playingList.getEntry(i).setScore(playingList.getEntry(i).getScore() + temp.score);

            //print name and score
            System.out.println(temp.player.getName() + "\t" + temp.getScore());

            //update score to scoreList
            sb.updateScore(temp.player.getName(), temp.getScore());
            sb.writeScoreFile();

            //to determine their animal, pass score
            System.out.println(al.showAnimal(temp.getScore()));

            //get animal index
            int animalIndex = al.animalIndex(temp.getScore());

            //update player's animal achievement base on returned animal index
            playingList.getEntry(i).achievement.updateAcvm(animalIndex);

            //print player highest scored animal
            System.out.println(playingList.getEntry(i).achievement.showHighestAchieve());

            if (al.animalList.getEntry(animalIndex).getHighestCount() <= playingList.getEntry(i).achievement.getHighestCount(animalIndex)) {
                al.animalList.getEntry(animalIndex).setHighestCount(playingList.getEntry(i).achievement.getHighestCount(animalIndex));
                al.animalList.getEntry(animalIndex).setTitleHolder(temp.player.getName());
                System.out.println("\nAttention:");
                System.out.println(temp.player.getName() + " has just claimed the achievement title of "
                        + al.animalList.getEntry(animalIndex).getName() + " with highest count of "
                        + al.animalList.getEntry(animalIndex).getHighestCount() + "!\nYou may check title holder under Achievements in main menu.");
            }

            i++;

        }

        System.out.println("");
        System.out.println(playingList.toString());
        sb.displayGameScore();
        SkillsFunction.resetSkillSet();
    }

    public static void AchievementHolder(AnimalList al) {
        //print title holder (achivement holder)
        System.out.println("Current Animal Title holder:");
        System.out.println("An animal title is given to a player who has gotten an animal title for the most time");
        System.out.printf("%-20s %-20s %s\n", "Animal", "Player", "Earn(s)");
        for (int i = 2; i <= al.animalList.getLength(); i++) {
            System.out.println(al.animalList.getEntry(i).showAchievers());
        }
        System.out.println("");
    }

}
