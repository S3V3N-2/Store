package view;

import controller.GestionVendeursListener;
import model.Magasin;
import model.Vendeur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Vector;

public class GestionVendeurs extends JFrame {
    JLabel nomL = new JLabel("Nom vendeur :");
    JTextField nomV = new JTextField("",20);
    JLabel prenomL = new JLabel("Prenom vendeur :");
    JTextField prenomV = new JTextField("",20);
    JLabel telL = new JLabel("Tel vendeur :");
    JTextField telV = new JTextField("",20);
    JLabel adrL = new JLabel("L'adresse du vendeur");
    JTextArea adrV = new JTextArea("",2,25);
    JPanel westPanel = new JPanel();

    JButton ajoutV = new JButton("Ajouter");
    JButton suppV = new JButton("Supprimer");

    Magasin magasin;
    Vector<Vendeur> listeVendeurs = new Vector<Vendeur>();

    public GestionVendeurs(Magasin m){
        this.setTitle("GESTION DES VENDEURS");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(700,400));
        magasin = m;
        listeVendeurs = magasin.listeVendeur;

        getContentPane().setLayout( new BorderLayout() );
        westPanel.setLayout( new FlowLayout() );
        westPanel.setPreferredSize( new Dimension(300,0) );
        getContentPane().add(westPanel,BorderLayout.WEST);
        nomV.setHorizontalAlignment(SwingConstants.CENTER);
        prenomV.setHorizontalAlignment(SwingConstants.CENTER);
        telV.setHorizontalAlignment(SwingConstants.CENTER);

        westPanel.add(nomL);
        westPanel.add(nomV);
        westPanel.add(prenomL);
        westPanel.add(prenomV);
        westPanel.add(telL);
        westPanel.add(telV);
        westPanel.add(adrL);
        westPanel.add(adrV);
        westPanel.add(ajoutV);
        westPanel.add(suppV);

        westPanel.setBackground(new Color(204,229,255));
        ajoutV.setBackground(new Color(102,178,255));
        ajoutV.setForeground(Color.white);
        suppV.setBackground(new Color(102,178,255));
        suppV.setForeground(Color.white);
        westPanel.setBorder( new EmptyBorder(70,0,0,0 ) );

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
        tableVendeurs.setBackground(new Color(153,204,255));

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
