package Controller;

import Model.Commande;
import Model.LigneCommande;
import Model.LigneStock;
import Model.Magasin;
import View.ConfirmationAchat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;

public class GestionVentesListener implements ActionListener {

    Magasin mon_magasin ;
    JList listeProduits ;
    JComboBox listeVendeurs ;
    JComboBox listeClients ;
    JSpinner maQte ;
    JTable tableLignesCommandes;

    public GestionVentesListener(Magasin m, JList jlp, JComboBox jlv, JComboBox jlc, JSpinner js, JTable tableDonnees) {
        mon_magasin = m;
        listeProduits = jlp;
        listeVendeurs = jlv;
        listeClients = jlc ;
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
            LigneStock article_en_stock = mon_magasin.rechercherLigneStock(nom_p);
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
            LigneStock article_en_stock = mon_magasin.rechercherLigneStock(nom_p_supp);

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
                        article_en_stock.qte += (int)qte_row;
                    }else {
                        tableLignesCommandes.setValueAt(((int) qte_row - qte_p_supp), i, 1);
                        tableLignesCommandes.setValueAt( (float)(((int) tableLignesCommandes.getValueAt(i, 1)) * (float) tableLignesCommandes.getValueAt(i, 2)), i, 3);
                        article_en_stock.qte += qte_p_supp;
                    }
                }
            }

        }
        if (((JButton) e.getSource()).getText().equals("Valider le panier")){
            if (  listeVendeurs.getSelectedItem()=="" || listeClients.getSelectedItem()=="" || tableLignesCommandes.getRowCount()==0 ){
                return;
            }

            String nom_vendeur = (String)listeVendeurs.getSelectedItem();
            String nom_client = (String)listeClients.getSelectedItem();
            Commande commande = new Commande(LocalDate.now(),mon_magasin.rechercherVendeur(nom_vendeur),mon_magasin.rechercherClient(nom_client));

            for (int i = 0; i < tableLignesCommandes.getRowCount(); i++) {
                if( (int)tableLignesCommandes.getValueAt(i, 1) > 0 ){
                    commande.ajouteLigneCommande( new LigneCommande( (int)tableLignesCommandes.getValueAt(i, 1),mon_magasin.rechercherLigneStock( (String)tableLignesCommandes.getValueAt(i, 0) ).article,commande ));
                }
            }
            ConfirmationAchat confirmationAchat = new ConfirmationAchat(mon_magasin,commande);
            confirmationAchat.setVisible(true);
        }

        }

}
