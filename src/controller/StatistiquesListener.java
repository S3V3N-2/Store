package controller;

import model.Article;
import model.Magasin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class StatistiquesListener implements ActionListener {

    Magasin monMagasin;
    JComboBox listeVendeurs;
    JComboBox listeClients;
    JLabel articlePlusAchete;
    JTable tableArticleClient;
    JLabel chiffreAffaire;
    JLabel nombreArtVendue;


    public StatistiquesListener(Magasin monMagasin, JComboBox listeVendeurs, JComboBox listeClients, JLabel articlePlusAchete, JTable tableArticleClient, JLabel chiffreAffaire, JLabel nombreArtVendue) {
        this.monMagasin = monMagasin;
        this.listeVendeurs = listeVendeurs;
        this.listeClients = listeClients;
        this.articlePlusAchete = articlePlusAchete;
        this.tableArticleClient = tableArticleClient;
        this.chiffreAffaire = chiffreAffaire;
        this.nombreArtVendue = nombreArtVendue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == listeClients) {
            if (listeClients.getSelectedItem() == "") {
                return;
            }

            DefaultTableModel model = (DefaultTableModel) tableArticleClient.getModel();
            Vector<Article> listeArticleClient = new Vector<Article>();
            String article = "";
            String nomC = (String) listeClients.getSelectedItem();
            for (int i = 0; i < monMagasin.listeClient.size(); i++) {
                if ((monMagasin.listeClient.get(i).nom + " " + monMagasin.listeClient.get(i).prenom).equals(nomC)) {
                    article = monMagasin.listeClient.get(i).articleLePlusAcheteClient().nom;
                    listeArticleClient = monMagasin.listeClient.get(i).listesArticlesCommandesClient();
                    for (int j = 0; j < listeArticleClient.size(); j++) {
                        Vector<Object> o = new Vector<Object>();
                        o.add(listeArticleClient.get(i).idA);
                        o.add(listeArticleClient.get(i).nom);
                        o.add(listeArticleClient.get(i).prix);
                        o.add(monMagasin.listeClient.get(i).qteArticleCommandeClient(listeArticleClient.get(i).nom));
                        o.add(listeArticleClient.get(i).designation);
                        model.addRow(o);
                    }
                }
            }

            articlePlusAchete.setText(article);


        }

        if (e.getSource() == listeVendeurs) {
            if (listeVendeurs.getSelectedItem() == "") {
                return;
            }
            String chiffreAffair = "";
            String nombreArtVend = "";
            String nomV = (String) listeVendeurs.getSelectedItem();
            for (int i = 0; i < monMagasin.listeVendeur.size(); i++) {
                if ((monMagasin.listeVendeur.get(i).nom + " " + monMagasin.listeVendeur.get(i).prenom).equals(nomV)) {
                    chiffreAffair = Float.toString(monMagasin.listeVendeur.get(i).chiffreAffaireVendeur());
                    nombreArtVend = Integer.toString(monMagasin.listeVendeur.get(i).nbProduitVendu());
                }
            }
            chiffreAffaire.setText(chiffreAffair);
            nombreArtVendue.setText(nombreArtVend);
        }
    }
}