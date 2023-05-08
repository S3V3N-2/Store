package View;

import Controller.ConfirmationAchatListener;
import Model.Commande;
import Model.Magasin;

import javax.swing.*;
import java.awt.*;

public class ConfirmationAchat extends JFrame {
    JLabel qst = new JLabel("Voulez vous confirmer votre commande ?");
    JLabel txt;
    JPanel affichage = new JPanel();
    JButton b_confirmer = new JButton("Confirmer");
    JButton b_annuler = new JButton("Annuler");
    JPanel bouttons = new JPanel();
    Commande commande;
    Magasin magasin;

    public ConfirmationAchat(Magasin m,Commande c){
        this.setTitle("CONFIRMATION");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(300,150));
        commande = c;
        magasin = m;
        qst.setHorizontalAlignment(SwingConstants.CENTER);
        txt = new JLabel("Mr."+commande.client.nom+", Cela vous coûtera : "+commande.getPrice());
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().setLayout( new BorderLayout());
        affichage.setLayout(new FlowLayout());
        affichage.add(qst);
        affichage.add(txt);
        getContentPane().add(affichage,BorderLayout.CENTER);
        bouttons.setLayout(new FlowLayout());
        bouttons.add(b_confirmer);
        bouttons.add(b_annuler);
        getContentPane().add(bouttons,BorderLayout.SOUTH);

        ConfirmationAchatListener cal = new ConfirmationAchatListener(magasin,commande,this.getContentPane(),this);
        b_confirmer.addActionListener(cal);
        b_annuler.addActionListener(cal);

        this.pack();
        this.setVisible(true);
    }
}