package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Utilisateur_Malade;
import com.mycompany.Service.Inscription_Malade;

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
        nomMalade = new TextField("","LastName");
        prenomMalade = new TextField("","FirstName");
        ageMalade = new TextField("","Birth Date ");
        adresseMalade = new TextField("","Adresse");
        mailMalade = new TextField("","Email");
        telephoneMalade = new TextField("","Phone");
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


        signup.getToolbar().addCommandToLeftSideMenu("Back",null,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Login a = new Login();
                a.getLogin().show();
            }
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