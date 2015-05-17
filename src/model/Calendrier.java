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
public class Calendrier {

    private ArrayList<Jour> joursMatin = new ArrayList<Jour>();
    private ArrayList<Jour> joursAprem = new ArrayList<Jour>();
    private int nbjourtotal = 0;

        
    public int getNbjourtotal(){
        return this.nbjourtotal;
    }

    public ArrayList <Jour> getJoursMatin() {
        return joursMatin;
    }

    public ArrayList <Jour> getJoursAprem() {
        return joursAprem;
    }

    public void setNbjourtotal(int nbjourtotal) {
        this.nbjourtotal = nbjourtotal;
    }

}
