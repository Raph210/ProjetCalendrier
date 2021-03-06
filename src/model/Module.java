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
    /**
     * Va initialiser un nouveau module et l'ajouter à une formation
     * @param v_nom nom du module
     * @param v_abrev abreviation du module
     * @param v_nbseance nbseance possible pour ce module
     * @param v_formation foramtion lié au module
     */
    public Module(String v_nom, String v_abrev, int v_nbseance,Formation v_formation) {
        this.nom = v_nom;
        this.abrev = v_abrev;
        //this.couleur = v_couleur;
         this.nbseancetotal = v_nbseance;
         this.nbseancedispo=v_nbseance;
         this.seances=new ArrayList<Seance>();
         this.formation=v_formation;
         v_formation.getModules().add(this);
    }
    
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
