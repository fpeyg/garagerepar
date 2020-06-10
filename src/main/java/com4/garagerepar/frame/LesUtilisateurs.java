package com4.garagerepar.frame;

import com4.garagerepar.m.Utilisateur;
import com4.garagerepar.m.UtilisateurDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LesUtilisateurs extends JPanel {

    public LesUtilisateurs(UtilisateurDAO udao, JFrame parent) {

        // suppression du setLayout auto pour utilisation de setBounds
       this.setLayout(null);

        //  JLabel pour le titre ===========================
        JLabel userLabel = new JLabel("Utilisateur");
        userLabel.setForeground (Color.BLUE);
        userLabel.setBounds(20, 10, 700, 25);    // titre
        add(userLabel);

        //  JLabel pour le nom  ===========================
        JLabel nomLabel = new JLabel("Nom");
        nomLabel.setBounds(20, 50, 500, 25);
        add(nomLabel);

        // Text field pour la saisie du nom
        JTextField nomText = new JTextField(20);
        nomText.setBounds(100, 50, 165, 25);
        add(nomText);
/*
        // JLabel pour le password ============================
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(20, 300, 80, 25);
        add(passwordLabel);

        // Text field pour la saisie du mot de passe masqué par des points
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(20, 400, 165, 25);
        add(passwordText);

        // JLabel pour la fonction =============================
        JLabel fonctionLabel = new JLabel("Fonction");
        fonctionLabel.setBounds(20, 500, 80, 25);
        add(fonctionLabel);

        // Text field pour la saisie de la fonction
        JTextField fonctionText = new JTextField(20);
        fonctionText.setBounds(120, 500, 165, 25);
        add(fonctionText);

        // JLabel pour le grade =============================
        JLabel gradeLabel = new JLabel("Grade");
        gradeLabel.setBounds(20, 130, 80, 25);
        add(gradeLabel);

        // Text field pour la saisie du grade avec combobox ????????????
        JTextField gradeInt = new JTextField(20);
        gradeInt.setBounds(20, 130, 165, 25);
        add(gradeInt);

        // Creating nouveau button
        JButton nouveauBouton = new JButton("Nouvel utilisateur");
        nouveauBouton.setBounds(20, 200, 200, 25);
        add(nouveauBouton);
*/
        // Creating bouton retour
        JButton retourBouton = new JButton("Retour");
        retourBouton.setBounds(20, 300, 80, 25);
        add(retourBouton);
/*
        //  ajout Listener sur le bouton nouveau
        nouveauBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("vous avez cliqué sur le bouton nouvel utilisateur " + nomText.getText());
//                AjoutUtilisateur(udao, nomText.getText(), passwordText.getPassword(), fonctionText.getText());
                AjoutUtilisateur(udao, nomText.getText());
            }
        });

        //  ajout Listener sur le bouton retour
        retourBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("vous avez cliqué sur le bouton retour ");
                PanelMenu entree = new PanelMenu(udao, parent);
                parent.setContentPane(entree);
                parent.getContentPane().setBackground(Color.YELLOW);
                parent.setVisible(true);
            }
        });
*/

    }

    public void AjoutUtilisateur (UtilisateurDAO udao, String nom) {

        String message;
        String titre;

        boolean found = udao.existsByNom(nom);
        if (found) {
            message = " L\'utilisateur " + nom + " existe déjà !! ";
            titre = "AJOUT UTILISATEUR";
            info(message, titre);
        } else {
            // ajout nouvel utilisateur
            Utilisateur u = new Utilisateur();
            u.setNom(nom);
            u.setMotdepasse("pwd");
            u.setFonction("developpeur");
            u.setGrade(0);
            udao.save(u);
            System.out.println("utilisateur ajouté ??");
        }
    }

    /**
     * Affiche un message d'information non bloquant
     * @param message le message d'information
     * @param titre le titre de la fenetre
     */
    public static void info(String message, String titre) {
        JFrame frame = new JFrame("showMessageDialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message, titre, JOptionPane.INFORMATION_MESSAGE);
    }


}
