package Controller;



import Model.Client;
import Model.Commande;
import Model.Magasin;
import Model.Stock;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

   Magasin magasin;
   Client client;




    public MenuListener(Magasin m, Client c){
        magasin = m;
        client = c;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton)e.getSource()).getText().equals("Gestion Produits")) {
            GestionProduits gestionProduits = new GestionProduits(magasin.listeStock.get(0));
            gestionProduits.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Gestion Clients")) {
            GestionClients gestionClients = new GestionClients(magasin);
            gestionClients.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Gestion Vendeurs")) {
            GestionVendeurs gestionVendeurs = new GestionVendeurs(magasin);
            gestionVendeurs.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Gestion Ventes")) {
            GestionVentes gestionVentes = new GestionVentes(magasin);
            gestionVentes.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Statistiques")) {
            Statistiques statistiques = new Statistiques(magasin, client);
            statistiques.setVisible(true);
        }
    }
}
