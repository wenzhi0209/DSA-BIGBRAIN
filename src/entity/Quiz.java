/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author SheaJing
 */

public class Quiz implements Comparable<Quiz> {
    
    String ques_id;
    String ques_desc;
    String[] options;
    int answer;
    String answer_fact;

    public Quiz() {}

    public Quiz(String ques_id) {
        this.ques_id = ques_id;
    }

    public Quiz(String ques_id, String ques_desc, String[] options, int answer, String answer_fact) {
        this.ques_id = ques_id;
        this.ques_desc = ques_desc;
        this.options = options;
        this.answer = answer;
        this.answer_fact = answer_fact;
    }
    
    public Quiz(Quiz element) {
        this.ques_id = element.getQues_id();
        this.ques_desc = element.getQues_desc();
        this.options = element.getOptions();
        this.answer = element.getAnswer();
        this.answer_fact = element.getAnswer_fact();
    }

    public void setQues_id(String ques_id) {
        this.ques_id = ques_id;
    }

    public void setQues_desc(String ques_desc) {
        this.ques_desc = ques_desc;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
    
    public void setAnswer_fact(String answer_fact) {
        this.answer_fact = answer_fact;
    }

    public String getQues_id() {
        return ques_id;
    }

    public String getQues_desc() {
        return ques_desc;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }

    public String getAnswer_fact() {
        return answer_fact;
    }

    @Override
    public String toString() {
        String quiz_info = "";
        quiz_info += "Quiz( " + "ques_id =" + ques_id + ", ques_desc =" + ques_desc + ", options =";
        for(int i = 0; i < options.length; i++)
            quiz_info += options[i] + ", ";
        quiz_info +=  "answer =" + answer + ", answer_fact =" + answer_fact + " )";
        return quiz_info;
    }
    
    public void compareAnswer(int answerObtain)
    {
        if(answerObtain != answer)
            System.out.println("\nAnswer wrong...\n" + "The correct answer is option " + (answer+1) + "\n" + "Reason : " + answer_fact);
        else
            System.out.println("\nCongratulation, your answer is correct!!!");
    } 

    public boolean equals(Object other) {
        boolean result;

        if ((other == null) || (getClass() != other.getClass())) {
            result = false;
        } 
        else {
            Quiz otherQuiz = (Quiz) other;
            result = ques_id.equals(otherQuiz.getQues_id());
        } 

        return result;
    } 

    public int compareTo(Quiz otherQuiz) {
        return ques_id.compareTo(otherQuiz.getQues_id());
    }
}
