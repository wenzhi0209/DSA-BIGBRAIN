/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Chin Yew
 */
public class Score implements Comparable<Score>, Serializable {

    String playerName;
    int playerScore;

    public Score() {
    }

    public Score(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    @Override
    public int compareTo(Score s) {
        return this.playerScore - s.getPlayerScore();
    }

    @Override
    public String toString() {
        return String.format("\t%-17s %8d", playerName, playerScore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Score)) {
            return false;
        }

        Score score = (Score) o;
        return playerName.equals(score.playerName);
    }

    @Override
    public int hashCode() {
        return playerName.hashCode();
    }

}
