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

    public float chiffreAffaireVendeur(){
        float somme = 0;
        for(int i=0 ; i<listeCommande.size();i++){
            somme += listeCommande.get(i).getPrice();
        }
        return somme;
    }

    public int nbProduitVendu(){
        int nb = 0;
        for(int i=0; i<listeCommande.size();i++){
            nb += listeCommande.get(i).listeLigneCmd.size();
        }
        return nb;
    }

}