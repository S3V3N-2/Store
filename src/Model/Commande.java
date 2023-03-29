package Model;

import java.util.*;


public class Commande {

    public Commande() {
    }

    public Date date;


    public Vendeur vendeur;


    public Client client;


    public Vector<LigneCommande> listeLigneCmd = new Vector<LigneCommande>();

    public Commande(Date date, Vendeur vendeur, Client client) {
        this.date = date;
        this.vendeur = vendeur;
        this.client = client;
    }



    public void ajouteLigneCommande(LigneCommande ligneCommande) {
        listeLigneCmd.add(ligneCommande);
    }

    public Commande(Date date, Vendeur vendeur) {
        this.date = date;
        this.vendeur = vendeur;
    }
}