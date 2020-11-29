/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author SheaJing
 */

import adt.PriorityQueue;
import adt.ArrayList;
import entity.Quiz;
import java.util.*;

public class QuizModule {
    
    public PriorityQueue<Quiz> quizBank = new PriorityQueue<Quiz>(30);  
    public PriorityQueue<Quiz> quizSet = new PriorityQueue<Quiz>();   
    public ArrayList<Quiz> readyQuiz = new ArrayList<Quiz>(30);

    Scanner scanner = new Scanner(System.in);
    
    public int total_question;
    
    private String[] ques_id = {"1002", "1001", "2001", "2002", "3001",
                                "1003", "1004", "3002", "2003", "2004",
                                "2006", "1005", "1006", "2005", "3003",
                                "3004", "1007", "2008", "1008", "2007",
                               };
    
    private String[] question = {"You are in a dark room with a candle, a wood stove, and a gas lamp. If you only have one match, what do you light first?",
                                 "The capital of Turkey is a strange word. Would you please spell it?",   
                                 "Forest is to tree as tree is to ?",
                                 "Some months have 31 days. Some have 30. How many have 28?",
                                 "At a conference, 12 members shook hands with each other before & after the meeting. How many total number of hand shakes occurred?",

                                 "I have three apples. If you take away two from me, how many do you have?",
                                 "An electric train is traveling SW at 60mph. The wind is blowing from the NE at 10mph. Which way is the smoke blowing?",
                                 "OCEAN is to AENCO as 89635 is to:",
                                 "I’m a male. If Albert’s son is my son’s father, what is the relationship between Albert and me? ",
                                 "If you rearrange the letters “RANDIEMAN” you’d have the name of a:",

                                 "Choose the word that is most similar to “Appropriate”:",
                                 "A plane crashes on the United States/Canada border. Where are the survivors buried?",
                                 "A farmer has 17 sheep; all but nine dies. How many are left? ",
                                 "29, 27, 24, 20, 15… What is next?",
                                 "Tina, who is 16 years old, is 4 times as old as her brother. How old will she be when she is twice as old as he?",

                                 "Which one of the numbers does not belong in the following series: 2-3-6-7-8-14-15-30",
                                 "If there are 3 rages and you take away 2, how many do you have?",
                                 "Virus is to Vaccines as Exam is to:",
                                 "Which one of the five is least like the other four? ",
                                 "If you rearrange the letter “CIFAIPC” you would have the name of a(n):",
                                };
    
    private String[][] option = {{"Candle", "Wood Stove", "Gas Lamp", "Match"}, 
                                 {"Ankara", "It", "Izmir", "Istanbul"},
                                 {"Plant", "Leaf", "Branch", "Mangrove"}, 
                                 {"1", "6", "10" ,"12"},
                                 {"100", "132", "145" ,"144"},
                         
                                 {"0", "1", "2" ,"3"},
                                 {"East", "West", "South" ,"None of all above"},
                                 {"85369", "56389", "56398" ,"65398"},
                                 {"Brother", "Uncle", "Father" ,"Sister"},
                                 {"Novel", "City", "Country" ,"Fruit"},
                         
                                 {"Irrelevant", "Untimely", "Suited", "Truthful"}, 
                                 {"United States", "Canada", "At the border", "None of all above"}, 
                                 {"0", "8", "9", "17"}, 
                                 {"7", "9", "10", "11"},  
                                 {"42", "23", "24", "32"}, 
                         
                                 {"8", "14", "15", "30"}, 
                                 {"1", "0", "2", "3"}, 
                                 {"Trying", "Passing", "Studying", "Failing"}, 
                                 {"Dog", "Mouse", "Lion", "Snake"},  
                                 {"City", "Animal", "Ocean", "River"},  
                                };
    
    private int[] answer = {4, 2, 2, 4, 2,
                            3, 4, 3, 3, 4,
                            3, 4, 3, 2, 3,
                            1, 3, 3, 4, 3
                           };
    
    private String[] ans_fact = {"The match must be lit before anything else can be lit.",
                                 "The question asks you to spell the word, “it”.",
                                 "As forest houses several trees, a tree has many leaves.",
                                 "All months have at least 28 days.",
                                 "First person shook hands with 11 people, second person shook hand with 10 because the first person has already been counted. Thus, 11+10+9+8+7+6+5+4+3+2+1 = 66 x 2 = 132.",

                                 "If YOU take two apples, YOU have two.",
                                 "Electric trains don’t give off smoke.",
                                 "By attributing each number to a letter from the word OCEAN, you find the solution.",
                                 "Albert’s son is me since I am my son's father.",
                                 "The quiz creator went on a tangent here and spelt the fruit mandarin as mandarine, the second most popular way to spell the citrus fruit.",

                                 "The exact definition of suited is “right or appropriate for a particular person, purpose or situation”.",
                                 "You don’t bury survivors.",
                                 "All the sheep die didn’t included those 9 sheep.",
                                 "The difference between numbers in the series increments by 1.",
                                 "Tina’s age 16 when her brother is at 4. Tina’s age is twice of her brother when her brother is at 12 and she is at 24 years old.",

                                 "The sequence’s pattern functions by adding one then multiplying by two.",
                                 "If you take away two oranges from three, you’ll have two with you and one left over.",
                                 "A virus is fixed by a vaccine, the same way an exam is helped by studying.",
                                 "The snake is the only animal without legs.",
                                 "Ocean - After rearranging, we have the letter “PACIFIC”.",
                                };
    
    public QuizModule() {   
        Quiz temporary = new Quiz();
        total_question = 20;
        
        for(int i = 0; i < total_question; i++) {
            temporary = new Quiz(ques_id[i], question[i], option[i], answer[i], ans_fact[i]);
            quizBank.add(temporary);
            readyQuiz.add(temporary);
        }
    }
    
    public void quizMenu() {
        int choice = 0, sure = 0;
        
        do{
            System.out.println("\n<--------- Quiz Menu --------->");
            System.out.println("|  1. Display & Search Quiz   |");
            System.out.println("|  2. Add Quiz                |");
            System.out.println("|  3. Remove Quiz             |");
            System.out.println("|  4. Modify Quiz             |");
            System.out.println("|  5. Clear Quiz              |");
            System.out.println("|  6. Exit Quiz               |");
            System.out.println("<----------------------------->");         
            
            System.out.printf("Enter your choice (1-6) : ");
            choice = integerValidation(1, 6);
                    
            switch(choice){
                case 1:
                    scanner.nextLine();
                    displaySearchQuiz();
                    break;
                case 2:
                    addQuiz();
                    break;
                case 3:
                    removeQuiz();
                    break;
                case 4:
                    modifyQuiz();
                    break;
                case 5:
                    clearAllQuiz();
                    break;
                default:
                    break;
            }
            
            System.out.printf("\nDo you still want to continue? (1=Yes/2=No) : ");
            sure = integerValidation(1, 2);
            
        } while(sure == 1);
        System.out.println("\nThank you for playing this game... ^-^ ");
    }
    
    public PriorityQueue quizSet(int start, int end) {
        Quiz temporary = new Quiz();
        
        for(int i = start; i <= end; i++) {
            temporary = readyQuiz.getEntry(i); 
            quizSet.add(temporary);
        }
        return quizSet;
    } 
    
    public void startQuiz(int start, int end) {
        int count, choice = 0;
        
        Quiz temporary = new Quiz();
        String[] optionInGame;
        int total_option;
        
        total_question = end - start + 1;
        
        for(int i = start; i <= end; i++) {
            temporary = readyQuiz.getEntry(i); 
            quizSet.add(temporary);
        }
        
        System.out.println("\n< ----- Welcome To The Big Brain Quiz Game ----- >");
        
        for(int i = 0; i < total_question; i++)
        {    
            Quiz quizDisplayed = quizSet.poll();
            total_option = quizDisplayed.getOptions().length;
            
            optionInGame = new String[total_option];
            optionInGame = quizDisplayed.getOptions();
            
            System.out.println("\nQuestion ID : " + quizDisplayed.getQues_id());
            System.out.println("Question " + (i+1) + "  : " + quizDisplayed.getQues_desc());
            
            count = 1;
            for(int j = 0; j < total_option; j++)
            {
                System.out.println("Option " + count + "    : " + optionInGame[j]);
                count++;
            }
            System.out.printf("Select your answer : ");
            choice = integerValidation(1, total_option);
            
            quizDisplayed.compareAnswer(choice);
        }
    }
    
    public Quiz displaySearchQuiz() {
        Quiz search_quiz = new Quiz();
        Quiz compare_quiz = new Quiz();
        String search_quiz_id = null;
        
        System.out.println("\n< ------------------ Search and Display Quiz ------------------ >");
        if(quizBank.isEmpty())
            System.out.println("Quiz not found because the record is empty");
        System.out.println(quizBank.toString());
        
        do {
            System.out.printf("Enter Quiz id to search : ");
            search_quiz_id = scanner.nextLine();
        } while (search_quiz_id == null);
        
        compare_quiz = new Quiz(search_quiz_id);
        
        if(!quizBank.contains(compare_quiz)) {
            System.out.println("Quiz not found");
            return null;
        }
        else {
            search_quiz = quizBank.remove(compare_quiz);
            displayForConfirmation(search_quiz);
            quizBank.add(search_quiz);
            return search_quiz;
        }       
    }
    
    public void addQuiz() {
        boolean successful;
        int count, sure = 0;
        
        int totalOption = 0;
        Quiz temporary = new Quiz();
                
        int add_answer = 0;
        String[] add_options;
        String add_ques_id, add_ques_desc, add_ans_fact;
        
        System.out.println("\n< ---- Add New Quiz ---- >");
        System.out.printf("\nQuiz id                : ");
        add_ques_id = scanner.next();
        
        System.out.printf("\nQuestion               : ");
        add_ques_desc = scanner.next();
        
        System.out.printf("\nTotal options provided : ");
        totalOption = integerValidation(0, 10);
                        
        add_options = new String[totalOption];
        
        count = 1;
        for(int i = 0; i < add_options.length; i++){
            System.out.printf("\nOption " + count + "               : ");
            add_options[i] = scanner.next();
            count++;
        }
        
        System.out.printf("\nAnswer at option       : ");
        add_answer = integerValidation(0, totalOption);
        
        System.out.printf("\nAnswer fact            : ");
        add_ans_fact = scanner.next();
        
        temporary = new Quiz(add_ques_id, add_ques_desc, add_options, add_answer, add_ans_fact);
        /*Print again the quiz for double checking purpose*/
        displayForConfirmation(temporary);
        
        /*Intger Validation Included*/
        System.out.printf("\nSure to add the quiz? (1=Yes/2=No) : ");
        sure = integerValidation(1, 2);
        
        if(sure == 1){        
            if(quizBank.contains(temporary)) {
                System.out.println("\nSame quiz already exist in the system...");
                System.out.println("\nNew quiz is failed to be added into the system...");
                successful = false;
            }     
            else{
                successful = quizBank.add(temporary);
                
                if(successful)
                    System.out.println("\nNew quiz has been successfully added...");
                else 
                    System.out.println("\nNew quiz is failed to be added into the system...");
            }
        }
        else
            System.out.println("\nThis quiz will not be added..."); 
        System.out.println("Thanks for your effort...");
    }
    
    public void removeQuiz() {
        int sure = 0;
        String remove_ques_id;
        Quiz remove_quiz = null;
        Quiz compare_quiz = null;
        Quiz temporary = new Quiz();
        
        System.out.println("\n< ---- Remove Quiz ---- >");
        System.out.printf("\nEnter the id of the quiz to be removed : ");
        remove_ques_id = scanner.next();
        compare_quiz = new Quiz(remove_ques_id);
        
        if(!quizBank.contains(compare_quiz))
            System.out.println("Quiz id does not existed");
        else {
            remove_quiz = quizBank.remove(compare_quiz);
            displayForConfirmation(remove_quiz);
            
            System.out.printf("\nSure to remove the quiz? (1=Yes/2=No) : ");
            sure = integerValidation(1, 2);
                
            if(sure == 1) {
                for(int i = 1; i <= readyQuiz.getLength(); i++){
                    temporary = readyQuiz.getEntry(i);
                    if(temporary.compareTo(compare_quiz) == 0){
                        readyQuiz.remove(i);
                        System.out.println("\nQuiz " + (i + 1) + "has been removed from the ready quiz");
                        System.out.println("Remember to add in new quiz to the quiz prepared ...");
                    }                   
                }
                System.out.println("This quiz has been successfully deleted...");
            }
            else{
                quizBank.add(remove_quiz);
                System.out.println("\nThe quiz with id " + remove_ques_id + " will not be removed");
            }           
        }    
        System.out.println("Thanks for your effort...");
    }
    
    private void displayForConfirmation(Quiz quizToShow) {
        String[] optionToShow;
        int count;
        
        System.out.println("\n\nQuiz id          : " + quizToShow.getQues_id());
        System.out.println("Question         : " + quizToShow.getQues_desc());
        
        optionToShow = new String[quizToShow.getOptions().length];
        optionToShow = quizToShow.getOptions();
            
        count = 1;
        for(int i = 0; i < optionToShow.length; i++){
            System.out.println("Option " + count + "         : " + optionToShow[i]);
            count++;
        }

        System.out.println("Answer at option : " + quizToShow.getAnswer());
        System.out.println("Answer fact      : " + quizToShow.getAnswer_fact());
    }
    
    public void modifyQuiz() {
        boolean successful;
        int count, choice = 0, sure = 0;
        
        int totalOption = 0;
        int modify_ans = 0, indexOfModifiedItem = 0;
        
        String modify_ans_fact = "", modify_quiz_id = "";
        String[] modify_option = null;
        Quiz quiz_to_modify = new Quiz();
        Quiz temporary = new Quiz();
        Quiz compare_quiz = null;
        
        System.out.println("\n< ---- Modify Existing Quiz ---- >");
        System.out.printf("\nQuiz id : ");
        modify_quiz_id = scanner.next();
        
        compare_quiz = new Quiz(modify_quiz_id);
        if(!quizBank.contains(compare_quiz))
            System.out.println("Quiz not found...");
        else{
            quiz_to_modify = quizBank.remove(compare_quiz);
            displayForConfirmation(quiz_to_modify);
            
            System.out.println("\n<---- Choose what to modify ---->");
            System.out.println("|     1. Question options       |");
            System.out.println("|     2. Question answer        |");
            System.out.println("|     3. Answer fact            |");
            System.out.println("<------------------------------->");
            
            System.out.printf("Enter your choice : ");
            choice = integerValidation(1, 3);

            switch(choice){
                case 1:           
                    System.out.printf("\nTotal number of options : ");
                    totalOption = integerValidation(1, 10);
                                      
                    modify_option = new String[totalOption];

                    count = 1;
                    for(int i = 0; i < modify_option.length; i++){
                        System.out.printf("\nOption " + count + "                : ");
                        modify_option[i] = scanner.next();
                        count++;
                    }
                    break;
                case 2:              
                    System.out.printf("\nQuestion answer         : ");
                    modify_ans = integerValidation(1, 10);
                    break;
                case 3:
                    System.out.printf("\nAnswer fact             : ");
                    modify_ans_fact = scanner.next();
                    break;
                default:
                    break;
            }
            
            System.out.printf("\nDo you sure to modify? (1=Yes/2=No) : ");
            sure = integerValidation(1, 2);

            if(sure == 1){    
                for(int i = 1; i < readyQuiz.getLength(); i++){
                    temporary = readyQuiz.getEntry(i);
                    if(temporary.compareTo(compare_quiz) == 0){
                        quiz_to_modify = temporary;
                        indexOfModifiedItem = i;
                        readyQuiz.remove(i);
                    }
                }
                    
                if(choice == 1)
                    quiz_to_modify.setOptions(modify_option);
                else if(choice == 2)
                    quiz_to_modify.setAnswer(modify_ans);
                else
                    quiz_to_modify.setAnswer_fact(modify_ans_fact);
            }
            
            quizBank.add(quiz_to_modify);       
            successful = readyQuiz.add(indexOfModifiedItem, quiz_to_modify);

            if(successful)
                System.out.println("\nThis quiz has been successfully modified..."); 
            else 
                System.out.println("\nThe quiz with id " + modify_quiz_id + " is failed to modify");
        } 
        System.out.println("Thanks for your effort...");
    }  
    
    private int integerValidation(int min, int max) {
	int range, data;
	    
	do {
            
            while (!scanner.hasNextInt()) {
                System.out.printf("\n!! Please Enter a Valid Number !! : ");
                scanner.next();
            }
            data = scanner.nextInt();
            
            if (data < min || data > max)
                System.out.printf("\n!! Please Enter a Valid Number !! : ");
        } while (data < min || data > max);
        
        return data;
    }
    
    public void clearAllQuiz() {
        quizBank.clear();
        readyQuiz.clear();
        System.out.println("All the quiz has been cleared froom the system...");
    }
}
