package View;

import Controller.MenuListener;
import Model.Client;
import Model.Magasin;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    JLabel nom = new JLabel("Tech Store");
    JButton produits = new JButton("Gestion Produits");
    JButton clients = new JButton("Gestion Clients");
    JButton vendeurs = new JButton("Gestion Vendeurs");
    JButton ventes = new JButton("Gestion Ventes");
    JButton stat = new JButton("Statistiques");

    JPanel grid_conteneur = new JPanel();
    Magasin mon_magasin;
    Client client;




    public Menu(Model.Magasin m){
        mon_magasin = m;
        this.setTitle("Menu "+m.nom);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,600));

        grid_conteneur.setLayout(new GridLayout(6,1));
        grid_conteneur.setPreferredSize(new Dimension(600,200));
        nom.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(grid_conteneur);
        grid_conteneur.add(nom);
        grid_conteneur.add(produits);
        grid_conteneur.add(clients);
        grid_conteneur.add(vendeurs);
        grid_conteneur.add(ventes);
        grid_conteneur.add(stat);

        MenuListener m_listener = new MenuListener(mon_magasin,client);

        produits.addActionListener(m_listener);
        clients.addActionListener(m_listener);
        vendeurs.addActionListener(m_listener);
        ventes.addActionListener(m_listener);
        stat.addActionListener(m_listener);



        this.setContentPane(grid_conteneur);
        this.pack();
        this.setVisible(true);

    }
}
