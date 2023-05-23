package view;

import controller.GestionProduitsListener;
import model.LigneStock;
import model.Stock;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GestionProduits extends JFrame {

    JLabel idL = new JLabel("Id produit :");
    JTextField idTf = new JTextField("",10);
    JLabel nomL = new JLabel("Nom produit :");
    JTextField nomTf = new JTextField("",10);
    JLabel prixL = new JLabel("Prix produit :");
    JTextField prixTf = new JTextField("",10);
    JLabel qteL = new JLabel("Quantité :");
    JTextField qteTf = new JTextField("",10);
    JLabel designationL = new JLabel("Entrez la déscription :");
    JTextArea designationTf = new JTextArea("",2,60);
    JPanel nordPanel = new JPanel();

    JButton ajoutP = new JButton("Ajouter");
    JButton suppP = new JButton("Supprimer");

    Vector<LigneStock> ligneStock;
    Stock stock;



    public GestionProduits(Stock s){
        this.setTitle("GESTION DES PRODUITS");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(750,400));
        this.setResizable(false);


        stock = s;
        ligneStock = stock.listeLigneStock;

        getContentPane().setLayout(new BorderLayout());
        nordPanel.setLayout(new FlowLayout());
        nordPanel.setPreferredSize( new Dimension(750,150));
        getContentPane().add(nordPanel,BorderLayout.NORTH);

        nordPanel.add(idL);
        nordPanel.add(idTf);
        nordPanel.add(nomL);
        nordPanel.add(nomTf);
        nordPanel.add(prixL);
        nordPanel.add(prixTf);
        nordPanel.add(qteL);
        nordPanel.add(qteTf);
        nordPanel.add(designationL);
        nordPanel.add(designationTf);
        nordPanel.add(ajoutP);
        nordPanel.add(suppP);

        nordPanel.setBackground(new Color(204,229,255));
        ajoutP.setBackground(new Color(102,178,255));
        ajoutP.setForeground(Color.black);
        suppP.setBackground(new Color(102,178,255));
        suppP.setForeground(Color.black);

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
        JPanel centerPanel = new JPanel();
        centerPanel.add(scrollPane);
        table.setBackground(new Color(153,204,255));
        centerPanel.setBackground(new Color(204,229,255));
        centerPanel.setPreferredSize(new Dimension(750,250) );
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);

        getContentPane().add(centerPanel,BorderLayout.CENTER);

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
