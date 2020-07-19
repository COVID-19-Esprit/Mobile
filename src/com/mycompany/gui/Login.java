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

/**
 *
 * @author Achref
 */
public class Login {
    
 Form login;
    TextField user;
    TextField password;
    Button in,up;
    Label l;

    public Login() {
        login = new Form("Login",BoxLayout.y());
        user = new TextField("","Username");
        password = new TextField("","Password");
        in = new Button("SignIn");
        l=new Label("Forget Password?");
        up=new Button("SignUp");
        login.add(user);
        login.add(password);
        login.add(in);
        login.add(l);
        login.add(up);
        
       /* btnajout.addActionListener((e) -> {
            ServiceTask ser = new ServiceTask();
            Task t = new Task(0, tnom.getText(), tetat.getText());
            ser.ajoutTask(t);
            

        });*/
       
        up.addActionListener((e)->{
        SignUp b=new SignUp();
        b.getF().show();
        });
    }

    public Form getLogin() {
        return login;
    }

    public void setLogin(Form login) {
        this.login = login;
    }

   

    public TextField getTnom() {
        return user;
    }

    public void setTnom(TextField tnom) {
        this.user = tnom;
    }

}
