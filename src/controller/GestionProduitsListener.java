package controller;

import model.Article;
import model.LigneStock;
import model.Stock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GestionProduitsListener implements ActionListener {

    Stock stock;
    JTextField[] tabJTF;
    JTextArea designationJta;
    JTable tableProduits;

    public GestionProduitsListener(Stock s, JTextField[] jtf, JTextArea jta, JTable jt){
        stock = s;
        tabJTF = jtf;
        designationJta = jta;
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
            int idP = Integer.parseInt(tabJTF[0].getText());
            String nomP = tabJTF[1].getText();
            int prixP = Integer.parseInt(tabJTF[2].getText());
            int qteP = Integer.parseInt(tabJTF[3].getText());
            String designationP = designationJta.getText();

            // vérifie si l'id du produit existe déja dans notre stock : si OUI n'éxecute pas le boutton
            for (int i = 0; i < stock.listeLigneStock.size(); i++) {
                if (stock.listeLigneStock.get(i).article.idA == idP) {
                    return;
                }
            }

            // Ajout de la ligneStock dans notre Stock
            stock.ajouteLigneStock(new LigneStock(qteP, stock, new Article(idP, prixP, nomP, designationP)));


            // Vider les champs
            for (int i = 0; i < 4; i++) {
                tabJTF[i].setText("");
            }
            designationJta.setText("");
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
