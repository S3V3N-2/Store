package Model;

import java.util.*;


public class Vendeur extends Personne {


    public Vendeur() {
    }

    public Vector<Commande> listeCommande = new Vector<Commande>();



    public Magasin magasin;

    public Vendeur(String n,String p, String t, String adresse,Magasin m) {
        super(n,p,t,adresse);
        magasin = m;
    }

    public void ajouteCommande(Commande commande) {

        listeCommande.add(commande);
    }

}