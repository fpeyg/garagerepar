package com4.garagerepar.m;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    private String nom;
    private String motdepasse;
    private String fonction;
    private int grade;

    public Utilisateur() {
    }

    public Utilisateur(int userid, String nom, String motdepasse, String fonction, int grade) {
        this.userid = userid;
        this.nom = nom;
        this.motdepasse = motdepasse;
        this.fonction = fonction;
        this.grade = grade;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "userid=" + userid +
                ", nom='" + nom + '\'' +
                ", motdepasse='" + motdepasse + '\'' +
                ", fonction='" + fonction + '\'' +
                ", grade=" + grade +
                '}';
    }
}
