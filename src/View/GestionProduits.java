package View;

import Model.LigneStock;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GestionProduits extends JFrame {

    JTextField id_tf = new JTextField("Id produit",10);
    JTextField nom_tf = new JTextField("Nom produit",10);
    JTextField prix_tf = new JTextField("Prix produit",10);
    JTextField qte_tf = new JTextField("Quantité",10);
    JTextArea designation_tf = new JTextArea("Entrez la déscription",3,60);
    JPanel nord_panel = new JPanel();

    JButton ajout_p = new JButton("Ajouter");
    JButton supp_p = new JButton("Supprimer");

    Vector<LigneStock> ligneStock;



    public GestionProduits(Vector<LigneStock> liste_ls){
        this.setTitle("GESTION DES PRODUITS");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,600));
        this.setLocationRelativeTo( null );
        ligneStock = liste_ls;
        getContentPane().setLayout(new BorderLayout());
        nord_panel.setLayout( new FlowLayout() );
        nord_panel.setPreferredSize( new Dimension(600,250));
        getContentPane().add(nord_panel,BorderLayout.NORTH);
        nord_panel.add(id_tf,BorderLayout.NORTH);
        nord_panel.add(nom_tf,BorderLayout.NORTH);
        nord_panel.add(prix_tf,BorderLayout.NORTH);
        nord_panel.add(qte_tf,BorderLayout.NORTH);
        nord_panel.add(designation_tf,BorderLayout.NORTH);
        nord_panel.add(ajout_p,BorderLayout.NORTH);
        nord_panel.add(supp_p,BorderLayout.NORTH);

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Nom");
        columnNames.add("Prix");
        columnNames.add("Quantité");
        columnNames.add("Désignation");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(int i=0; i<ligneStock.size();i++){
            Vector<Object> o = new Vector<Object>();
            o.add(ligneStock.get(i).article.id_a);
            o.add(ligneStock.get(i).article.nom);
            o.add(ligneStock.get(i).article.prix);
            o.add(ligneStock.get(i).qte);
            o.add(ligneStock.get(i).article.designation);
            data.add(o);
        }


        JTable table = new JTable(data, columnNames);
       JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane,BorderLayout.CENTER);


        this.pack();
    }
}
