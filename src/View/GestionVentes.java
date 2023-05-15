package View;

import Controller.GestionVentesListener;
import Model.Magasin;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GestionVentes extends JFrame {
        JLabel labelVendeurs = new JLabel("Vendeur :");
        JComboBox<String> listVendeurs;
        JLabel labelClients = new JLabel("Client :");
        JComboBox<String> listClients;
        JLabel labelProduits = new JLabel("Produit :");
        JList<String> listProduits;
        JSpinner quantite = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        JButton ajoutV = new JButton("Ajouter au panier");
        JButton suppV = new JButton("Supprimer du panier");
        JButton validerV = new JButton("Valider le panier");
        JPanel nordPanel = new JPanel();
        JPanel ouestPanel = new JPanel();

        Magasin magasin;

    public GestionVentes(Magasin m){
        this.setTitle("GESTION DES VENTES");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,600));
        magasin = m;

        Vector<String> nomVendeurs = new Vector<String>();
        nomVendeurs.add("");
        for (int i =0;i<magasin.listeVendeur.size();i++){
            nomVendeurs.add(magasin.listeVendeur.get(i).nom);
        }
        listVendeurs = new JComboBox<>(nomVendeurs);

        Vector<String> nomClients = new Vector<String>();
        nomClients.add("");
        for (int i =0;i<magasin.listeClient.size();i++){
            nomClients.add(magasin.listeClient.get(i).nom);
        }
        listClients = new JComboBox<>(nomClients);

        Vector<String> nomProduits = new Vector<String>();
        for (int i =0;i<magasin.listeStock.get(0).listeLigneStock.size();i++){
            nomProduits.add(magasin.listeStock.get(0).listeLigneStock.get(i).article.nom);
        }
        listProduits = new JList<>(nomProduits);

        getContentPane().setLayout( new BorderLayout() );
        nordPanel.setLayout( new FlowLayout() );
        ouestPanel.setLayout( new FlowLayout() );
        ouestPanel.add(labelVendeurs);
        ouestPanel.add(listVendeurs);
        ouestPanel.add(labelClients);
        ouestPanel.add(listClients);
        nordPanel.add(listProduits);
        nordPanel.add(quantite);
        nordPanel.add(ajoutV);
        nordPanel.add(suppV);
        ouestPanel.add(validerV);
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
        tableCommandes.setDefaultEditor(Object.class,null);
        tableCommandes.setDefaultEditor(Object.class,null);

        getContentPane().add(scrollPane,BorderLayout.CENTER);

        GestionVentesListener gvl = new GestionVentesListener(magasin, listProduits, listVendeurs, listClients,quantite,tableCommandes);
        ajoutV.addActionListener(gvl);
        suppV.addActionListener(gvl);
        validerV.addActionListener(gvl);

        this.pack();
    }
}
