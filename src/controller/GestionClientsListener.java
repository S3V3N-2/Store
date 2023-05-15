package controller;

import model.Client;
import model.Magasin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionClientsListener implements ActionListener {

    Magasin monMagasin;
    JTextField[] tabTF;
    JTextArea textArea;
    JTable tableClients;

    public GestionClientsListener(Magasin m, JTextField[] tab_tf, JTextArea adr_text, JTable tab_donnees) {
        monMagasin = m;
        tabTF = tab_tf;
        textArea = adr_text;
        tableClients = tab_donnees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nomClient = tabTF[0].getText();
        String prenomClient = tabTF[1].getText();
        String telClient = tabTF[2].getText();
        String adresseClient = textArea.getText();

        if (((JButton) e.getSource()).getText().equals("Ajouter")) {
            // vérifie si un des 4 champs sont vides
            if (nomClient.equals("") || prenomClient.equals("") || telClient.equals("") || adresseClient.equals("")) {
                return;
            }
            // recupérer et creer un nouveau client depuis les champs saisis
            Client client = new Client(nomClient, prenomClient, telClient, adresseClient, monMagasin);

            //vérifie si le client existe déja dans notre magasin
            for (int i = 0; i < monMagasin.listeClient.size(); i++) {
                if (monMagasin.listeClient.get(i) == client) {
                    return;
                }
            }

            // Ajouter  client
            monMagasin.ajouteClient(client);

            // Vider les champs
            for (int i = 0; i < 3; i++) {
                tabTF[i].setText("");
            }
            textArea.setText("");

        }
        if (((JButton) e.getSource()).getText().equals("Supprimer")) {
            //Vérifie le champs nom et prenom qui vont servir a supprimer
            if( nomClient.equals("") || prenomClient.equals("") ) {
                return ;
            }

            // recherche et suppression du client dont le nom et prenom ont été saisi
            for (int i = 0; i < tableClients.getRowCount(); i++) {
                Object nomRow = tableClients.getValueAt(i, 1);
                Object prenomRow = tableClients.getValueAt(i, 2);
                if ( nomClient.equals( ((String)nomRow) ) && prenomClient.equals( ((String)prenomRow) ) ) {
                    monMagasin.supprimerClient( monMagasin.rechercherClient((String)nomRow)) ;
                }
            }

        }
    }
}