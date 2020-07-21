/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MediaPlayer;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.Information;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Form hi1 = new Form(" What is Covid-19 ", new FlowLayout(CENTER,CENTER));
                String file = "/What is COVID-19.mp4";
                try {
                    Media video = MediaManager.createMedia(file, true);
                    hi1.removeAll();
                    hi1.add(new MediaPlayer(video));
                    video.play();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
                hi1.getToolbar().addCommandToLeftBar(" Home ", null, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        f.showBack();
                    }
                });
                hi1.show();
            }
        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Form hi2 = new Form(" Protect yourself from Covid-19 ", new FlowLayout());
                Information info1 = new Information("What are the symptoms ?", "/1.PNG");
                Information info2 = new Information("How is it transmitted ?", "/2.PNG");
                Information info3 = new Information("How to prevent it ?", "/3.PNG");
                Information info4 = new Information("When to wear a mask ?", "/4.PNG");
                Information info5 = new Information("How does case surveillance and notification work in tunisia ?", "/5.PNG");
                Information info6 = new Information("How is the diagnosis made ?", "/6.PNG");
                List<Information> teams = new ArrayList();
                teams.add(info1);
                teams.add(info2);
                teams.add(info3);
                teams.add(info4);
                teams.add(info5);
                teams.add(info6);
                for(Information i : teams){
                    Container cn = new Container(BoxLayout.x());
                    try {
                        Image img = Image.createImage(i.getImg());
                        ImageViewer iv = new ImageViewer(img);
                        Label lb = new Label(i.getTitre());
                        lb.addPointerReleasedListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                Form hi4 = new Form(i.getTitre(), BoxLayout.y());
                                Image img2;
                                try {
                                    img2 = Image.createImage(i.getImg());
                                    ImageViewer iv2 = new ImageViewer(img2);
                                    SpanLabel sl = new SpanLabel("");
                                    hi4.add(iv2);
                                    hi4.add(sl);
                                    hi4.show();
                                    hi4.getToolbar().addCommandToRightBar("Back", null, new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent evt) {
                                            hi2.showBack();
                                        }
                                    });
                                } catch (IOException ex) {
                                    System.err.println(ex.getMessage());
                                }
                            hi4.show();    
                            }
                        });
                        cn.add(iv);
                        cn.add(lb);
                        hi2.add(cn);
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                }                
                hi2.getToolbar().addCommandToLeftBar("< Home", null, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        f.showBack();
                    }
                });    
                hi2.show();
            }
        });
        f.add(bt1);
        f.add(bt2);
        f.add(bt3);
        f.add(bt4);
        f.add(bt5);
        
        bt5.addActionListener((e) -> {
            Login a = new Login();
           a.getLogin().show();

            

        });
        
        
     
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

  

    

}
