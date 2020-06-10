package com4.garagerepar.m;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer> {
    boolean existsByNom(String nom);
}

