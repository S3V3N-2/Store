package model;

import java.util.*;


public class Client extends Personne {


    public Client() {
    }

    public Vector<Commande> listeCmd = new Vector<Commande>();

    public static int nbClients = 0 ;

    public int idC;

    public Magasin magasin;

    public Client(String n,String p, String t, String adresse, Magasin magasin) {
        super(n,p,t,adresse);
        idC = ++nbClients;
        this.magasin = magasin;
    }

    public void ajouteCommande(Commande commande){
        listeCmd.add(commande);
    }

    public float chiffreAffaireClient(){
        float somme = 0;
        for(int i = 0; i< listeCmd.size(); i++){
            somme += listeCmd.get(i).getPrice();
        }
        return somme;
    }

    public int qteArticleCommandeClient(String nom){
        // calcule la quantié de l'article (dont le nom est passé en parametre) acheté par le client
        int nb=0;
        for(int i = 0; i< listeCmd.size(); i++){
            for(int j = 0; j< listeCmd.get(i).listeLigneCmd.size(); j++){
                if( listeCmd.get(i).listeLigneCmd.get(j).article.nom.equals(nom)) {
                    nb += listeCmd.get(i).listeLigneCmd.get(j).qte;
                }
            }
        }
        return nb;
    }

    //total qte vendue dans le magasin
    public int qteTotalArticleCommandeClient(){
        int nbTotal = 0;
        for(int i = 0; i< listeCmd.size(); i++){
            for (int j = 0; j< listeCmd.get(i).listeLigneCmd.size(); j++) {
                nbTotal += listeCmd.get(i).listeLigneCmd.get(j).qte;
            }
        }
        return nbTotal;
    }

    public Vector<Article> listesArticlesCommandesClient(){
        //retourne une liste contenant tout les articles commandé par le client
        Vector<Article> newVec = new Vector<Article>();
        for(int i = 0; i< listeCmd.size(); i++){
            for(int j = 0; j< listeCmd.get(i).listeLigneCmd.size(); j++){
                if( !(newVec.contains(listeCmd.get(i).listeLigneCmd.get(j).article)) ) {
                    newVec.add(listeCmd.get(i).listeLigneCmd.get(j).article);
                }
            }
        }
        return newVec;
    }

    public Article articleLePlusAcheteClient(){
        //retourne l'article le plus acheté du client
        Vector<Article> vec = listesArticlesCommandesClient();
        Article articleMax = vec.get(0);
        int nb_max = qteArticleCommandeClient(articleMax.nom);
        for(int i=1; i<vec.size();i++){
            if( nb_max < qteArticleCommandeClient(vec.get(i).nom) ){
                articleMax = vec.get(i);
                nb_max = qteArticleCommandeClient(vec.get(i).nom);
            }
        }
        return articleMax;
    }

}