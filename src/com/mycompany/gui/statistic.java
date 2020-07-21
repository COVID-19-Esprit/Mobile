/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.io.URL;
import com.codename1.io.URL.HttpURLConnection;
import com.codename1.ui.*;
import com.codename1.ui.animations.Transition;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Quiz;
import com.mycompany.Entite.QuizAnswer;
import com.mycompany.Service.QuizService;

import java.io.IOException;
import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Hashtable;


/**
 *
 * @author Flexos
 */


public class statistic {

    private Form statisticGUI,parent;
    private Label tc = new Label("Today Cases: ");
    private Label dpm = new Label("Deaths Per One Million: ");
    private Label active = new Label("Active: ");
    private Label cpm = new Label("Cases Per One Million: ");
    private Label tt = new Label("Total Tests: ");
    private Label td = new Label("Today Deaths: ");
    private Label deaths =  new Label("Deaths: ");
    private Label recovered = new Label("Recovered: ");
    private Label critical = new Label("critical: ");
    private Label tpom = new Label("Tests Per One Million: ");
    private Label cases  = new Label("Cases: ");
    private Button statButton = new Button("Stat: ");



    public statistic (Form parent) {
        this.parent = parent;
        statisticGUI = new Form("statistic", BoxLayout.y());
        statisticGUI.getToolbar().addCommandToLeftBar("back",null,(ev)->{
            parent.showBack();
        });


        /* Init onClick buttons  */


        // init First Container

        statButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ConnectionRequest r = new ConnectionRequest(){
                    String s;
                    Hashtable hash;
                    @Override
                    protected void postResponse() {

                    }

                    @Override
                    protected void readResponse(InputStream input) throws IOException {
                        JSONParser p = new JSONParser();
                        Hashtable hash = p.parse(new InputStreamReader(input));
                        tc.setText(tc.getText() + "  " +  hash.get("todayCases").toString());
                        dpm.setText(dpm.getText() + "  " +  hash.get("deathsPerOneMillion").toString());
                        active.setText(active.getText() + "  " +  hash.get("active").toString());
                        cpm.setText(cpm.getText() + " " + hash.get("casesPerOneMillion").toString());
                        tt.setText(tt.getText() + " " + hash.get("totalTests").toString());
                        td.setText(td.getText() + " " + hash.get("todayDeaths").toString());
                        deaths.setText(deaths.getText() + " " + hash.get("deaths").toString());
                        recovered.setText(recovered.getText() + " " + hash.get("recovered").toString());
                        critical.setText(critical.getText() + " " + hash.get("critical").toString());
                        tpom.setText(tpom.getText() + " " + hash.get("testsPerOneMillion").toString());
                        cases.setText(cases.getText() + " " + hash.get("cases").toString());


                        System.out.println(""+hash); } };


                //r.addArgument("q", "@codename-one");
                r.setUrl("https://coronavirus-19-api.herokuapp.com/countries/tunisia");
                r.setPost(false);

                InfiniteProgress prog = new InfiniteProgress();
                Dialog dlg = prog.showInfiniteBlocking();
                r.setDisposeOnCompletion(dlg);
                NetworkManager.getInstance().addToQueueAndWait(r);
                r.getResponseData();

            }
        });


        statisticGUI.addComponent(tc);
        statisticGUI.addComponent(dpm);
        statisticGUI.addComponent(active);
        statisticGUI.addComponent(cpm);
        statisticGUI.addComponent(tt);
        statisticGUI.addComponent(td);
        statisticGUI.addComponent(deaths);
        statisticGUI.addComponent(recovered);
        statisticGUI.addComponent(critical);
        statisticGUI.addComponent(tpom);
        statisticGUI.addComponent(cases);
        statisticGUI.addComponent(statButton);


    }
    public Form getStatisicGUI() {
        return statisticGUI;
    }



}

