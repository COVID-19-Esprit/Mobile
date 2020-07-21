package com.mycompany.gui;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.animations.Transition;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.Quiz;
import com.mycompany.Entite.QuizAnswer;
import com.mycompany.Service.QuizService;

import java.util.ArrayList;

public class QuizGUI {
    private Form quizGUI,parent;
    private Button nextButton = new Button("next");
    private Button previousButton = new Button("previous");
    //private Container buttonsContainer = new Container(BoxLayout.x());
    private ArrayList<Quiz> quizzes = new ArrayList<>();
    private static int pageIndex = 0;


    public QuizGUI(Form parent) {
        this.parent = parent;
        quizGUI = new Form("Quiz", BoxLayout.y());
        quizGUI.getToolbar().addCommandToLeftBar("back",null,(ev)->{
            parent.showBack();
        });
        quizzes = QuizService.getQuizs();

        /* Init onClick buttons  */
        nextButtonInit();
        previousButtonInit();

        // init First Container





        quizGUI.addComponent(setPageUI(pageIndex));
        quizGUI.addComponent(nextButton);
        quizGUI.addComponent(previousButton);



    }
    public Form getQuizGUI() {
        return quizGUI;
    }

    public Container setPageUI(int  pageIndex) {



        Container container = new Container();
        container.setLayout(BoxLayout.y());


        container.addComponent(new Label(quizzes.get(pageIndex).getTitle() + " :"));
        SpanLabel question  = new SpanLabel(quizzes.get(pageIndex).getQuestion());
        container.addComponent(question);
        for (QuizAnswer answer: quizzes.get(pageIndex).getAnswers()) {
            MultiButton multiButton = new MultiButton("");
            multiButton.setCheckBox(true);
            SpanLabel answerLabel = new SpanLabel(answer.getContent());
            answerLabel.getTextUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN,Font.SIZE_SMALL));


            multiButton.setSelected(answer.isSelected());

            multiButton.setScrollableY(true);

            multiButton.add(BorderLayout.WEST,answerLabel);

            multiButton.addActionListener(e -> {
                answer.setSelected(!answer.isSelected());
            });
            container.addComponent(multiButton);
        }


        return container;

    }

    public Container nextQuiz() {
        pageIndex++;
        return setPageUI(pageIndex);
    }
    private Container previousQuiz() {
        pageIndex--;
        return setPageUI(pageIndex);
    }

    public void nextButtonInit() {
        nextButton.addActionListener((e)-> {
            if(pageIndex<quizzes.size()-1) {
                if(pageIndex == quizzes.size() -2){
                        nextButton.setText("Submit");
                        nextButton.addActionListener((event)-> {
                            QuizResultGUI quizResultGUI = new QuizResultGUI(parent,result() >50 );
                            quizResultGUI.geTGui().show();
                        });
                }
                quizGUI.getContentPane()
                        .replace(quizGUI.getContentPane().getComponentAt(0), nextQuiz(), new Transition() {
                            @Override
                            public boolean animate() {
                                return false;
                            }

                            @Override
                            public void paint(Graphics graphics) {

                            }
                        });
            } else {

            }

        });
    }
    public void previousButtonInit() {
        previousButton.addActionListener((e) -> {
            if (pageIndex>0)
                quizGUI.getContentPane()
                        .replace(quizGUI.getContentPane().getComponentAt(0), previousQuiz(), new Transition() {
                            @Override
                            public boolean animate() {
                                return false;
                            }

                            @Override
                            public void paint(Graphics graphics) {

                            }
                        });

        });
    }

    private double result() {
        double sum = 0.0;
        for (Quiz quiz: quizzes) {
            for(QuizAnswer quizAnswer : quiz.getAnswers()) {
                if (quizAnswer.isSelected()) {
                    sum += quizAnswer.getPoints();
                }
            }
        }
        return sum;
    }

}
