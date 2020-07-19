package com.mycompany.gui;

import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

public class QuizGUI {
    private Form quizGUI;


    public QuizGUI() {
        quizGUI = new Form("Quiz", BoxLayout.y());

    }
    public Form getQuizGUI() {
        return quizGUI;
    }

}
