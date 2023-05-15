package controller;

import model.Commande;
import model.LigneCommande;
import model.LigneStock;
import model.Magasin;
import view.ConfirmationAchat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;

public class GestionVentesListener implements ActionListener {

    Magasin monMagasin;
    JList listeProduits ;
    JComboBox listeVendeurs ;
    JComboBox listeClients ;
    JSpinner maQte ;
    JTable tableLignesCommandes;

    public GestionVentesListener(Magasin m, JList jlp, JComboBox jlv, JComboBox jlc, JSpinner js, JTable tableDonnees) {
        monMagasin = m;
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

            String nomP = (String) listeProduits.getSelectedValue() ;
            int qteP = (int)maQte.getValue();
            LigneStock articleEnStock = monMagasin.rechercherLigneStock(nomP);
            if( articleEnStock.qte < qteP ) { qteP = articleEnStock.qte; }
            articleEnStock.qte -= qteP;

            DefaultTableModel model = (DefaultTableModel) tableLignesCommandes.getModel();
            Vector<Object> o = new Vector<Object>();
            o.add(nomP);
            o.add(qteP);
            o.add(articleEnStock.article.prix);
            o.add(articleEnStock.article.prix * qteP);
            model.addRow(o);
         }

        if (((JButton) e.getSource()).getText().equals("Supprimer du panier")){
            // vérifie si un produit et une quantité a supprimer a bel et bien été sélectionné
            if( listeProduits.getSelectedValue()==null || ((int)maQte.getValue())<=0 ){
                return ;
            }

            String nomPSupp = (String) listeProduits.getSelectedValue();
            int qtePSupp = (int) maQte.getValue();
            LigneStock articleEnStock = monMagasin.rechercherLigneStock(nomPSupp);

            //parcours le tableau et modifie les valeurs
            for (int i = 0; i < tableLignesCommandes.getRowCount(); i++) {
                Object nom_row = tableLignesCommandes.getValueAt(i, 0);
                Object qte_row = tableLignesCommandes.getValueAt(i, 1);
                if ( nomPSupp.equals(nom_row) ) {
                    DefaultTableModel model = (DefaultTableModel) tableLignesCommandes.getModel();
                    if( qtePSupp >= (int)qte_row ){
                        model.removeRow(i);
                        i--;
                        qtePSupp -= (int)qte_row;
                        articleEnStock.qte += (int)qte_row;
                    }else {
                        tableLignesCommandes.setValueAt(((int) qte_row - qtePSupp), i, 1);
                        tableLignesCommandes.setValueAt( (float)(((int) tableLignesCommandes.getValueAt(i, 1)) * (float) tableLignesCommandes.getValueAt(i, 2)), i, 3);
                        articleEnStock.qte += qtePSupp;
                    }
                }
            }

        }
        if (((JButton) e.getSource()).getText().equals("Valider le panier")){
            if (  listeVendeurs.getSelectedItem()=="" || listeClients.getSelectedItem()=="" || tableLignesCommandes.getRowCount()==0 ){
                return;
            }

            String nomVendeur = (String)listeVendeurs.getSelectedItem();
            String nomClient = (String)listeClients.getSelectedItem();
            Commande commande = new Commande(LocalDate.now(), monMagasin.rechercherVendeur(nomVendeur), monMagasin.rechercherClient(nomClient));

            for (int i = 0; i < tableLignesCommandes.getRowCount(); i++) {
                if( (int)tableLignesCommandes.getValueAt(i, 1) > 0 ){
                    commande.ajouteLigneCommande( new LigneCommande( (int)tableLignesCommandes.getValueAt(i, 1), monMagasin.rechercherLigneStock( (String)tableLignesCommandes.getValueAt(i, 0) ).article,commande ));
                }
            }
            ConfirmationAchat confirmationAchat = new ConfirmationAchat(monMagasin,commande);
            confirmationAchat.setVisible(true);
        }

        }

}
