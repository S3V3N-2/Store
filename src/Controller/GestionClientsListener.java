package Controller;

import Model.Client;
import Model.Magasin;
import View.GestionClients;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GestionClientsListener implements ActionListener {

    Magasin mon_magasin;
    JTextField[] tabTF;
    JTextArea textArea;
    JTable tableClients;

    public GestionClientsListener(Magasin m, JTextField[] tab_tf, JTextArea adr_text, JTable tab_donnees) {
        mon_magasin = m;
        tabTF = tab_tf;
        textArea = adr_text;
        tableClients = tab_donnees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nom_client = tabTF[0].getText();
        String prenom_client = tabTF[1].getText();
        String tel_client = tabTF[2].getText();
        String adresse_client = textArea.getText();

        if (((JButton) e.getSource()).getText().equals("Ajouter")) {
            // vérifie si un des 4 champs sont vides
            if (nom_client.equals("") || prenom_client.equals("") || tel_client.equals("") || adresse_client.equals("")) {
                return;
            }
            // recupérer et creer un nouveau client depuis les champs saisis
            Client client = new Client(nom_client, prenom_client, tel_client, adresse_client, mon_magasin);

            //vérifie si le client existe déja dans notre magasin
            for (int i = 0; i < mon_magasin.listeClient.size(); i++) {
                if (mon_magasin.listeClient.get(i) == client) {
                    return;
                }
            }

            // Ajouter  client
            mon_magasin.ajouteClient(client);

            // Vider les champs
            for (int i = 0; i < 3; i++) {
                tabTF[i].setText("");
            }
            textArea.setText("");

        }
        if (((JButton) e.getSource()).getText().equals("Supprimer")) {
            //Vérifie le champs nom et prenom qui vont servir a supprimer
            if( nom_client.equals("") || prenom_client.equals("") ) {
                return ;
            }

            // recherche et suppression du client dont le nom et prenom ont été saisi
            for (int i = 0; i < tableClients.getRowCount(); i++) {
                Object nom_row = tableClients.getValueAt(i, 1);
                Object prenom_row = tableClients.getValueAt(i, 2);
                if ( nom_client.equals( ((String)nom_row) ) && prenom_client.equals( ((String)prenom_row) ) ) {
                    mon_magasin.supprimerClient( mon_magasin.rechercherClient((String)nom_row)) ;
                }
            }

        }
    }
}