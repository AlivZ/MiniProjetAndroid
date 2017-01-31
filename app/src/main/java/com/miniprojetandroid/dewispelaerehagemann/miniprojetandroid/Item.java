package com.miniprojetandroid.dewispelaerehagemann.miniprojetandroid;

public class Item {
    private String ImagePath;
    private String nom;
    private String prenom;

    public Item(String nom, String prenom, String Image) {
        this.ImagePath = Image;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
