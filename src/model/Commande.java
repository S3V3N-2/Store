package model;

import java.time.LocalDate;
import java.util.*;


public class Commande {

    public Commande() {
    }

    public LocalDate date;


    public Vendeur vendeur;


    public Client client;


    public Vector<LigneCommande> listeLigneCmd = new Vector<LigneCommande>();

    public Commande(LocalDate date, Vendeur vendeur, Client client) {
        this.date = date;
        this.vendeur = vendeur;
        this.client = client;
    }



    public void ajouteLigneCommande(LigneCommande ligneCommande) {
        listeLigneCmd.add(ligneCommande);
    }

    public LigneCommande rechercherLigneCommande(Article art){
        // la fonction recherche une LigneCommande dans le tableau des LigneCommande par rapport à l'article passer en parametre
        for( int i=0; i<listeLigneCmd.size();i++){
            if( listeLigneCmd.get(i).article == art ){
                return listeLigneCmd.get(i);
            }
        }
        return null;
    }

    public void modifierQuantiteLigneCommande( Article art, int quantity ){
        // la fonction recherche la ListeCommande en fonction de l'article
        // puis elle modifie sa quantité
        rechercherLigneCommande(art).qte = quantity;
    }
    public void supprimerLigneCommande(Article art){
        // La fonction parcours toute la listeLigneCmd pour supprimer
        // la LigneCommande correspondante a l'article passé en parametre
        Vector<LigneCommande> newVect = new Vector<LigneCommande>();
        for( int i=0; i<listeLigneCmd.size(); i++){
            if( listeLigneCmd.get(i).article != art ){
                newVect.add( listeLigneCmd.get(i) );
            }
        }
        listeLigneCmd = newVect;
    }
    public float getPrice(){
        // fonction qui somme le prix de toutes les LigneCommande pour avoir le prix total
        float somme = 0;
        for (int i = 0; i<listeLigneCmd.size(); i++) {
            somme = somme+listeLigneCmd.get(i).getPrice();
        }
        return somme;
    }

}