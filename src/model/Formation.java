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
