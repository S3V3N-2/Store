package Model;

import java.util.*;


public class LigneStock {


    public LigneStock() {
    }


    public int qte;


    public Stock stock;


    public Article article;


    public LigneStock(int qte, Stock stock, Article article) {
        this.qte = qte;
        this.stock = stock;
        this.article = article;
    }
}