package view;

import controller.GestionClientsListener;
import model.Client;
import model.Magasin;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GestionClients extends JFrame {
    JTextField nomC = new JTextField("Nom client",20);
    JTextField prenomC = new JTextField("Prenom client",20);
    JTextField telC = new JTextField("Tel client",20);
    JTextArea adrC = new JTextArea("L'adresse du client",2,25);
    JPanel westPanel = new JPanel();

    JButton ajoutC = new JButton("Ajouter");
    JButton suppC = new JButton("Supprimer");

    Magasin magasin;
    Vector<Client> listeClients = new Vector<Client>();

    public GestionClients(Magasin m){
        magasin = m;
        listeClients = magasin.listeClient;
        this.setTitle("GESTION DES CLIENTS");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,400));

        getContentPane().setLayout( new BorderLayout() );
        westPanel.setLayout( new FlowLayout() );
        westPanel.setPreferredSize( new Dimension(350,0));
        getContentPane().add(westPanel,BorderLayout.WEST);
        nomC.setHorizontalAlignment(SwingConstants.CENTER);
        prenomC.setHorizontalAlignment(SwingConstants.CENTER);
        telC.setHorizontalAlignment(SwingConstants.CENTER);

        westPanel.add(nomC);
        westPanel.add(prenomC);
        westPanel.add(telC);
        westPanel.add(adrC);
        westPanel.add(ajoutC);
        westPanel.add(suppC);

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
