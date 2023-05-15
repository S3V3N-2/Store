package View;

import Controller.GestionProduitsListener;
import Model.LigneStock;
import Model.Stock;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GestionProduits extends JFrame {

    JTextField idTf = new JTextField("Id produit",10);
    JTextField nomTf = new JTextField("Nom produit",10);
    JTextField prixTf = new JTextField("Prix produit",10);
    JTextField qteTf = new JTextField("Quantité",10);
    JTextArea designationTf = new JTextArea("Entrez la déscription",3,60);
    JPanel nordPanel = new JPanel();

    JButton ajoutP = new JButton("Ajouter");
    JButton suppP = new JButton("Supprimer");

    Vector<LigneStock> ligneStock;
    Stock stock;



    public GestionProduits(Stock s){
        this.setTitle("GESTION DES PRODUITS");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(780,600));
        this.setLocationRelativeTo( null );
        stock = s;
        ligneStock = stock.listeLigneStock;
        getContentPane().setLayout(new BorderLayout());
        nordPanel.setLayout(new FlowLayout());
        nordPanel.setPreferredSize( new Dimension(500,250));
        getContentPane().add(nordPanel,BorderLayout.NORTH);
        nordPanel.add(idTf);
        nordPanel.add(nomTf);
        nordPanel.add(prixTf);
        nordPanel.add(qteTf);
        nordPanel.add(designationTf);
        nordPanel.add(ajoutP);
        nordPanel.add(suppP);


        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Nom");
        columnNames.add("Prix");
        columnNames.add("Quantité");
        columnNames.add("Désignation");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(int i=0; i<ligneStock.size();i++){
            Vector<Object> o = new Vector<Object>();
            o.add(ligneStock.get(i).article.idA);
            o.add(ligneStock.get(i).article.nom);
            o.add(ligneStock.get(i).article.prix);
            o.add(ligneStock.get(i).qte);
            o.add(ligneStock.get(i).article.designation);
            data.add(o);
        }

        JTable table = new JTable(data, columnNames);
        stock.addObserver(new JTableObserver(table));
        JScrollPane scrollPane = new JScrollPane(table);
        table.setDefaultEditor(Object.class,null);

        getContentPane().add(scrollPane,BorderLayout.CENTER);

        JTextField[] tabJTF = new JTextField[4];
        tabJTF[0] = idTf;
        tabJTF[1] = nomTf;
        tabJTF[2] = prixTf;
        tabJTF[3] = qteTf;

        GestionProduitsListener gpl = new GestionProduitsListener(s,tabJTF, designationTf,table);
        ajoutP.addActionListener(gpl);
        suppP.addActionListener(gpl);
        this.pack();
    }
}
