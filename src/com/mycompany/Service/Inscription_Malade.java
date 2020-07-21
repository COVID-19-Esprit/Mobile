/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Task;
import com.mycompany.Entite.Utilisateur_Malade;



/**
 *
 * @author Achref
 */
public class Inscription_Malade {
    
     
     public void ajouterMalade(Utilisateur_Malade m)
    { ConnectionRequest con = new ConnectionRequest(); //crrer connection request equiavlent dans java statement 
    
    
    String Url="http://localhost/covid_database/addMalade.php?" + "nomMalade=" + m.getNomMalade()+
             "&prenomMalade=" + m.getPrenomMalade()+ "&ageMalade=" + m.getAgeMalade()+ 
             "&adresseMalade=" + m.getAdresseMalade()+ "&telephoneMalade=" + 
             m.getTelephoneMalade()+ "&mailMalade=" + m.getMailMalade()+ "&code=" +
             m.getCode();// création de l'URL
     
     
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.setPost(false);
      con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
     
   

}
