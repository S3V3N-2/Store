package Model;

import java.util.*;


public class Magasin {



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

    public Article rechercherArticle(String nom){
        for( int i=0; i<listeStock.size() ; i++ ){
            for(int j=0; j<listeStock.get(i).listeLigneStock.size();j++ ){
                if( listeStock.get(i).listeLigneStock.get(j).article.nom == nom ) {
                    return listeStock.get(i).listeLigneStock.get(j).article;
                }
            }
        }
        return null;
    }

    public Client rechercherClient(String nom){
        for( int i=0; i<listeClient.size();i++){
            if( listeClient.get(i).nom == nom ){
                return listeClient.get(i);
            }
        }
        return null;
    }
    public Vendeur rechercherVendeur(String nom){
        for( int i=0; i<listeClient.size();i++){
            if( listeClient.get(i).nom == nom ){
                return listeVendeur.get(i);
            }
        }
        return null;
    }
}