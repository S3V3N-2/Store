package Model;

import java.util.*;


public class Client extends Personne {


    public Client() {
    }

    public Vector<Commande> liste_cmd = new Vector<Commande>();

    public Magasin magasin;

    public Client(String n,String p, String t, String adresse, Magasin magasin) {
        super(n,p,t,adresse);
        this.magasin = magasin;
    }

    public void ajouteCommande(Commande commande){

        liste_cmd.add(commande);
    }


}