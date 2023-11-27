package com.sprintdemo.firstappweb.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Personnage {


    @NotBlank
    private int id;
    @NotNull
    private String nom;
    @NotNull
    private String type;
    @NotBlank
    private int pointDeVie;

    public Personnage() {
    }

    public Personnage(int id, String nom, String type, int pointDeVie) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.pointDeVie = pointDeVie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getpointDeVie() {
        return pointDeVie;
    }

    public void setpointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", pointDeVie=" + pointDeVie +
                '}';
    }
}
