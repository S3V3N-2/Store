package Model;
import java.util.*;

public class Article {
    public Article() {
    }

    public int id_a;

    public int prix;

    public String Designation;

    public Vector<LigneCommande> listeLigneC = new Vector<LigneCommande>();

    public Vector<LigneStock> listeStock = new Vector<LigneStock>();

    public void ajouteLigneCommande(LigneCommande ligneCommande){
        listeLigneC.add(ligneCommande);
    }

    public void ajouteLigneStock(LigneStock ligneStock){
        listeStock.add(ligneStock);
    }

}