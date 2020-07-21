package com.mycompany.Entite;



public class user {
    private String nom;
    private String img;
    
    public user ( String nom , String img)
    {this.nom= nom;
    this.img= img ; 
    }

    
     public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

   
    
    
    
}
