/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.events.ActionListener;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 *
 * @author Achref
 */
public class TestAchref {
        Button a;
   Form TestAchref;
        public  TestAchref (){
           a = new Button("SignIn");
           
            a.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {
//               ConnectionRequest r = new ConnectionRequest(){
//                      String s;
//
//            @Override
//           protected void postResponse() {  }
//
//        @Override
//        protected void readResponse(InputStream input) throws IOException {
//            JSONParser p = new JSONParser();
//      //     s = p.parse(new InputStreamReader(input)).toString();
//           
//            System.out.println(""+s);
//        } };
//               
//               
//    r.addArgument("q", "@codename-one");
//    r.setUrl("https://coronavirus.politologue.com/data/coronavirus/coronacsv.aspx?format=json");
//    r.setPost(false);
//    
//    InfiniteProgress prog = new InfiniteProgress();
//    Dialog dlg = prog.showInfiniteBlocking();
//    r.setDisposeOnCompletion(dlg);
//    NetworkManager.getInstance().addToQueueAndWait(r);
//    r.getResponseData();
//                 
//    



               }
           });
            
        }

    public Form getTestAchref() {
        return TestAchref;
    }

    public void setTestAchref(Form TestAchref) {
        this.TestAchref = TestAchref;
    }
}
        
        
        

        
       
        
        
         
           
        
        
        
        
        
        
        
        
        
        
        




