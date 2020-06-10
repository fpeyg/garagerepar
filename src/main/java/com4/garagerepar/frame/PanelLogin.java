package com4.garagerepar.frame;

import com4.garagerepar.m.UtilisateurDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLogin extends JPanel {

    public PanelLogin(UtilisateurDAO udao, JFrame parent) {

        // Creating JLabel
        JLabel userLabel = new JLabel("Nom : ");
        /* This method specifies the location and size
         * of component. setBounds(x, y, width, height)
         * here (x,y) are cordinates from the top left
         * corner and remaining two arguments are the width
         * and height of the component.
         */
        userLabel.setBounds(10,20,80,25);
        add(userLabel);

        /* Creating text field where user is supposed to
         * enter user name.
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        add(userText);

        // Same process for password label and text field.
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(10,50,80,25);
        add(passwordLabel);

        /*This is similar to text field but it hides the user
         * entered data and displays dots instead to protect
         * the password like we normally see on login screens.
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        add(passwordText);

        // Creating login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        add(loginButton);

        //  ajout Listener sur le bouton login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("vous avez cliqué sur le bouton login");

                PanelMenu entree = new PanelMenu(udao, parent);
                parent.setContentPane(entree);
//                parent.getContentPane().setBackground(Color.YELLOW);
                parent.getContentPane();
                parent.setVisible(true);

            }

        });

    }
}
