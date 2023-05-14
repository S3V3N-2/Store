package View;

import Controller.StatistiquesListener;
import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class Statistiques extends JFrame {

    JLabel titreGen = new JLabel("STATISTIQUES GENERALS");
    JLabel placeHolder= new JLabel("");
    JLabel article = new JLabel("Nombre article vendu:");
    JLabel chifreAffairGeneral = new JLabel("Chifre d'Affair:");
    JLabel art_plus_vendu = new JLabel("Article plus vendus:");
    JLabel nbTArticle = new JLabel();
    JLabel nbChiffreAffair = new JLabel();
    JLabel nomArticlePlusVendus = new JLabel();


    Magasin magasin;


    JComboBox<String> list_clients;
    JLabel titreClient= new JLabel("STATISTIQUES CLIENT");
    JLabel art_plus_achete = new JLabel("Article plus achete:");
    JLabel nomArticlePlusAchete = new JLabel();
    JLabel list_label = new JLabel("Liste articles achete: ");


    JLabel titreVendeur= new JLabel("STATISTIQUES VENDEURS");
    JComboBox<String> list_vendeurs;
    JLabel chiffreAffaireVendeur = new JLabel("Chiffre affaire:");
    JLabel chiffre = new JLabel();
    JLabel nombreArticleVendue = new JLabel("Nombre article vendue:");
    JLabel nombre = new JLabel();



    JPanel general_north = new JPanel();
    JPanel client_north = new JPanel();
    JPanel vendeurs_center = new JPanel();


    public Statistiques(Magasin m){
        this.setTitle("STATISTIQUES");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1100,700));
        this.setLayout(new GridBagLayout());
        magasin = m;

        general_north.setLayout(new GridLayout(4,2,3,2));
        general_north.setPreferredSize(new Dimension(500,300));
        general_north.setBorder(BorderFactory.createLoweredBevelBorder());

        client_north.setLayout(new GridBagLayout());
        client_north.setPreferredSize(new Dimension(800,300));
        client_north.setBorder(BorderFactory.createLoweredBevelBorder());


        vendeurs_center.setLayout(new GridBagLayout());
        vendeurs_center.setPreferredSize(new Dimension(500,300));
        vendeurs_center.setBorder(BorderFactory.createLoweredBevelBorder());


        GridBagConstraints cPanel = new GridBagConstraints();
        cPanel.gridx=0;
        cPanel.gridy=0;
        cPanel.anchor=GridBagConstraints.PAGE_START;
        cPanel.weightx=1.00;
        cPanel.weighty=1.00;
        cPanel.insets= new Insets(10,40,0,0);
        getContentPane().add(general_north,cPanel);

        cPanel.gridx=1;
        cPanel.gridy=0;
        cPanel.weightx=1.00;
        cPanel.weighty=1.00;
        cPanel.anchor=GridBagConstraints.PAGE_START;
        cPanel.insets= new Insets(10,0,0,0);
        getContentPane().add(vendeurs_center,cPanel);

        cPanel.gridx=0;
        cPanel.gridy=1;
        cPanel.weightx=1.00;
        cPanel.weighty=1.00;
        cPanel.gridwidth = 2;
        cPanel.anchor=GridBagConstraints.PAGE_START;
        cPanel.insets= new Insets(0,50,0,0);
        getContentPane().add(client_north,cPanel);

        //on set le text au chiffre d'affair total et au rest
        nbTArticle.setText(magasin.qte_total_vendue()+"");
        nbChiffreAffair.setText(magasin.chiffreAffaireTotal()+"");
        nomArticlePlusVendus.setText(magasin.article_le_plus_achete().nom);


        general_north.add(titreGen);
        general_north.add(placeHolder);
        general_north.add(article);
        general_north.add(nbTArticle);
        general_north.add(chifreAffairGeneral);
        general_north.add(nbChiffreAffair);
        general_north.add(art_plus_vendu);
        general_north.add(nomArticlePlusVendus);


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 2;
        constraints.insets=new Insets(10,10,0,0);
        client_north.add(titreClient,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 2;
        constraints.anchor=GridBagConstraints.PAGE_START;
        constraints.insets=new Insets(10,10,0,0);

        Vector<String> nom_clients = new Vector<String>();
        nom_clients.add("");
        for (int i =0;i<magasin.listeClient.size();i++){
            nom_clients.add(magasin.listeClient.get(i).nom +" "+magasin.listeClient.get(i).prenom);
        }
        list_clients = new JComboBox<>(nom_clients);
        client_north.add(list_clients,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 1;
        constraints.anchor=GridBagConstraints.PAGE_START;
        constraints.insets=new Insets(10,60,0,0);
        client_north.add(art_plus_achete,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 1;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        constraints.insets=new Insets(10,30,0,0);
        client_north.add(nomArticlePlusAchete,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.anchor=GridBagConstraints.PAGE_START;
        constraints.insets=new Insets(10,60,0,0);
        client_north.add(list_label,constraints);


        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.gridx = 0;
        constraints2.gridy = 0;
        constraints2.weightx=0.9;
        constraints2.weighty=0.9;
        constraints2.gridwidth = 2;
        constraints2.insets=new Insets(10,10,0,0);
        vendeurs_center.add(titreVendeur,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 1;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 2;
        constraints2.anchor=GridBagConstraints.PAGE_START;
        constraints2.insets=new Insets(10,10,0,0);

        Vector<String> nom_vendeurs = new Vector<String>();
        nom_vendeurs.add("");
        for (int i =0;i<magasin.listeVendeur.size();i++){
            nom_vendeurs.add(magasin.listeVendeur.get(i).nom +" "+magasin.listeVendeur.get(i).prenom);
        }
        list_vendeurs = new JComboBox<>(nom_vendeurs);
        vendeurs_center.add(list_vendeurs,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 2;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 1;
        constraints2.anchor=GridBagConstraints.PAGE_START;
        constraints2.insets=new Insets(10,60,0,0);
        vendeurs_center.add(chiffreAffaireVendeur,constraints2);

        constraints2.gridx = 1;
        constraints2.gridy = 2;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 1;
        constraints2.anchor=GridBagConstraints.FIRST_LINE_START;
        vendeurs_center.add(chiffre,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 3;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 1;
        constraints2.anchor=GridBagConstraints.PAGE_START;
        constraints2.insets=new Insets(10,60,0,0);
        vendeurs_center.add(nombreArticleVendue,constraints2);


        constraints2.gridx = 1;
        constraints2.gridy = 3;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints.insets=new Insets(10,30,0,0);
        constraints2.anchor = GridBagConstraints.FIRST_LINE_START;
        vendeurs_center.add(nombre,constraints2);



        DefaultTableModel modelC = new DefaultTableModel();
        modelC.addColumn("Id");
        modelC.addColumn("Nom");
        modelC.addColumn("Prix");
        modelC.addColumn("Quantite");
        modelC.addColumn("Designation");

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        constraints.insets=new Insets(10,30,0,0);
        JTable tableC = new JTable(modelC);
        JScrollPane scrollPanelC = new JScrollPane(tableC);
        scrollPanelC.setPreferredSize(new Dimension(350,100));
        client_north.add(scrollPanelC,constraints);


        StatistiquesListener statistiquesListener = new StatistiquesListener(magasin,list_vendeurs,list_clients,nomArticlePlusAchete,tableC,chiffre,nombre);
        list_clients.addActionListener(statistiquesListener);
        list_vendeurs.addActionListener(statistiquesListener);
        this.pack();
    }
}
