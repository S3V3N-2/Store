package Model;

import java.util.*;


public class Stock {


    public Stock() {
    }


    public int id_S;


    public Vector<LigneStock> listeStock = new Vector<LigneStock>();



    public Magasin magasin;


    public Stock(int ids, Magasin m) {
        id_S = ids;
        this.magasin = m;
    }

    public void ajouteLigneStock(LigneStock ligneStock) {
        listeStock.add(ligneStock);
    }


}