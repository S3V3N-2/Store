package View;

import Controller.GestionVentesListener;
import Model.LigneStock;
import Model.Magasin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class GestionVentes extends JFrame {
        JLabel label_vendeurs = new JLabel("Vendeur :");
        JComboBox<String> list_vendeurs ;
        JLabel label_clients = new JLabel("Client :");
        JComboBox<String> list_clients ;
        JLabel label_produits = new JLabel("Produit :");
        JList<String> list_produits ;
        JSpinner quantite = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        JButton ajout_v = new JButton("Ajouter au panier");
        JButton supp_v = new JButton("Supprimer du panier");
        JButton valider_v = new JButton("Valider le panier");
        JPanel nordPanel = new JPanel();
        JPanel ouestPanel = new JPanel();

        Magasin magasin;

    public GestionVentes(Magasin m){
        this.setTitle("GESTION DES VENTES");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,600));
        magasin = m;

        Vector<String> nom_vendeurs = new Vector<String>();
        nom_vendeurs.add("");
        for (int i =0;i<m.listeVendeur.size();i++){
            nom_vendeurs.add(m.listeVendeur.get(i).nom + " " +m.listeVendeur.get(i).prenom);
        }
        list_vendeurs = new JComboBox<>(nom_vendeurs);

        Vector<String> nom_clients = new Vector<String>();
        nom_clients.add("");
        for (int i =0;i<m.listeClient.size();i++){
            nom_clients.add(m.listeClient.get(i).nom + " "+m.listeClient.get(i).prenom);
        }
        list_clients = new JComboBox<>(nom_clients);

        Vector<String> nom_produits = new Vector<String>();
        for (int i =0;i<m.listeStock.get(0).listeLigneStock.size();i++){
            nom_produits.add(m.listeStock.get(0).listeLigneStock.get(i).article.nom);
        }
        list_produits = new JList<>(nom_produits);

        getContentPane().setLayout( new BorderLayout() );
        nordPanel.setLayout( new FlowLayout() );
        ouestPanel.setLayout( new FlowLayout() );
        ouestPanel.add(label_vendeurs);
        ouestPanel.add(list_vendeurs);
        ouestPanel.add(label_clients);
        ouestPanel.add(list_clients);
        nordPanel.add(list_produits);
        nordPanel.add(quantite);
        nordPanel.add(ajout_v);
        nordPanel.add(supp_v);
        ouestPanel.add(valider_v);
        nordPanel.setPreferredSize(new Dimension(200,600));
        getContentPane().add(nordPanel,BorderLayout.WEST);
        getContentPane().add(ouestPanel,BorderLayout.NORTH);

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Nom du produit");
        columnNames.add("Quantité");
        columnNames.add("Prix unitaire");
        columnNames.add("Prix total");
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        JTable tableCommandes = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tableCommandes);

        getContentPane().add(scrollPane,BorderLayout.CENTER);

        GestionVentesListener gvl = new GestionVentesListener(magasin,list_produits,quantite,tableCommandes);
        ajout_v.addActionListener(gvl);
        supp_v.addActionListener(gvl);

        this.pack();
    }
}
