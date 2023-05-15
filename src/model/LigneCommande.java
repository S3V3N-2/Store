package model;

public class LigneCommande {


    public LigneCommande() {
    }

    public int qte;


    public Article article;


     public Commande commande;

     public LigneCommande(int qte, Article article, Commande commande) {
         this.qte = qte;
         this.article = article;
         this.commande = commande;
     }

     public float getPrice(){
         return qte* article.prix;
     }
}