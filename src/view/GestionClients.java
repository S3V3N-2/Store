package view;

import controller.GestionClientsListener;
import model.Client;
import model.Magasin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Vector;

public class GestionClients extends JFrame {
    JLabel nomL = new JLabel("Nom client :");
    JTextField nomC = new JTextField("",20);
    JLabel prenomL = new JLabel("Prenom client :");
    JTextField prenomC = new JTextField("",20);
    JLabel telL = new JLabel("Tel client :");
    JTextField telC = new JTextField("",20);
    JLabel adrL = new JLabel("L'adresse du client :");
    JTextArea adrC = new JTextArea("",2,25);
    JPanel westPanel = new JPanel();
    JPanel centerPanel = new JPanel();

    JButton ajoutC = new JButton("Ajouter");
    JButton suppC = new JButton("Supprimer");

    Magasin magasin;
    Vector<Client> listeClients = new Vector<Client>();

    public GestionClients(Magasin m){
        magasin = m;
        listeClients = magasin.listeClient;
        this.setTitle("GESTION DES CLIENTS");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(700,400));

        getContentPane().setLayout( new BorderLayout() );
        westPanel.setLayout( new FlowLayout() );
        westPanel.setPreferredSize( new Dimension(300,0));

        getContentPane().add(westPanel,BorderLayout.WEST);
        nomC.setHorizontalAlignment(SwingConstants.CENTER);
        prenomC.setHorizontalAlignment(SwingConstants.CENTER);
        telC.setHorizontalAlignment(SwingConstants.CENTER);

        westPanel.add(nomL);
        westPanel.add(nomC);
        westPanel.add(prenomL);
        westPanel.add(prenomC);
        westPanel.add(telL);
        westPanel.add(telC);
        westPanel.add(adrL);
        westPanel.add(adrC);
        westPanel.add(ajoutC);
        westPanel.add(suppC);

        westPanel.setBackground(new Color(204,229,255));
        ajoutC.setBackground(new Color(102,178,255));
        ajoutC.setForeground(Color.white);
        suppC.setBackground(new Color(102,178,255));
        suppC.setForeground(Color.white);
        westPanel.setBorder( new EmptyBorder(70,0,0,0 ) );


        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Nom");
        columnNames.add("Prenom");
        columnNames.add("Téléphone");
        columnNames.add("Adresse");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(int i=0; i<listeClients.size();i++){
            Vector<Object> o = new Vector<Object>();
            o.add(listeClients.get(i).idC);
            o.add(listeClients.get(i).nom);
            o.add(listeClients.get(i).prenom);
            o.add(listeClients.get(i).tel);
            o.add(listeClients.get(i).adr);
            data.add(o);
        }

        JTable tableClients = new JTable(data, columnNames);
        magasin.addObserver( new JTableObserver(tableClients) );
        JScrollPane scrollPane = new JScrollPane(tableClients);
        tableClients.setDefaultEditor(Object.class,null);
        tableClients.setBackground(new Color(153,204,255));

        getContentPane().add(scrollPane,BorderLayout.CENTER);

        JTextField[] tabJTF = new JTextField[3];
        tabJTF[0] = nomC;
        tabJTF[1] = prenomC;
        tabJTF[2] = telC;
        GestionClientsListener gcl = new GestionClientsListener(magasin,tabJTF, adrC,tableClients);
        ajoutC.addActionListener(gcl);
        suppC.addActionListener(gcl);

        this.pack();
    }
}
