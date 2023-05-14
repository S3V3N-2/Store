package Controller;

import Model.Client;
import Model.Magasin;
import Model.Vendeur;
import View.GestionVendeurs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GestionVendeursListener implements ActionListener {
    Magasin mon_magasin;
    JTextField[] tabTF;
    JTextArea textArea;
    JTable tableVendeurs;

    public GestionVendeursListener(Magasin m, JTextField[] tab_tf, JTextArea adr_text, JTable tab_donnees) {
        mon_magasin = m;
        tabTF = tab_tf;
        textArea = adr_text;
        tableVendeurs = tab_donnees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nom_vendeur = tabTF[0].getText();
        String prenom_vendeur = tabTF[1].getText();
        String tel_vendeur = tabTF[2].getText();
        String adresse_vendeur = textArea.getText();

        if (((JButton) e.getSource()).getText().equals("Ajouter")) {
            // vérifie si un des 4 champs sont vides
            if (nom_vendeur.equals("") || prenom_vendeur.equals("") || tel_vendeur.equals("") || adresse_vendeur.equals("")) {
                return;
            }
            // recupérer et creer un nouveau vendeur depuis les champs saisis
            Vendeur vendeur = new Vendeur(nom_vendeur,prenom_vendeur,tel_vendeur, adresse_vendeur, mon_magasin);

            //vérifie si le vendeur existe déja dans notre magasin
            for (int i = 0; i < mon_magasin.listeVendeur.size(); i++) {
                if (mon_magasin.listeVendeur.get(i) == vendeur) {
                    return;
                }
            }

            // Ajouter et afficher le vendeur
            mon_magasin.ajouteVendeur(vendeur);

            // Vider les champs
            for (int i = 0; i < 3; i++) {
                tabTF[i].setText("");
            }
            textArea.setText("");

        }
        if (((JButton) e.getSource()).getText().equals("Supprimer")) {
            //Vérifie le champs nom et prenom qui vont servir a supprimer
            if( nom_vendeur.equals("") || prenom_vendeur.equals("") ) { return ; }

            // recherche et suppression du client dont le nom et prenom ont été saisi
            for (int i = 0; i < tableVendeurs.getRowCount(); i++) {
                Object nom_row = tableVendeurs.getValueAt(i, 1);
                Object prenom_row = tableVendeurs.getValueAt(i, 2);
                if ( nom_vendeur.equals( ((String)nom_row) ) && prenom_vendeur.equals( ((String)prenom_row) ) ) {
                    mon_magasin.supprimerVendeur( mon_magasin.rechercherVendeur( nom_vendeur ));
                }
            }

        }
    }
}
