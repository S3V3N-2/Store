package view;

import controller.StatistiquesListener;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class Statistiques extends JFrame {

    JLabel titreGen = new JLabel("STATISTIQUES GENERALS");
    JLabel placeHolder= new JLabel("");
    JLabel article = new JLabel("Nombre articles vendus:");
    JLabel chifreAffairGeneral = new JLabel("Chiffre d'affairs:");
    JLabel artPlusVendu = new JLabel("Article plus vendus:");
    JLabel nbTArticle = new JLabel();
    JLabel nbChiffreAffair = new JLabel();
    JLabel nomArticlePlusVendus = new JLabel();


    Magasin magasin;


    JComboBox<String> listClients;
    JLabel titreClient= new JLabel("STATISTIQUES CLIENT");
    JLabel artPlusAchete = new JLabel("Article plus achete:");
    JLabel nomArticlePlusAchete = new JLabel();
    JLabel listLabel = new JLabel("Liste articles achetes: ");


    JLabel titreVendeur= new JLabel("STATISTIQUES VENDEURS");
    JComboBox<String> listVendeurs;
    JLabel chiffreAffaireVendeur = new JLabel("Chiffre d'affaires:");
    JLabel chiffre = new JLabel();
    JLabel nombreArticleVendue = new JLabel("Nombre articles vendus:");
    JLabel nombre = new JLabel();



    JPanel generalPanel = new JPanel();
    JPanel clientPanel = new JPanel();
    JPanel vendeursCenter = new JPanel();


    public Statistiques(Magasin m){
        this.setTitle("STATISTIQUES");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(1100,700));
        this.setLayout(new GridBagLayout());
        magasin = m;

        generalPanel.setLayout(new GridLayout(4,2,3,2));
        generalPanel.setPreferredSize(new Dimension(500,300));
        generalPanel.setBorder(BorderFactory.createLoweredBevelBorder());

        clientPanel.setLayout(new GridBagLayout());
        clientPanel.setPreferredSize(new Dimension(800,300));
        clientPanel.setBorder(BorderFactory.createLoweredBevelBorder());


        vendeursCenter.setLayout(new GridBagLayout());
        vendeursCenter.setPreferredSize(new Dimension(500,300));
        vendeursCenter.setBorder(BorderFactory.createLoweredBevelBorder());


        GridBagConstraints cPanel = new GridBagConstraints();
        cPanel.gridx=0;
        cPanel.gridy=0;
        cPanel.anchor=GridBagConstraints.PAGE_START;
        cPanel.weightx=1.00;
        cPanel.weighty=1.00;
        cPanel.insets= new Insets(10,40,0,0);
        getContentPane().add(generalPanel,cPanel);

        cPanel.gridx=1;
        cPanel.gridy=0;
        cPanel.weightx=1.00;
        cPanel.weighty=1.00;
        cPanel.anchor=GridBagConstraints.PAGE_START;
        cPanel.insets= new Insets(10,0,0,0);
        getContentPane().add(vendeursCenter,cPanel);

        cPanel.gridx=0;
        cPanel.gridy=1;
        cPanel.weightx=1.00;
        cPanel.weighty=1.00;
        cPanel.gridwidth = 2;
        cPanel.anchor=GridBagConstraints.PAGE_START;
        cPanel.insets= new Insets(0,50,0,0);
        getContentPane().add(clientPanel,cPanel);

        //on set le text au chiffre d'affair total et au rest
        nbTArticle.setText(magasin.qteTotalVendue()+"");
        nbChiffreAffair.setText(magasin.chiffreAffaireTotal()+"");
        nomArticlePlusVendus.setText(magasin.articleLePlusAchete().nom);


        generalPanel.add(titreGen);
        generalPanel.add(placeHolder);
        generalPanel.add(article);
        generalPanel.add(nbTArticle);
        generalPanel.add(chifreAffairGeneral);
        generalPanel.add(nbChiffreAffair);
        generalPanel.add(artPlusVendu);
        generalPanel.add(nomArticlePlusVendus);


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 2;
        constraints.insets=new Insets(10,10,0,0);
        clientPanel.add(titreClient,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 2;
        constraints.anchor=GridBagConstraints.PAGE_START;
        constraints.insets=new Insets(10,10,0,0);

        Vector<String> nomClients = new Vector<String>();
        nomClients.add("");
        for (int i =0;i<magasin.listeClient.size();i++){
            nomClients.add(magasin.listeClient.get(i).nom +" "+magasin.listeClient.get(i).prenom);
        }
        listClients = new JComboBox<>(nomClients);
        clientPanel.add(listClients,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 1;
        constraints.anchor=GridBagConstraints.PAGE_START;
        constraints.insets=new Insets(10,60,0,0);
        clientPanel.add(artPlusAchete,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.gridwidth = 1;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        constraints.insets=new Insets(10,30,0,0);
        clientPanel.add(nomArticlePlusAchete,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx=0.9;
        constraints.weighty=0.9;
        constraints.anchor=GridBagConstraints.PAGE_START;
        constraints.insets=new Insets(10,60,0,0);
        clientPanel.add(listLabel,constraints);


        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.gridx = 0;
        constraints2.gridy = 0;
        constraints2.weightx=0.9;
        constraints2.weighty=0.9;
        constraints2.gridwidth = 2;
        constraints2.insets=new Insets(10,10,0,0);
        vendeursCenter.add(titreVendeur,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 1;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 2;
        constraints2.anchor=GridBagConstraints.PAGE_START;
        constraints2.insets=new Insets(10,10,0,0);

        Vector<String> nomVendeurs = new Vector<String>();
        nomVendeurs.add("");
        for (int i =0;i<magasin.listeVendeur.size();i++){
            nomVendeurs.add(magasin.listeVendeur.get(i).nom +" "+magasin.listeVendeur.get(i).prenom);
        }
        listVendeurs = new JComboBox<>(nomVendeurs);
        vendeursCenter.add(listVendeurs,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 2;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 1;
        constraints2.anchor=GridBagConstraints.PAGE_START;
        constraints2.insets=new Insets(10,60,0,0);
        vendeursCenter.add(chiffreAffaireVendeur,constraints2);

        constraints2.gridx = 1;
        constraints2.gridy = 2;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 1;
        constraints2.anchor=GridBagConstraints.FIRST_LINE_START;
        vendeursCenter.add(chiffre,constraints2);

        constraints2.gridx = 0;
        constraints2.gridy = 3;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints2.gridwidth = 1;
        constraints2.anchor=GridBagConstraints.PAGE_START;
        constraints2.insets=new Insets(10,60,0,0);
        vendeursCenter.add(nombreArticleVendue,constraints2);


        constraints2.gridx = 1;
        constraints2.gridy = 3;
        constraints2.weightx= 0.9;
        constraints2.weighty= 0.9;
        constraints.insets=new Insets(10,30,0,0);
        constraints2.anchor = GridBagConstraints.FIRST_LINE_START;
        vendeursCenter.add(nombre,constraints2);



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
        clientPanel.add(scrollPanelC,constraints);
        tableC.setDefaultEditor(Object.class,null);


        StatistiquesListener statistiquesListener = new StatistiquesListener(magasin, listVendeurs, listClients,nomArticlePlusAchete,tableC,chiffre,nombre);
        listClients.addActionListener(statistiquesListener);
        listVendeurs.addActionListener(statistiquesListener);
        this.pack();
    }
}
