package Model;

import java.util.*;


public class Client extends Personne {


    public Client() {
    }

    public Vector<Commande> liste_cmd = new Vector<Commande>();

    public Magasin magasin;

    public Client(Magasin magasin) {
        this.magasin = magasin;
    }

    public void ajouteCommande(Commande commande){
        liste_cmd.add(commande);
    }
}