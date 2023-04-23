import Model.*;
import View.Menu;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;


public class Main {
    public static void main(String[] args) {
        Magasin magasin = new Magasin("TECHStore");
        magasin.ajouteStock(new Stock(123,magasin));

        Vector<Article> listeArticles = new Vector<Article>();
        Article pcPortable = new Article(1,600,"Pc Portable","Pc portable de marque HP i7 1To SSD Windows10");
        Article iphone15 = new Article(2,1400,"Iphone 15","La nouvelle pépite Apple est enfin la !");
        Article macBook = new Article(3,900,"Mac Book","L'ordinateur intélligent d'apple !");
        Article tv = new Article(4,200,"TV","Télévision énorme avec une dalle OLED 4K");
        listeArticles.add(pcPortable);         listeArticles.add(iphone15);        listeArticles.add(macBook);        listeArticles.add(pcPortable);

        magasin.listeClient.add(new Client("Jean","Luc","0612345678","12 rue Saint-Germain",magasin));
        magasin.listeClient.add(new Client("Martin","Dubois","0700112233","3 rue de la Bastille",magasin));
        magasin.listeClient.add(new Client("Xavier","Leclerc","0687654321","40 avenue Jardin d'essai",magasin));

        magasin.listeVendeur.add(new Vendeur("Kevin","DeBruyne","0771239402","10 rue Manchester City",magasin));
        magasin.listeVendeur.add(new Vendeur("Ryad","Mahrez","0621326213","26 place Etihad Stadium",magasin));

        magasin.listeStock.get(0).ajouteLigneStock(new LigneStock(30,magasin.listeStock.get(0),pcPortable));
        magasin.listeStock.get(0).ajouteLigneStock(new LigneStock(45,magasin.listeStock.get(0),iphone15));
        magasin.listeStock.get(0).ajouteLigneStock(new LigneStock(10,magasin.listeStock.get(0),macBook));
        magasin.listeStock.get(0).ajouteLigneStock(new LigneStock(70,magasin.listeStock.get(0),tv));


        Menu menu = new Menu(magasin);


    }
}

       

