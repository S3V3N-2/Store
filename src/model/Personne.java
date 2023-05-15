package model;


public class Personne {


    public Personne() {
    }

    public String nom;

    public String prenom;

    public String tel;

    public String adr;

    public Personne(String n,String p, String t, String adresse){
        nom = n;
        prenom = p;
        tel = t;
        adr = adresse;
    }

}