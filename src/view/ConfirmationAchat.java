package view;

import controller.ConfirmationAchatListener;
import model.Commande;
import model.Magasin;

import javax.swing.*;
import java.awt.*;

public class ConfirmationAchat extends JFrame {
    JLabel qst = new JLabel("Voulez vous confirmer votre commande ?");
    JLabel txt;
    JPanel affichage = new JPanel();
    JButton bConfirmer = new JButton("Confirmer");
    JButton bAnnuler = new JButton("Annuler");
    JPanel bouttons = new JPanel();
    Commande commande;
    Magasin magasin;

    public ConfirmationAchat(Magasin m,Commande c){
        this.setTitle("CONFIRMATION");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(300,150));
        this.setResizable(false);

        commande = c;
        magasin = m;
        qst.setHorizontalAlignment(SwingConstants.CENTER);
        txt = new JLabel("Mr."+commande.client.nom+", Cela vous coûtera : "+commande.getPrice());
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().setLayout( new BorderLayout());
        affichage.setLayout(new FlowLayout());
        affichage.add(qst);
        affichage.add(txt);
        affichage.setBackground(new Color(204,229,255));
        getContentPane().add(affichage,BorderLayout.CENTER);
        bouttons.setLayout(new FlowLayout());
        bConfirmer.setBackground(new Color(102,178,255));
        bConfirmer.setForeground(Color.white);
        bouttons.add(bConfirmer);
        bAnnuler.setBackground(new Color(102,178,255));
        bAnnuler.setForeground(Color.WHITE);
        bouttons.add(bAnnuler);
        bouttons.setBackground(new Color(204,229,255));
        getContentPane().add(bouttons,BorderLayout.SOUTH);

        ConfirmationAchatListener cal = new ConfirmationAchatListener(magasin,commande,this.getContentPane(),this);
        bConfirmer.addActionListener(cal);
        bAnnuler.addActionListener(cal);

        this.pack();
        this.setVisible(true);
    }
}
