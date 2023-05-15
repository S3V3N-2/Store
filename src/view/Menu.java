package view;

import controller.MenuListener;
import model.Magasin;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    JLabel nom = new JLabel("TECH STORE");
    JButton produits = new JButton("Gestion Produits");
    JButton clients = new JButton("Gestion Clients");
    JButton vendeurs = new JButton("Gestion Vendeurs");
    JButton ventes = new JButton("Gestion Ventes");
    JButton stat = new JButton("Statistiques");

    JPanel gridConteneur = new JPanel();
    Magasin monMagasin;




    public Menu(model.Magasin m){
        monMagasin = m;
        this.setTitle("Menu "+m.nom);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,600));

        gridConteneur.setLayout(new GridLayout(6,1));
        gridConteneur.setPreferredSize(new Dimension(600,200));
        nom.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(gridConteneur);

        gridConteneur.add(nom);
        gridConteneur.add(produits);
        gridConteneur.add(clients);
        gridConteneur.add(vendeurs);
        gridConteneur.add(ventes);
        gridConteneur.add(stat);
        gridConteneur.setBackground(new Color(204,229,255));

        nom.setFont(new Font("Monospaced", Font.BOLD, 18));
        nom.setForeground(Color.blue);
        produits.setBackground(new Color(153,204,255));
        produits.setForeground(Color.white);
        clients.setBackground(new Color(153,204,255));
        clients.setForeground(Color.white);
        vendeurs.setBackground(new Color(153,204,255));
        vendeurs.setForeground(Color.white);
        ventes.setBackground(new Color(153,204,255));
        ventes.setForeground(Color.white);
        stat.setBackground(new Color(153,204,255));
        stat.setForeground(Color.white);



        MenuListener m_listener = new MenuListener(monMagasin);

        produits.addActionListener(m_listener);
        clients.addActionListener(m_listener);
        vendeurs.addActionListener(m_listener);
        ventes.addActionListener(m_listener);
        stat.addActionListener(m_listener);



        this.setContentPane(gridConteneur);
        this.pack();
        this.setVisible(true);

    }
}
