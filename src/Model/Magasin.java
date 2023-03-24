package Model;

import java.util.*;


public class Magasin {


    public Magasin() {
    }


    public String nom;


    public Vector<Client> listeClient = new Vector<Client>();


    public Vector<Vendeur> listeVendeur = new Vector<Vendeur>();


    public Vector<Stock> listeStock = new Vector<Stock>();

    public Magasin(String nom_m) {
        nom = nom_m;
    }

    public void ajouteClient(Client client) {
        listeClient.add(client);
    }

    public void ajouteVendeur(Vendeur vendeur){
        listeVendeur.add(vendeur);
    }

    public void ajouteStock(Stock stock){
        listeStock.add(stock);
    }
}