package View;

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



    public Menu(){
        this.setTitle("Menu TECHStore");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        this.setContentPane(grid_conteneur);
        this.pack();
        this.setVisible(true);

    }
}
