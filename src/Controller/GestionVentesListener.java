package Controller;

import Model.LigneStock;
import Model.Magasin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GestionVentesListener implements ActionListener {

    Magasin mon_magasin ;
    JList listeProduits ;
    JSpinner maQte ;
    JTable tableLignesCommandes;

    public GestionVentesListener(Magasin m, JList jl, JSpinner js, JTable tableDonnees) {
        mon_magasin = m;
        listeProduits = jl;
        maQte = js;
        tableLignesCommandes = tableDonnees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) e.getSource()).getText().equals("Ajouter au panier")) {
            // vérifie si un produit et une quantité ont été selectionné :
            if( listeProduits.getSelectedValue()==null || ((int)maQte.getValue())<=0 ){
                return ;
            }

            String nom_p = (String) listeProduits.getSelectedValue() ;
            int qte_p = (int)maQte.getValue();
            LigneStock article_en_stock = mon_magasin.rechercherArticle(nom_p);
            if( article_en_stock.qte < qte_p ) { qte_p = article_en_stock.qte; }
            article_en_stock.qte -= qte_p;

            DefaultTableModel model = (DefaultTableModel) tableLignesCommandes.getModel();
            Vector<Object> o = new Vector<Object>();
            o.add(nom_p);
            o.add(qte_p);
            o.add(article_en_stock.article.prix);
            o.add(article_en_stock.article.prix * qte_p);
            model.addRow(o);
         }
        if (((JButton) e.getSource()).getText().equals("Supprimer du panier")){
            // vérifie si un produit et une quantité a supprimer a bel et bien été sélectionné
            if( listeProduits.getSelectedValue()==null || ((int)maQte.getValue())<=0 ){
                return ;
            }

            String nom_p_supp = (String) listeProduits.getSelectedValue();
            int qte_p_supp = (int) maQte.getValue();

            //parcours le tableau et modifie les valeurs
            for (int i = 0; i < tableLignesCommandes.getRowCount(); i++) {
                Object nom_row = tableLignesCommandes.getValueAt(i, 0);
                Object qte_row = tableLignesCommandes.getValueAt(i, 1);
                if ( nom_p_supp.equals(nom_row) ) {
                    DefaultTableModel model = (DefaultTableModel) tableLignesCommandes.getModel();
                    if( qte_p_supp >= (int)qte_row ){
                        model.removeRow(i);
                        i--;
                        qte_p_supp -= (int)qte_row;
                    }else {
                        tableLignesCommandes.setValueAt(((int) qte_row - qte_p_supp), i, 1);
                        tableLignesCommandes.setValueAt( (float)(((int) tableLignesCommandes.getValueAt(i, 1)) * (float) tableLignesCommandes.getValueAt(i, 2)), i, 3);
                    }
                }
            }

        }

        }

}
