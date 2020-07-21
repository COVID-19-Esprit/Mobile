/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

//import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;


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
        
        in.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent evt) {
           /*     
                ConnectionRequest con = new ConnectionRequest(); 
                 String email = user.getText();
                 String pass = password.getText();
                     if(email.isEmpty() || pass.isEmpty()) {
                         System.out.println("empty");
                     } 
                      else 
        { String sql1 = "SELECT * FROM admin Where login = ? and password = ?";
          try {
             //  Connection con = null;
 
             PreparedStatement preparedStatement = null;
              ResultSet resultSet = null;
                
            //    preparedStatement = con.prepareStatement(sql1);
                preparedStatement.setString(1,email);
                preparedStatement.setString(2,pass);
                resultSet = preparedStatement.executeQuery();
             
                 
                  if (!resultSet.next()) {
                      System.out.println("Enter Correct Email/Password");
                
                } 
             
                else {
                 
                      System.out.println("Login Successful..Redirecting");
                    
                } } 
          catch (SQLException ex) {
                System.err.println(ex.getMessage());
             
            } }
               */
                     
                    }} );
                    
       //*************************************************** 
        
     
              
     //********************************************************                
        up.addActionListener((e)->{
        SignUp b=new SignUp();
        b.getF().show();
        });
        
//           login.getToolbar().addCommandToLeftSideMenu("Back",null,new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent evt) {
//                      HomePage a = new HomePage();
//                        a.getF().showBack();
//                     }
//                });
        
        
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
