/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.*;
import com.mycompany.Service.*;

/**
 *
 * @author Achref
 */
public class SignUp {
   
    Form signup;
    TextField nomMalade;
    TextField prenomMalade;
    TextField ageMalade;
       TextField adresseMalade;
    TextField telephoneMalade;
           TextField mailMalade;
           TextField code;

    Button in;
    

    public SignUp() {
        signup = new Form("Sign Up",BoxLayout.y());
        nomMalade = new TextField("","Username");
        prenomMalade = new TextField("","");
        ageMalade = new TextField("","");
         adresseMalade = new TextField("","");
             mailMalade = new TextField("","");
        telephoneMalade = new TextField("","");
        code = new TextField("","Password");

        in = new Button("Submit");
        
        
        signup.add(nomMalade);
        signup.add(prenomMalade);
        signup.add(ageMalade);
        signup.add(adresseMalade);
         signup.add(telephoneMalade);
        signup.add(mailMalade);
        signup.add(code);
        signup.add(in);
        
        in.addActionListener((e) -> {
            Inscription_Malade ser = new Inscription_Malade();
            Utilisateur_Malade t = new Utilisateur_Malade(nomMalade.getText(), prenomMalade.getText(),
            ageMalade.getText(),adresseMalade.getText(),telephoneMalade.getText(),mailMalade.getText(),code.getText());
          ser.ajouterMalade(t);
            

        });
       /*
        l.addDragFinishedListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
        });*/
    }

    public Form getF() {
        return signup;
    }

    public void setF(Form f) {
        this.signup = f;
    }

    public TextField getTnom() {
        return nomMalade;
    }

    public void setTnom(TextField tnom) {
        this.nomMalade = tnom;
    }

  
}
