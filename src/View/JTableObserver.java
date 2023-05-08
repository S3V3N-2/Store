package View;

import Model.Client;
import Model.LigneStock;
import Model.Stock;
import Model.Vendeur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class JTableObserver implements Observer {

    JTable table;

    public JTableObserver(JTable table) {
        this.table = table;
    }

    @Override
    public void update(Observable obs, Object arg) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (obs instanceof Stock) { // Vérifiez si l'observable est une instance de MyTableModel
            LigneStock ls = (LigneStock) arg;

            // vérifie si la LigneStock envoyé existe déja dans notre table
            // si elle existe ca veut dire que le boutton supprimer a été appuyer donc
            // on le supprime et on quitte avec return;
            for (int i = 0; i < table.getRowCount(); i++) {
                Object id_row = table.getValueAt(i, 0);
                if (((int) id_row) == ls.article.id_a ) {
                    model.removeRow(i);
                    return;
                }
            }
            // si elle y est pas ca veut dire qu'on doit l'ajouter :
            Vector<Object> o = new Vector<Object>();
            o.add(ls.article.id_a);
            o.add(ls.article.nom);
            o.add(ls.article.prix);
            o.add(ls.qte);
            o.add(ls.article.designation);
            model.addRow(o);
        }

        // le cas où l'observation vient de l'interface GestionVendeurs
        if( arg instanceof Vendeur){
            Vendeur vendeur = (Vendeur) arg;

            // parcours le tableau pour voir si le vendeur existe ou pas
            // si l'observation vien du boutton supprimer
            for (int i = 0; i < table.getRowCount(); i++) {
                Object nom_row = table.getValueAt(i, 1);
                Object prenom_row = table.getValueAt(i, 2);
                if ( vendeur.nom.equals( ((String)nom_row) ) && vendeur.prenom.equals( ((String)prenom_row) ) ) {
                    model.removeRow(i);
                    return; // si un vendeur a été supprimer ça quitte comme ca il sera pas ajouter juste audessous
                }
            }

            // sinon si l'observation vien du boutton ajouter, apres avoir parcourru le tableau et
            // avoir vérifier que le vendeur n'existe pas alors elle l'ajoute
            // ajouter le vendeur si il existe pas dans le tableau
            Vector<Object> o = new Vector<Object>();
            o.add(vendeur.id_v);
            o.add(vendeur.nom);
            o.add(vendeur.prenom);
            o.add(vendeur.tel);
            o.add(vendeur.adr);
            model.addRow(o);
        }

        // le cas où l'observation vient de l'interface GestionClient
        if( arg instanceof Client){
            Client client = (Client) arg;

            // parcours le tableau pour voir si le client existe ou pas
            // si l'observation vien du boutton supprimer
            for (int i = 0; i < table.getRowCount(); i++) {
                Object nom_row = table.getValueAt(i, 1);
                Object prenom_row = table.getValueAt(i, 2);
                if ( client.nom.equals( ((String)nom_row) ) && client.prenom.equals( ((String)prenom_row) ) ) {
                    model.removeRow(i);
                    return; // si un client a été supprimer ça quitte comme ca il sera pas ajouter juste audessous
                }
            }

            // sinon si l'observation vien du boutton ajouter, apres avoir parcourru le tableau et
            // avoir vérifier que le client n'existe pas alors elle l'ajoute
            // ajouter le client si il existe pas dans le tableau
            Vector<Object> o = new Vector<Object>();
            o.add(client.id_c);
            o.add(client.nom);
            o.add(client.prenom);
            o.add(client.tel);
            o.add(client.adr);
            model.addRow(o);
        }

    }
}
