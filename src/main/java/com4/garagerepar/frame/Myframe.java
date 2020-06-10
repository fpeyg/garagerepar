package com4.garagerepar.frame;

import com4.garagerepar.m.UtilisateurDAO;

import javax.swing.*;
import java.awt.*;

public class Myframe extends JFrame {

    private JPanel pan1 = new JPanel(new BorderLayout());

    public Myframe(UtilisateurDAO udao) {
        this.setTitle("Suivi des véhicules réparés et vendus");
        this.setSize(800,600);
        this.setResizable(true); // taille modifiable par l'utilisateur
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// un click sur croix entraine la fermeture de la fenêtre
        this.setLocationRelativeTo(null); // centrer la fenêtre par rapport à l'écran de l'ordinateur

        // ajout panel sur la Frame
        setContentPane(getPan1());

        // on cree le JPanel principal en utilisant  un OverlayLayout:
        // il faut créer un nouveau JPanel avec un OverlayLayout comme layout manager
        // ajouter les 2 JPanel (ou plus) au JPanel précédent avec la méthode add()
        // inter-changer entre les JPanel en utilisant setVisible()
        this.pan1.setLayout(new OverlayLayout(this.pan1));

        // on y ajoute les autres JPanel
        // on teste si la table utilisateur est vide, on va directement au menu
        // sinon il faut se logger
        if (isEmptyUser(udao)) {
            System.out.println("la table utilisateur est vide");
            this.pan1.add(new PanelMenu(udao, this));
        } else {
            System.out.println("Il existe des utilisateurs");
            this.pan1.add(new PanelLogin(udao, this));
        }
        // rendre la Frame visible
        this.setVisible(true);
    }

    public JPanel getPan1() {
        return pan1;
    }

    public void setPan1(JPanel pan1) {
        this.pan1 = pan1;
    }

    public boolean isEmptyUser(UtilisateurDAO udao) {
        System.out.println("compteur de la table utilisateur : " + udao.count());
        if (udao.count() == 0) {
            return true;
        }
        return false;
    }

}
