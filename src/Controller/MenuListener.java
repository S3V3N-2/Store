package Controller;



import Model.LigneStock;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MenuListener implements ActionListener {




    public MenuListener(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton)e.getSource()).getText().equals("Gestion Produits")) {
            GestionProduits gestionProduits = new GestionProduits(new Vector<LigneStock>());
            gestionProduits.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Gestion Clients")) {
            GestionClients gestionClients = new GestionClients();
            gestionClients.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Gestion Vendeurs")) {
            GestionVendeurs gestionVendeurs = new GestionVendeurs();
            gestionVendeurs.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Gestion Ventes")) {
            GestionVentes gestionVentes = new GestionVentes();
            gestionVentes.setVisible(true);
        }
        if (((JButton)e.getSource()).getText().equals("Statistiques")) {
            Statistiques statistiques = new Statistiques();
            statistiques.setVisible(true);
        }
    }
}
