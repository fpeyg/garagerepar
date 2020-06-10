package com4.garagerepar;


import com4.garagerepar.frame.Myframe;
import com4.garagerepar.m.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class Runner implements CommandLineRunner {

// chargement de tous les DAO avant le lancement de la première fenêtre
    @Autowired
    UtilisateurDAO udao;

    @Override
    public void run(String[] args) throws Exception {

        EventQueue.invokeLater(() -> {
            Myframe fenetre = new Myframe(udao);
            fenetre.setVisible(true);
        });
    }
}

