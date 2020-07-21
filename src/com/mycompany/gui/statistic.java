package com.mycompany.gui;


import com.codename1.io.URL;
import com.codename1.io.URL.HttpURLConnection;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import java.io.IOException;
import java.io.*;
import java.net.URISyntaxException;




/**
 *
 * @author Flexos
 */


public class statistic {





    Form statistic;
    Label tcases;
    Label tdeath;
    Label trecovered;
    private static HttpURLConnection conn;

    public statistic() throws IOException{

        try {
            statistic = new Form("statstic");
            tcases = new Label("","nom");
            tdeath = new Label("","nom");
            trecovered = new Label("","nom");

            statistic.add(tcases);
            statistic.add(tdeath);
            statistic.add(trecovered);

            URL url = new URL ("https://coronavirus-19-api.herokuapp.com/countries/tunisia");
            conn = (HttpURLConnection) url.openConnection();

            conn.setConnectTimeout(8000);
            conn.setReadTimeout(5000);

            String res = conn.getInputStream().toString();

            System.out.println(res);
            String inputLine;
            StringBuilder response = new StringBuilder();

            //System.out.println(in.toString());
        } catch (URISyntaxException ex) {
            System.out.println(ex.getMessage());
        }


    }





    public Form getstatistic() {
        return statistic;
    }

    public void setstatistic(Form statistic) {
        this.statistic = statistic;
    }

    public Label getTcases() {
        return tcases;
    }


}

