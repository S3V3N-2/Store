package view;

import controller.GestionVentesListener;
import model.Magasin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        this.setPreferredSize(new Dimension(600,400));
        this.setResizable(false);

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
        ouestPanel.setLayout( new FlowLayout() );
        nordPanel.setLayout( new FlowLayout() );
        nordPanel.add(labelVendeurs);
        nordPanel.add(listVendeurs);
        nordPanel.add(labelClients);
        nordPanel.add(listClients);
        ouestPanel.add(listProduits);
        ouestPanel.add(quantite);
        ouestPanel.add(ajoutV);
        ouestPanel.add(suppV);
        nordPanel.add(validerV);
        ouestPanel.setBorder( new EmptyBorder(70,0,0,0 ) );
        ouestPanel.setPreferredSize(new Dimension(200,400));
        getContentPane().add(ouestPanel,BorderLayout.WEST);
        getContentPane().add(nordPanel,BorderLayout.NORTH);

        nordPanel.setBackground(new Color(204,229,255));
        ouestPanel.setBackground(new Color(204,229,255));
        suppV.setBackground(new Color(102,178,255));
        ajoutV.setBackground(new Color(102,178,255));
        validerV.setBackground(new Color(102,178,255));


        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Nom du produit");
        columnNames.add("Quantité");
        columnNames.add("Prix unitaire");
        columnNames.add("Prix total");
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        JTable tableCommandes = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tableCommandes);
        tableCommandes.setDefaultEditor(Object.class,null);
        tableCommandes.setBackground(new Color(153,204,255));


        getContentPane().add(scrollPane,BorderLayout.CENTER);

        GestionVentesListener gvl = new GestionVentesListener(magasin, listProduits, listVendeurs, listClients,quantite,tableCommandes);
        ajoutV.addActionListener(gvl);
        suppV.addActionListener(gvl);
        validerV.addActionListener(gvl);

        this.pack();
    }
}
