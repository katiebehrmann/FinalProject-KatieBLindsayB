package com.example.android.climatehero;

import java.io.Serializable;

/**
 * Created by katie on 4/25/17.
 */

public class Score implements Serializable {

    private int score;
    private String action;
    private int photoID;

    public Score(int score, String action, int photoID) {
        this.score = score;
        this.action = action;
        this.photoID = photoID;
    }

    public Score() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                ", action='" + action + '\'' +
                ", photoID=" + photoID +
                '}';
    }
}
