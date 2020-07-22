package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class WorldStatics {

    private Form statisticGUI,parent;

    private Label deaths =  new Label("Deaths: ");
    private Label recovered = new Label("Recovered: ");

    private Label cases  = new Label("Cases: ");

    private Container container = new Container(BoxLayout.y());




    public WorldStatics (Form parent) {
        this.parent = parent;
        statisticGUI = new Form("world statistics", BorderLayout.center());
        statisticGUI.getToolbar().addCommandToLeftBar("back",null,(ev)->{
            parent.showBack();
        });

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

                deaths.setText(deaths.getText() + " " + hash.get("deaths").toString());
                recovered.setText(recovered.getText() + " " + hash.get("recovered").toString());

                cases.setText(cases.getText() + " " + hash.get("cases").toString());


                System.out.println(""+hash); } };


        //r.addArgument("q", "@codename-one");
        r.setUrl("https://coronavirus-19-api.herokuapp.com/all");
        r.setPost(false);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInfiniteBlocking();
        r.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(r);
        r.getResponseData();

        /* Init onClick buttons  */


        // init First Container







        container.addComponent(deaths);
        container.addComponent(recovered);
        container.addComponent(cases);
        /*
        statisticGUI.addComponent(deaths);
        statisticGUI.addComponent(recovered);
        statisticGUI.addComponent(cases);
    */
        statisticGUI.addComponent(BorderLayout.CENTER,container);

    }
    public Form getStatisicGUI() {
        return statisticGUI;
    }

}

