package controller;

import model.Magasin;
import model.Vendeur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionVendeursListener implements ActionListener {
    Magasin monMagasin;
    JTextField[] tabTF;
    JTextArea textArea;
    JTable tableVendeurs;

    public GestionVendeursListener(Magasin m, JTextField[] tab_tf, JTextArea adr_text, JTable tab_donnees) {
        monMagasin = m;
        tabTF = tab_tf;
        textArea = adr_text;
        tableVendeurs = tab_donnees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nomVendeur = tabTF[0].getText();
        String prenomVendeur = tabTF[1].getText();
        String telVendeur = tabTF[2].getText();
        String adresseVendeur = textArea.getText();

        if (((JButton) e.getSource()).getText().equals("Ajouter")) {
            // vérifie si un des 4 champs sont vides
            if (nomVendeur.equals("") || prenomVendeur.equals("") || telVendeur.equals("") || adresseVendeur.equals("")) {
                return;
            }
            // recupérer et creer un nouveau vendeur depuis les champs saisis
            Vendeur vendeur = new Vendeur(nomVendeur,prenomVendeur,telVendeur, adresseVendeur, monMagasin);

            //vérifie si le vendeur existe déja dans notre magasin
            for (int i = 0; i < monMagasin.listeVendeur.size(); i++) {
                if (monMagasin.listeVendeur.get(i) == vendeur) {
                    return;
                }
            }

            // Ajouter et afficher le vendeur
            monMagasin.ajouteVendeur(vendeur);

            // Vider les champs
            for (int i = 0; i < 3; i++) {
                tabTF[i].setText("");
            }
            textArea.setText("");

        }
        if (((JButton) e.getSource()).getText().equals("Supprimer")) {
            //Vérifie le champs nom et prenom qui vont servir a supprimer
            if( nomVendeur.equals("") || prenomVendeur.equals("") ) { return ; }

            // recherche et suppression du client dont le nom et prenom ont été saisi
            for (int i = 0; i < tableVendeurs.getRowCount(); i++) {
                Object nom_row = tableVendeurs.getValueAt(i, 1);
                Object prenom_row = tableVendeurs.getValueAt(i, 2);
                if ( nomVendeur.equals( ((String)nom_row) ) && prenomVendeur.equals( ((String)prenom_row) ) ) {
                    monMagasin.supprimerVendeur( monMagasin.rechercherVendeur( nomVendeur ));
                }
            }

        }
    }
}
