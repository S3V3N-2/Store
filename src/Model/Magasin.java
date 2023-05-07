package Model;

import java.util.*;


public class Magasin {



    public String nom;


    public Vector<Client> listeClient = new Vector<Client>();


    public Vector<Vendeur> listeVendeur = new Vector<Vendeur>();


    public Vector<Stock> listeStock = new Vector<Stock>();

    public Magasin(String nom_m) {
        nom = nom_m;
    }

    public void ajouteClient(Client client) {
        listeClient.add(client);
    }

    public void ajouteVendeur(Vendeur vendeur){
        listeVendeur.add(vendeur);
    }

    public void ajouteStock(Stock stock){
        listeStock.add(stock);
    }

    public LigneStock rechercherLigneStock(String nom){
        for( int i=0; i<listeStock.size() ; i++ ){
            for(int j=0; j<listeStock.get(i).listeLigneStock.size();j++ ){
                if( listeStock.get(i).listeLigneStock.get(j).article.nom.equals(nom)) {
                    return listeStock.get(i).listeLigneStock.get(j);
                }
            }
        }
        return null;
    }

    public Client rechercherClient(String nom){
        for( int i=0; i<listeClient.size();i++){
            if( listeClient.get(i).nom.equals(nom)){
                return listeClient.get(i);
            }
        }
        return null;
    }
    public Vendeur rechercherVendeur(String nom){
        for( int i=0; i<listeVendeur.size();i++){
            if( listeVendeur.get(i).nom.equals(nom)){
                return listeVendeur.get(i);
            }
        }
        return null;
    }

    public float chiffreAffaireClient(String nom){
        return rechercherClient(nom).chiffreAffaireClient();
    }
    public float chiffreAffaireVendeur(String nom,String prenom){
        return rechercherVendeur(nom).chiffreAffaireVendeur();
    }
    public float chiffreAffaireTotal() {
        float somme = 0;
        for(int i=0; i<listeClient.size();i++){
            somme += listeClient.get(i).chiffreAffaireClient();
        }
        return somme;
    }

    public Vector<Article> listes_articles_vendus(){
        Vector<Article> all_articles = new Vector<Article>();
        for(int i=0; i<listeClient.size();i++){
            Vector<Article> v = listeClient.get(i).listes_articles_commandes_client();
            //System.out.println(v.size());
            for(int j=0;j<v.size();j++){
                if( !(all_articles.contains(v.get(j))) ) { all_articles.add(v.get(j)); }
            }
        }
        return all_articles;
    }

    public int qte_vendu_article(String nom){
        // calcule la quantité vendu de l'article passé en parametre dans tout le magasin
        int qte = 0;
        for( int i=0; i<listeClient.size();i++){
            qte += listeClient.get(i).qte_article_commande_client(nom);
        }
        return qte;
    }


    public int qte_total_vendue(){
        //total qte vendue dans tout le magasin
        int qte_total = 0;
        for (int i = 0; i<listeClient.size();i++){
            qte_total += listeClient.get(i).qte_total_article_commande_client();
        }
        return qte_total;
    }


    public Article article_le_plus_achete(){
        // l'article le plus acheté dans le magasin
        Vector<Article> vec = this.listes_articles_vendus();
        Article article_max = vec.get(0);
        int nb_max = qte_vendu_article(article_max.nom);
        for(int i=1; i<vec.size();i++){
            if( nb_max < qte_vendu_article(vec.get(i).nom) ){
                article_max = vec.get(i);
                nb_max = qte_vendu_article(vec.get(i).nom);
            }
        }
        return article_max;
    }
}