package View;

import Controller.GestionVendeursListener;
import Model.Client;
import Model.Magasin;
import Model.Vendeur;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GestionVendeurs extends JFrame {
    JTextField nom_v = new JTextField("Nom vendeur",20);
    JTextField prenom_v = new JTextField("Prenom vendeur",20);
    JTextField tel_v = new JTextField("Tel vendeur",20);
    JTextArea adr_v = new JTextArea("L'adresse du vendeur",2,25);
    JPanel west_panel = new JPanel();

    JButton ajout_v = new JButton("Ajouter");
    JButton supp_v = new JButton("Supprimer");

    Magasin magasin;
    Vector<Vendeur> listeVendeurs = new Vector<Vendeur>();

    public GestionVendeurs(Magasin m){
        this.setTitle("GESTION DES VENDEURS");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,400));
        magasin = m;
        listeVendeurs = magasin.listeVendeur;

        getContentPane().setLayout( new BorderLayout() );
        west_panel.setLayout( new FlowLayout() );
        west_panel.setPreferredSize( new Dimension(250,0) );
        getContentPane().add(west_panel,BorderLayout.WEST);
        nom_v.setHorizontalAlignment(SwingConstants.CENTER);
        prenom_v.setHorizontalAlignment(SwingConstants.CENTER);
        tel_v.setHorizontalAlignment(SwingConstants.CENTER);

        west_panel.add(nom_v);
        west_panel.add(prenom_v);
        west_panel.add(tel_v);
        west_panel.add(adr_v);
        west_panel.add(ajout_v);
        west_panel.add(supp_v);

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Nom");
        columnNames.add("Prenom");
        columnNames.add("Téléphone");
        columnNames.add("Adresse");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(int i=0; i<listeVendeurs.size();i++){
            Vector<Object> o = new Vector<Object>();
            o.add(listeVendeurs.get(i).id_v);
            o.add(listeVendeurs.get(i).nom);
            o.add(listeVendeurs.get(i).prenom);
            o.add(listeVendeurs.get(i).tel);
            o.add(listeVendeurs.get(i).adr);
            data.add(o);
        }

        JTable tableVendeurs = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tableVendeurs);

        getContentPane().add(scrollPane,BorderLayout.CENTER);

        JTextField[] tabJTF = new JTextField[3];
        tabJTF[0] = nom_v;
        tabJTF[1] = prenom_v;
        tabJTF[2] = tel_v;
        GestionVendeursListener gvl = new GestionVendeursListener(magasin,tabJTF,adr_v,tableVendeurs);
        ajout_v.addActionListener(gvl);
        supp_v.addActionListener(gvl);

        this.pack();
    }

}
