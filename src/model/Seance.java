/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rasem Laureen Jihane
 */
public class Seance {
    private Module module;
    private int n;
    private int m;
    private Jour jour;
    
     public Seance(Module v_module, int v_n, int v_m, Jour v_jour) {
        this.n = v_n;
        this.m = v_m;
        module = v_module;
        jour=v_jour;
    }
    
    public Module getModule() {
        return module;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public Jour getJour() {
        return jour;
    }
    
}
