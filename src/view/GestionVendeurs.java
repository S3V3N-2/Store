package view;

import controller.GestionVendeursListener;
import model.Magasin;
import model.Vendeur;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GestionVendeurs extends JFrame {
    JTextField nomV = new JTextField("Nom vendeur",20);
    JTextField prenomV = new JTextField("Prenom vendeur",20);
    JTextField telV = new JTextField("Tel vendeur",20);
    JTextArea adrV = new JTextArea("L'adresse du vendeur",2,25);
    JPanel westPanel = new JPanel();

    JButton ajoutV = new JButton("Ajouter");
    JButton suppV = new JButton("Supprimer");

    Magasin magasin;
    Vector<Vendeur> listeVendeurs = new Vector<Vendeur>();

    public GestionVendeurs(Magasin m){
        this.setTitle("GESTION DES VENDEURS");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,400));
        magasin = m;
        listeVendeurs = magasin.listeVendeur;

        getContentPane().setLayout( new BorderLayout() );
        westPanel.setLayout( new FlowLayout() );
        westPanel.setPreferredSize( new Dimension(350,0) );
        getContentPane().add(westPanel,BorderLayout.WEST);
        nomV.setHorizontalAlignment(SwingConstants.CENTER);
        prenomV.setHorizontalAlignment(SwingConstants.CENTER);
        telV.setHorizontalAlignment(SwingConstants.CENTER);

        westPanel.add(nomV);
        westPanel.add(prenomV);
        westPanel.add(telV);
        westPanel.add(adrV);
        westPanel.add(ajoutV);
        westPanel.add(suppV);

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Nom");
        columnNames.add("Prenom");
        columnNames.add("Téléphone");
        columnNames.add("Adresse");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(int i=0; i<listeVendeurs.size();i++){
            Vector<Object> o = new Vector<Object>();
            o.add(listeVendeurs.get(i).idV);
            o.add(listeVendeurs.get(i).nom);
            o.add(listeVendeurs.get(i).prenom);
            o.add(listeVendeurs.get(i).tel);
            o.add(listeVendeurs.get(i).adr);
            data.add(o);
        }

        JTable tableVendeurs = new JTable(data, columnNames);
        magasin.addObserver( new JTableObserver(tableVendeurs) );
        JScrollPane scrollPane = new JScrollPane(tableVendeurs);
        tableVendeurs.setDefaultEditor(Object.class,null);

        getContentPane().add(scrollPane,BorderLayout.CENTER);

        JTextField[] tabJTF = new JTextField[3];
        tabJTF[0] = nomV;
        tabJTF[1] = prenomV;
        tabJTF[2] = telV;
        GestionVendeursListener gvl = new GestionVendeursListener(magasin,tabJTF, adrV,tableVendeurs);
        ajoutV.addActionListener(gvl);
        suppV.addActionListener(gvl);

        this.pack();
    }

}
