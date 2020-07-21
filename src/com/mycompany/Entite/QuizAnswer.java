package com.mycompany.Entite;

public class QuizAnswer {
    private Double id;
    private String content;
    private Double points;
    private boolean selected = false;

    public QuizAnswer() {

    }

    public QuizAnswer(Double id, String content, Double points) {
        this.id = id;
        this.content = content;
        this.points = points;
    }
    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }
}
