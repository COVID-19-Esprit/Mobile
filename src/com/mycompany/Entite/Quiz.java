package com.mycompany.Entite;

import java.util.ArrayList;

public class Quiz {
    private Double id;
    private String title;
    private String question;
    private Double points;


    private ArrayList<QuizAnswer> answers;

    public Quiz(){}

    public Quiz(Double id, String title, String question, Double points,ArrayList<QuizAnswer> answers) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.points = points;
        this.answers = answers;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }


    public ArrayList<QuizAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<QuizAnswer> answers) {
        this.answers = answers;
    }
}
