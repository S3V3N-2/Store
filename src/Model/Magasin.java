package Model;

import java.util.*;


public class Magasin extends Observable {

    public String nom;


    public Vector<Client> listeClient = new Vector<Client>();


    public Vector<Vendeur> listeVendeur = new Vector<Vendeur>();


    public Vector<Stock> listeStock = new Vector<Stock>();

    public Magasin(String nom_m) {
        nom = nom_m;
    }

    public void ajouteClient(Client client) {
        listeClient.add(client);
        this.setChanged();
        this.notifyObservers(client);
    }

    public void supprimerClient(Client client){
        listeClient.removeIf( element -> (element.nom.equals(client.nom) && element.prenom.equals(client.prenom)));
        this.setChanged();
        this.notifyObservers(client);
    }

    public void ajouteVendeur(Vendeur vendeur){
        listeVendeur.add(vendeur);
        this.setChanged();
        this.notifyObservers(vendeur);
    }

    public void supprimerVendeur(Vendeur vendeur){
        listeClient.removeIf( element -> (element.nom.equals(vendeur.nom) && element.prenom.equals(vendeur.prenom)));
        this.setChanged();
        this.notifyObservers(vendeur);
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

    public Vector<Article> listesArticlesVendus(){
        Vector<Article> allArticles = new Vector<Article>();
        for(int i=0; i<listeClient.size();i++){
            Vector<Article> v = listeClient.get(i).listesArticlesCommandesClient();
            for(int j=0;j<v.size();j++){
                if( !(allArticles.contains(v.get(j))) ) { allArticles.add(v.get(j)); }
            }
        }
        return allArticles;
    }

    public int qteVenduArticle(String nom){
        // calcule la quantité vendu de l'article passé en parametre dans tout le magasin
        int qte = 0;
        for( int i=0; i<listeClient.size();i++){
            qte += listeClient.get(i).qteArticleCommandeClient(nom);
        }
        return qte;
    }


    public int qteTotalVendue(){
        //total qte vendue dans tout le magasin
        int qteTotal = 0;
        for (int i = 0; i<listeClient.size();i++){
            qteTotal += listeClient.get(i).qteTotalArticleCommandeClient();
        }
        return qteTotal;
    }


    public Article articleLePlusAchete(){
        // l'article le plus acheté dans le magasin
        Vector<Article> vec = this.listesArticlesVendus();
        Article articleMax = vec.get(0);
        int nbMax = qteVenduArticle(articleMax.nom);
        for(int i=1; i<vec.size();i++){
            if( nbMax < qteVenduArticle(vec.get(i).nom) ){
                articleMax = vec.get(i);
                nbMax = qteVenduArticle(vec.get(i).nom);
            }
        }
        return articleMax;
    }
}