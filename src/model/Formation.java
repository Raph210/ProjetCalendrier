/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Rasem Laureen Jihane
 */
public class Formation {
    private String nom;
    private int dureeTypeSeance;
    private ArrayList<Module> modules;
    /**
     * Créer une nouvel foramtion et initialise une liste de module
     * @param v_nom nom de la formation
     * @param v_dureeseance duree type des seances de la formation
     */
    public Formation(String v_nom,int v_dureeseance) {
        this.nom=v_nom;
        this.dureeTypeSeance=v_dureeseance;
        this.modules=new ArrayList<Module>();
    }    
    
     public String getNom() {
        return nom;
    }

    public int getDureeTypeSeance() {
        return dureeTypeSeance;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
    
}
