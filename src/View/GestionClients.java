package View;

import Controller.GestionClientsListener;
import Model.Client;
import Model.Magasin;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GestionClients extends JFrame {
    JTextField nom_c = new JTextField("Nom client",20);
    JTextField prenom_c = new JTextField("Prenom client",20);
    JTextField tel_c = new JTextField("Tel client",20);
    JTextArea adr_c = new JTextArea("L'adresse du client",2,25);
    JPanel west_panel = new JPanel();

    JButton ajout_c = new JButton("Ajouter");
    JButton supp_c = new JButton("Supprimer");

    Magasin magasin;
    Vector<Client> listeClients = new Vector<Client>();

    public GestionClients(Magasin m){
        magasin = m;
        listeClients = magasin.listeClient;
        this.setTitle("GESTION DES CLIENTS");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,400));

        getContentPane().setLayout( new BorderLayout() );
        west_panel.setLayout( new FlowLayout() );
        west_panel.setPreferredSize( new Dimension(250,0) );
        getContentPane().add(west_panel,BorderLayout.WEST);
        nom_c.setHorizontalAlignment(SwingConstants.CENTER);
        prenom_c.setHorizontalAlignment(SwingConstants.CENTER);
        tel_c.setHorizontalAlignment(SwingConstants.CENTER);

        west_panel.add(nom_c);
        west_panel.add(prenom_c);
        west_panel.add(tel_c);
        west_panel.add(adr_c);
        west_panel.add(ajout_c);
        west_panel.add(supp_c);

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Nom");
        columnNames.add("Prenom");
        columnNames.add("Téléphone");
        columnNames.add("Adresse");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(int i=0; i<listeClients.size();i++){
            Vector<Object> o = new Vector<Object>();
            o.add(listeClients.get(i).id_c);
            o.add(listeClients.get(i).nom);
            o.add(listeClients.get(i).prenom);
            o.add(listeClients.get(i).tel);
            o.add(listeClients.get(i).adr);
            data.add(o);
        }

        JTable tableClients = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tableClients);

        getContentPane().add(scrollPane,BorderLayout.CENTER);

        JTextField[] tabJTF = new JTextField[3];
        tabJTF[0] = nom_c;
        tabJTF[1] = prenom_c;
        tabJTF[2] = tel_c;
        GestionClientsListener gcl = new GestionClientsListener(magasin,tabJTF,adr_c,tableClients);
        ajout_c.addActionListener(gcl);
        supp_c.addActionListener(gcl);

        this.pack();
    }
}
