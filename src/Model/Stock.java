package Model;

import java.util.*;


public class Stock {



    public int id_S;


    public Vector<LigneStock> listeLigneStock = new Vector<LigneStock>();



    public Magasin magasin;


    public Stock(int ids, Magasin m) {
        id_S = ids;
        this.magasin = m;
    }

    public void afficherLigneStock(){
        for(int i=0; i<listeLigneStock.size();i++){
            System.out.println("Nom de l'article = "+listeLigneStock.get(i).article.designation+", sa quantité = "+listeLigneStock.get(i).qte);
        }
    }

    public void ajouteLigneStock(LigneStock ligneStock) {

        listeLigneStock.add(ligneStock);
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