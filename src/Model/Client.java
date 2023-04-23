package Model;

import java.util.*;


public class Client extends Personne {


    public Client() {
    }

    public Vector<Commande> liste_cmd = new Vector<Commande>();

    public static int nb_clients = 0 ;

    public int id_c ;

    public Magasin magasin;

    public Client(String n,String p, String t, String adresse, Magasin magasin) {
        super(n,p,t,adresse);
        id_c = ++nb_clients;
        this.magasin = magasin;
    }

    public void ajouteCommande(Commande commande){
        liste_cmd.add(commande);
    }

    public float chiffreAffaireClient(){
        float somme = 0;
        for(int i=0 ; i<liste_cmd.size();i++){
            somme += liste_cmd.get(i).getPrice();
        }
        return somme;
    }

    public int qte_article_commande_client(String nom){
        // calcule la quantié de l'article (dont le nom est passé en parametre) acheté par le client
        int nb=0;
        for(int i=0;i<liste_cmd.size();i++){
            for(int j=0;j<liste_cmd.get(i).listeLigneCmd.size();j++){
                if( liste_cmd.get(i).listeLigneCmd.get(j).article.nom.equals(nom)) {
                    nb += liste_cmd.get(i).listeLigneCmd.get(j).qte;
                }
            }
        }
        return nb;
    }

    public Vector<Article> listes_articles_commandes_client(){
        // retourne une liste contenant tout les articles commandé par le client
        Vector<Article> newVec = new Vector<Article>();
        for(int i=0;i<liste_cmd.size();i++){
            for(int j=0;j<liste_cmd.get(i).listeLigneCmd.size();j++){
                if( !(newVec.contains(liste_cmd.get(i).listeLigneCmd.get(j).article)) ) {
                    newVec.add(liste_cmd.get(i).listeLigneCmd.get(j).article);
                }
            }
        }
        return newVec;
    }

    public Article article_le_plus_achete_client(){
        // retourne l'article le plus acheté du client
        Vector<Article> vec = listes_articles_commandes_client();
        Article article_max = vec.get(0);
        int nb_max = qte_article_commande_client(article_max.nom);
        for(int i=1; i<vec.size();i++){
            if( nb_max < qte_article_commande_client(vec.get(i).nom) ){
                article_max = vec.get(i);
                nb_max = qte_article_commande_client(vec.get(i).nom);
            }
        }
        return article_max;
    }

}