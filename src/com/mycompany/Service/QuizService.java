package com.mycompany.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.eclipsesource.json.JsonObject;
import com.mycompany.Entite.Quiz;
import com.mycompany.Entite.QuizAnswer;
import javafx.beans.binding.ObjectExpression;
import sun.nio.ch.Net;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class QuizService {

    private static ArrayList<Quiz> quizzes = new ArrayList<>();


    public static ArrayList<Quiz> getQuizs() {
        JSONParser parser = new JSONParser();
        ConnectionRequest connection = new ConnectionRequest();
        String url = "http://127.0.0.1:80/codenameone";
        connection.setUrl(url);
        connection.setPost(false);
        connection.addResponseListener( (e)-> {
            try {
                Map data = parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(connection.getResponseData())));
                ArrayList result =(ArrayList) data.get("root");
                quizzes = getQuizzesFromList(result);
            }catch (IOException ex){
                ex.printStackTrace();
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(connection);
        return quizzes;
    }

    public static ArrayList<Quiz> getQuizzesFromList(ArrayList<HashMap<String,Object>> arrayList) {
        ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
        for (HashMap<String,Object> hashMap: arrayList) {
            Quiz quiz = new Quiz(
                    (Double) hashMap.get("id"),
                    (String) hashMap.get("title"),
                    (String) hashMap.get("question"),
                    (Double) hashMap.get("points"),
                    getQuizAnswersFromHashMapList((ArrayList<HashMap<String,Object>>) hashMap.get("answers"))

            );
            quizzes.add(quiz);
        }
        return quizzes;
    }

    public static ArrayList<QuizAnswer> getQuizAnswersFromHashMapList(ArrayList<HashMap<String,Object>> hashMapList) {
        ArrayList<QuizAnswer> quizAnswers = new ArrayList<>();
        for (HashMap<String,Object> hashMap: hashMapList) {
            QuizAnswer quizAnswer = new QuizAnswer(
                    (Double) hashMap.get("id"),
                    (String) hashMap.get("content"),
                    (Double) hashMap.get("points")
            );
            quizAnswers.add(quizAnswer);
        }
        return quizAnswers;
    }
}
