package Controller;

import Model.Article;
import Model.LigneStock;
import Model.Stock;
import View.JTableObserver;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;



public class GestionProduitsListener implements ActionListener {

    Stock stock;
    JTextField[] tabJTF = new JTextField[4];
    JTextArea designation_jta;
    JTable tableProduits;

    public GestionProduitsListener(Stock s, JTextField[] jtf, JTextArea jta, JTable jt){
        stock = s;
        tabJTF = jtf;
        designation_jta = jta;
        tableProduits = jt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals("Ajouter")) {
            // vérifie si un des champs est vide alors n'execute pas le boutton
            if (tabJTF[0].getText().equals("") || tabJTF[1].getText().equals("") || tabJTF[2].getText().equals("") || tabJTF[3].getText().equals("")) {
                return;
            }

            // récupération des valeurs dans les JTextField et le JTextArea
            int id_p = Integer.parseInt(tabJTF[0].getText());
            String nom_p = tabJTF[1].getText();
            int prix_p = Integer.parseInt(tabJTF[2].getText());
            int qte_p = Integer.parseInt(tabJTF[3].getText());
            String designation_p = designation_jta.getText();

            // vérifie si l'id du produit existe déja dans notre stock : si OUI n'éxecute pas le boutton
            for (int i = 0; i < stock.listeLigneStock.size(); i++) {
                if (stock.listeLigneStock.get(i).article.id_a == id_p) {
                    return;
                }
            }

            // Ajout de la ligneStock dans notre Stock
            stock.ajouteLigneStock(new LigneStock(qte_p, stock, new Article(id_p, prix_p, nom_p, designation_p)));

            // Vider les champs
            for (int i = 0; i < 4; i++) {
                tabJTF[i].setText("");
            }
            designation_jta.setText("");
        }
        if (((JButton) e.getSource()).getText().equals("Supprimer")) {
            // ce boutton utilisera uniquement le champs id produit, il supprimera le produit dont l'id est introduit

            // vérifie le champs id si il est vide si il est vide alors on supprime aucun produit
            if (tabJTF[0].getText().equals("")) {
                return;
            }
            // parcours le JTable a la recherche de la ligne de l'id correspendant a l'id inseret dans le champs id
            // et supprime cette ligne
            for (int i = 0; i < tableProduits.getRowCount(); i++) {
                Object id_row = tableProduits.getValueAt(i, 0);
                if (((int) id_row) == Integer.parseInt(tabJTF[0].getText())) {
                    stock.supprimerLigneStock(stock.rechercherIdLigneStock( (int) id_row) );
                }
            }

        }
    }
}