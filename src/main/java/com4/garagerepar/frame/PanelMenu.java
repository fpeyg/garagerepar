package com4.garagerepar.frame;

import com4.garagerepar.m.UtilisateurDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenu extends JPanel {

    private JFrame parent;

    private JButton utilisateur = new JButton("Les utilisateurs");
    private JButton vehicule = new JButton("Les véhicules");
    private JButton client = new JButton("Les clients");
    private JButton vente = new JButton("Les ventes");
    private JButton document = new JButton("Les documents");


    public PanelMenu(UtilisateurDAO udao, JFrame parent) {

        // layout de base est BorderLayout
        this.setLayout(new BorderLayout());

        // couleur orange pour le Menu
//        this.setBackground(Color.ORANGE);

//      boutons de gauche dans un GridLayout pour être en colonne
        JPanel gauche = new JPanel();

        // boutons de droite dans GridLayout aussi
        JPanel droite = new JPanel();

        GridLayout glgh = new GridLayout();
        glgh.setRows(4);
        glgh.setColumns(1);
        glgh.setHgap(60);
        glgh.setVgap(60);
        gauche.setLayout(glgh);

        GridLayout gldr = new GridLayout();
        gldr.setRows(1);
        gldr.setColumns(1);
        gldr.setHgap(60);
        gldr.setVgap(60);
        droite.setLayout(gldr);

        // ajout des deux panels sur celui de base
        JLabel entete = new JLabel ("Dirigeant");
        entete.setForeground (Color.ORANGE);
        this.add(entete, BorderLayout.NORTH);
        this.add(gauche, BorderLayout.CENTER);
        this.add(droite, BorderLayout.EAST);

        //  ajout boutons sur les conteneurs
        gauche.add(vehicule);
        gauche.add(client);
        gauche.add(vente);
        gauche.add(document);
        droite.add(utilisateur);

        //ajoute un listener pour chaque bouton
        utilisateur.addActionListener(new TraitementUtilisateur(udao, parent));
        vehicule.addActionListener(new TraitementVehicule());

    }


    public class TraitementUtilisateur  implements  ActionListener {

        private UtilisateurDAO udao;
        private JFrame parent;

        public TraitementUtilisateur(UtilisateurDAO udao, JFrame parent) {
            this.udao = udao;
            this.parent = parent;
        }

        public  void  actionPerformed(ActionEvent e) {
            System.out.println("Traitement des utilisateurs!");
            LesUtilisateurs gestion = new LesUtilisateurs(udao, parent);
            parent.setContentPane(gestion);
//            parent.getContentPane().setBackground(Color.BLUE);
            parent.getContentPane();
            parent.setVisible(true);

        }
    }

    public  class  TraitementVehicule implements ActionListener {

        public  void    actionPerformed(ActionEvent e) {

            System.out.println("Traitement des véhicules!");
        }
    }

}
