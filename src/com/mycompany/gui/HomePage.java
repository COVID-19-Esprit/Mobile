/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanButton;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author Achref
 */
public class HomePage {
    
 Form f;
    
    SpanButton  bt1,bt2,bt3,bt4,bt5;
    Label lb;

    public HomePage() {
        f = new Form("Covid-19 Application", BoxLayout.y());
        bt1 = new SpanButton("What Is Covid-19 ?");
        bt2=new SpanButton("Protect Yourself From Covid-19 ");
         bt3 = new SpanButton("Quiz Test Covid-19");
          bt4 = new SpanButton("Latest news");
           bt5 = new SpanButton("Order");
           
        f.add(bt1);
        f.add(bt2);
        f.add(bt3);
        f.add(bt4);
        f.add(bt5);
        
        bt5.addActionListener((e) -> {
            Login a = new Login();
           a.getLogin().show();

            

        });
        bt3.addActionListener((e) -> {
            QuizGUI quizGUI = new QuizGUI();
            quizGUI.getQuizGUI().show();
        });
        
     
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

  

    

}
