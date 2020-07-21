/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author Rihab
 */
public class Information {
    
    private int id;
    private String titre;
    private String content;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Information() {
    }

    public Information(int id, String titre, String content, String img) {
        this.id = id;
        this.titre = titre;
        this.content = content;
        this.img = img;
    }

    public Information(int id, String titre, String content) {
        this.id = id;
        this.titre = titre;
        this.content = content;
    }

    public Information(String titre, String img) {
        this.titre = titre;
        this.img = img;
    }
    
    @Override
    public String toString() {
        return "Information{" + "id=" + id + ", titre=" + titre + ", content=" + content + ", img=" + img + '}';
    }
    
    
}
