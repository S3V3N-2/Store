package Model;

import java.util.*;


public class Stock extends Observable  {



    public int id_S;


    public Vector<LigneStock> listeLigneStock = new Vector<LigneStock>();



    public Magasin magasin;


    public Stock(int ids, Magasin m) {
        id_S = ids;
        this.magasin = m;
    }

    public void ajouteLigneStock(LigneStock ligneStock) {
        listeLigneStock.add(ligneStock);
        this.setChanged();
        this.notifyObservers(ligneStock);
    }

    public void supprimerLigneStock(LigneStock ligneStock) {
        listeLigneStock.removeIf(element -> element.article.id_a == ligneStock.article.id_a);
        this.setChanged();
        this.notifyObservers(ligneStock);
    }

    public LigneStock rechercherIdLigneStock(int id_ls){
        for( int i=0; i<listeLigneStock.size();i++){
            if( listeLigneStock.get(i).article.id_a == id_ls ){
                return listeLigneStock.get(i);
            }
        }
        return null;
    }

    public LigneStock rechercherLigneStock(Article art) {
        // recherche un article
        for( int i=0; i<listeLigneStock.size();i++){
            if( listeLigneStock.get(i).article == art ){
                return listeLigneStock.get(i);
            }
        }
        return null;
    }

    public void modifyQuantityStock(Article art, int quantity){
        rechercherLigneStock(art).qte = quantity;
    }


}