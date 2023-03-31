package Model;
import java.util.*;

public class Article {


    public int id_a;

    public float prix;

    public String nom;

    public String designation;

    public Article(int id_a, int prix, String nom, String designation) {
        this.id_a = id_a;
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