/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.user;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Achref
 */
public class ChoixUtilisateur {
       Form ChoixUtilisateur;
       
         public ChoixUtilisateur() {
          Form hi = new Form("Etudiant", BoxLayout.y());
        user Admin = new user("Admin","/admin.jpg");
         user Patient = new user("Patient","/patient.png");
         user Volontary = new user("Volontary","/volontary.png");
         
         List <user> E = new ArrayList();
         E.add(Admin);
         E.add(Patient);
         E.add(Volontary);
         
           for (user t : E)
         {        Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                      
            try {
                  // Label l = new Label (t.getNom());
                   Container cnt = new Container(BoxLayout.y());
                   cnt.add(new Label(t.getNom()));
                   
                Image i = Image.createImage(t.getImg());
                ImageViewer iv = new ImageViewer(i);

             
                iv.addPointerReleasedListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Form hi2 =new Form (t.getNom(),BoxLayout.y());
                         Login a = new Login();
                                a.getLogin().show();
//                           
//                            hi2.getToolbar().addCommandToOverflowMenu("retour", null, new ActionListener() {
//                                @Override
//                                public void actionPerformed(ActionEvent evt) {
//                                     hi.show();
//                                }
//                            });
}
                });
                
              c1.add(cnt).add(iv);
                  hi.add(c1);    
            } catch (IOException ex) {
   System.out.println(ex.getMessage());
            }}
           hi.show();
    }
         
         
         
         
         public Form getChoixUtilisateur() {
        return ChoixUtilisateur;
    }

    public void setChoixUtilisateur(Form ChoixUtilisateur) {
        this.ChoixUtilisateur = ChoixUtilisateur;
    }
         
         
         
         
         
         }

