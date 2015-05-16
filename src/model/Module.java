/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Rasem Laureen Jihane
 */
public class Module {

    private String nom;
    private String abrev;
    private Color couleur;
    private int nbseancetotal = 0;
    private int nbseancedispo;
    private ArrayList<Seance> seances;
    Formation formation;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getNbseancetotal() {
        return nbseancetotal;
    }

    public void setNbseancetotal(int v_nbseancetotal) {
        this.nbseancetotal = v_nbseancetotal;
    }

    public int getNbseancedispo() {
        return nbseancedispo;
    }

    public void setNbseancedispo(int v_nbseancedispo) {
        this.nbseancedispo = v_nbseancedispo;
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

}
