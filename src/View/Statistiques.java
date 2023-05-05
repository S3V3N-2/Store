package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Statistiques extends JFrame {

    JLabel article = new JLabel("Nombre article vendu:");
    JLabel chifre_affair = new JLabel("Chifre d'Affair:");
    JLabel art_plus_vendu = new JLabel("Article plus vendus:");
    JLabel nbTArticle = new JLabel("2");
    JLabel nbChiffreAffair = new JLabel("3");
    JLabel nomArticlePlusVendus = new JLabel("iPhone12");

    Magasin magasin;
    Client client;
    Vector<Article> liste_article_client;
    String x;


    JComboBox<String> list_clients;
    JLabel art_plus_achete = new JLabel("Article plus achete:");
    JLabel nomArticlePlusAchete = new JLabel("nom article");
    JLabel list_label = new JLabel("liste articles achete: ");



    JComboBox<String> list_vendeurs;
    JLabel artv_plus_vendue = new JLabel("Article plus vendu:");
    JLabel nomArticlevPlusVendue = new JLabel("nom article");
    JLabel listv_label = new JLabel("liste articles vendu: ");


    JPanel general_north = new JPanel();
    JPanel client_north = new JPanel();
    JPanel vendeurs_center = new JPanel();


    public Statistiques(Magasin m, Client c){
        this.setTitle("STATISTIQUES");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(900,800));
        this.setLayout(new GridBagLayout());
        magasin = m;
        client = c;

        general_north.setLayout(new GridLayout(3,2,3,2));
        general_north.setPreferredSize(new Dimension(400,250));
        general_north.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //general_north.setBorder(BorderFactory.createEmptyBorder(100,200,100,200));

        client_north.setLayout(new GridBagLayout());
        client_north.setPreferredSize(new Dimension(400,250));
        client_north.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //client_north.setBorder(BorderFactory.createEmptyBorder(100,200,100,200));

        vendeurs_center.setLayout(new GridBagLayout());
        vendeurs_center.setPreferredSize(new Dimension(800,400));
        vendeurs_center.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        GridBagConstraints cPanel = new GridBagConstraints();
        cPanel.gridx=0;
        cPanel.gridy=0;
        cPanel.weightx=0.01;
        cPanel.weighty=0.01;
        getContentPane().add(general_north,cPanel);

        cPanel.gridx=1;
        cPanel.gridy=0;
        cPanel.weightx=0.01;
        cPanel.weighty=0.01;
        getContentPane().add(client_north,cPanel);

        cPanel.gridx=0;
        cPanel.gridy=1;
        cPanel.weightx=1.00;
        cPanel.weighty=1.00;
        cPanel.gridwidth = 2;
        getContentPane().add(vendeurs_center,cPanel);

        //on set le text au chiffre d'affair total et au rest (ne marche pas)
        nbTArticle.setText(magasin.qte_total_vendue()+"");
        nbChiffreAffair.setText(magasin.chiffreAffaireTotal()+"");
        nomArticlePlusVendus.setText(magasin.article_le_plus_achete().nom);


        general_north.add(article);
        general_north.add(nbTArticle);
        general_north.add(chifre_affair);
        general_north.add(nbChiffreAffair);
        general_north.add(art_plus_vendu);
        general_north.add(nomArticlePlusVendus);


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx= 0.01;
        constraints.weighty= 0.01;

        Vector<String> nom_clients = new Vector<String>();
        nom_clients.add("");
        for (int i =0;i<magasin.listeClient.size();i++){
            nom_clients.add(magasin.listeClient.get(i).nom +" "+magasin.listeClient.get(i).prenom);
        }
        list_clients = new JComboBox<>(nom_clients);
        client_north.add(list_clients,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx= 0.01;
        constraints.weighty= 0.01;
        client_north.add(art_plus_achete,constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx= 0.01;
        constraints.weighty= 0.01;
        //Prendre le nom selectione en parametre par la combobox et l'utiliser pour la quantite (ne marche pas)
        //x = String.valueOf(list_clients.getSelectedItem());
        //nomArticlePlusVendus.setText(client.article_le_plus_achete_client().toString());


        client_north.add(nomArticlePlusAchete,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx= 0.01;
        constraints.weighty= 0.01;
        client_north.add(list_label,constraints);


        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.gridx = 0;
        constraints2.gridy = 0;
        constraints2.weightx= 0.01;
        constraints2.weighty= 0.01;
        constraints2.gridwidth = 2;
        constraints2.anchor = GridBagConstraints.FIRST_LINE_START;

        Vector<String> nom_vendeurs = new Vector<String>();
        nom_vendeurs.add("");
        for (int i =0;i<magasin.listeVendeur.size();i++){
            nom_vendeurs.add(magasin.listeVendeur.get(i).nom + " "+magasin.listeVendeur.get(i).prenom);
        }
        list_vendeurs = new JComboBox<>(nom_vendeurs);
        vendeurs_center.add(list_vendeurs,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 1;
        constraints2.weightx= 0.05;
        constraints2.weighty= 0.05;
        constraints2.anchor = GridBagConstraints.LINE_START;
        vendeurs_center.add(artv_plus_vendue,constraints2);

        constraints2.gridx = 1;
        constraints2.gridy = 1;
        constraints2.weightx= 0.05;
        constraints2.weighty= 0.05;
        constraints2.anchor = GridBagConstraints.CENTER;
        vendeurs_center.add(nomArticlevPlusVendue,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 2;
        constraints2.weightx= 0.09;
        constraints2.weighty= 0.09;
        constraints2.anchor = GridBagConstraints.LINE_START;
        vendeurs_center.add(listv_label,constraints2);



       /*Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Nom");
        columnNames.add("Prix");
        columnNames.add("Quantité");
        columnNames.add("Désignation");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(int i = 0; i< liste_article_client.size(); i++){
            Vector<Object> o = new Vector<Object>();
            o.add(liste_article_client.);
            o.add(liste_article_client.get(i).);
            o.add(liste_article_client.get(i).);
            o.add(liste_article_client.get(i).);
            o.add(liste_article_client.get(i).);
            data.add(o);
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane,BorderLayout.CENTER);

*/
        this.pack();
    }
}
