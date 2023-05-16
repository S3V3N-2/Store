import model.*;
import view.Menu;


import java.time.LocalDate;
import java.util.Vector;


public class Main {
    public static void main(String[] args) {
        Magasin magasin = new Magasin("TECHStore");
        magasin.ajouteStock(new Stock(123,magasin));

        Vector<Article> listeArticles = new Vector<Article>();
        Article pcPortable = new Article(1,600,"Pc Portable","Pc portable de marque HP i7 1To SSD Windows10");
        Article iphone15 = new Article(2,1400,"iPhone 15","La nouvelle pépite Apple est enfin la !");
        Article macBook = new Article(3,900,"MacBook","L'ordinateur intélligent d'apple !");
        Article tv = new Article(4,200,"TV","Télévision énorme avec une dalle OLED 4K");
        listeArticles.add(pcPortable);         listeArticles.add(iphone15);        listeArticles.add(macBook);        listeArticles.add(pcPortable);

        magasin.ajouteClient(new Client("Jean","Luc","0612345678","12 rue Saint-Germain",magasin));
        magasin.ajouteClient(new Client("Martin","Dubois","0700112233","3 rue de la Bastille",magasin));
        magasin.ajouteClient(new Client("Xavier","Leclerc","0687654321","40 avenue Jardin d'essai",magasin));



        magasin.ajouteVendeur(new Vendeur("Da costa","Pedro","0771239402","10 rue Manchester City",magasin));
        magasin.ajouteVendeur(new Vendeur("Sanchez","Joao","0621326213","26 place Etihad Stadium",magasin));

        Stock stock = new Stock(1,magasin);
        magasin.ajouteStock(stock);
        stock.listeLigneStock.add(new LigneStock(30,stock,pcPortable));
        stock.listeLigneStock.add(new LigneStock(45,stock,iphone15));
        magasin.listeStock.get(0).ajouteLigneStock(new LigneStock(30,stock,pcPortable));
        magasin.listeStock.get(0).ajouteLigneStock(new LigneStock(45,stock,iphone15));
        magasin.listeStock.get(0).ajouteLigneStock(new LigneStock(10,stock,macBook));
        magasin.listeStock.get(0).ajouteLigneStock(new LigneStock(70,stock,tv));

        Vendeur v = new Vendeur("Di Meo","Eros","0785801327","19 place d'Italie",magasin);
        Client c = new Client("Persechini","Gianni","0785834327","19 Saint-Lazard",magasin);

        magasin.ajouteClient(c);
        magasin.ajouteVendeur(v);

        Commande commande = new Commande(LocalDate.now(),v,c);
        v.ajouteCommande(commande);
        c.ajouteCommande(commande);
        LigneCommande ligneCommande = new LigneCommande(2,iphone15,commande);
        commande.ajouteLigneCommande(ligneCommande);

        Menu menu = new Menu(magasin);


    }
}

       

