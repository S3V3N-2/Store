package View;

import Model.LigneStock;
import Model.Magasin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class GestionVentes extends JFrame {
        JLabel label_vendeurs = new JLabel("Vendeur :");
        JComboBox<String > list_vendeurs ;
        JLabel label_clients = new JLabel("Client :");
        JComboBox<String> list_clients ;
        JLabel label_produits = new JLabel("Produit :");
        JComboBox<String> list_produits ;
        JSpinner quantite = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        JButton ajout_v = new JButton("Ajouter au panier");
        JButton valider_v = new JButton("Valider le panier");
        JPanel panel = new JPanel();

        Magasin magasin;

    public GestionVentes(Magasin m){
        this.setTitle("GESTION DES VENTES");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,600));
        magasin = m;

        Vector<String> nom_vendeurs = new Vector<String>();
        for (int i =0;i<m.listeVendeur.size();i++){
            nom_vendeurs.add(m.listeVendeur.get(i).nom + " "+m.listeVendeur.get(i).prenom);
        }
        list_vendeurs = new JComboBox<>(nom_vendeurs);

        Vector<String> nom_clients = new Vector<String>();
        for (int i =0;i<m.listeClient.size();i++){
            nom_clients.add(m.listeClient.get(i).nom + " "+m.listeClient.get(i).prenom);
        }
        list_clients = new JComboBox<>(nom_clients);

        Vector<String> nom_produits = new Vector<String>();
        for (int i =0;i<m.listeStock.get(0).listeLigneStock.size();i++){
            nom_produits.add(m.listeStock.get(0).listeLigneStock.get(i).article.nom);
        }
        list_produits = new JComboBox<>(nom_produits);

        getContentPane().setLayout( new BorderLayout() );
        panel.setLayout( new FlowLayout() );
        panel.add(list_vendeurs);
        panel.add(list_clients);
        panel.add(list_produits);
        panel.add(quantite);
        panel.add(ajout_v);
        panel.add(valider_v);
        getContentPane().add(panel,BorderLayout.CENTER);

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Nom du produit");
        columnNames.add("Quantité");
        columnNames.add("Prix unitaire");
        columnNames.add("Prix total");
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        JTable tableCommandes = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tableCommandes);

        getContentPane().add(scrollPane,BorderLayout.SOUTH);

        this.pack();
    }
}
