package Model;
import java.util.*;

public class Article {


    public int idA;

    public float prix;

    public String nom;

    public String designation;

    public Article(int idA, int prix, String nom, String designation) {
        this.idA = idA;
        this.prix = prix;
        this.nom = nom;
        this.designation = designation;
    }

    public Vector<LigneCommande> listeLigneC = new Vector<LigneCommande>();

    public Vector<LigneStock> listeStock = new Vector<LigneStock>();

    public void ajouteLigneCommande(LigneCommande ligneCommande){
        listeLigneC.add(ligneCommande);
    }

    public void ajouteLigneStock(LigneStock ligneStock){
        listeStock.add(ligneStock);
    }

}