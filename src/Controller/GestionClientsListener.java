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
        if (((JButton) e.getSource()).getText().equals("Ajouter")) {
            // vérifie si un des 4 champs sont vides
            if (tabTF[0].getText().equals("") || tabTF[1].getText().equals("") || tabTF[2].getText().equals("") || textArea.getText().equals("")) {
                return;
            }
            // recupérer et creer un nouveau client depuis les champs saisis
            Client c = new Client(tabTF[0].getText(), tabTF[1].getText(), tabTF[2].getText(), textArea.getText(), mon_magasin);

            //vérifie si le client existe déja dans notre magasin
            for (int i = 0; i < mon_magasin.listeClient.size(); i++) {
                if (mon_magasin.listeClient.get(i) == c) {
                    return;
                }
            }

            // Ajouter et afficher le client
            mon_magasin.listeClient.add(c);
            DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
            Vector<Object> o = new Vector<Object>();
            o.add(c.id_c);
            o.add(c.nom);
            o.add(c.prenom);
            o.add(c.tel);
            o.add(c.adr);
            model.addRow(o);
            // Vider les champs
            for (int i = 0; i < 3; i++) {
                tabTF[i].setText("");
            }
            textArea.setText("");

        }
        if (((JButton) e.getSource()).getText().equals("Supprimer")) {
            //Vérifie le champs nom et prenom qui vont servir a supprimer
            if( tabTF[0].getText().equals("") || tabTF[1].getText().equals("") ) { return ; }

            // recherche et suppression du client dont le nom et prenom ont été saisi
            for (int i = 0; i < tableClients.getRowCount(); i++) {
                Object nom_row = tableClients.getValueAt(i, 1);
                Object prenom_row = tableClients.getValueAt(i, 2);
                if ( tabTF[0].getText().equals( ((String)nom_row) ) && tabTF[1].getText().equals( ((String)prenom_row) ) ) {
                    DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
                    model.removeRow(i);
                    mon_magasin.listeClient.removeIf( element -> (element.nom.equals((String)nom_row)) && element.prenom.equals((String)prenom_row)) ;
                }
            }

        }
    }
}