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
    private int nbseancetotal=0;
    private int nbseancedispo;
    private ArrayList<Seance> seances;
    Formation formation;
    
}
