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
public class Jour {
    private int jour_mois = 0;
    private int jour_semaine;// (1..7) (1=dimanche..7=samedi)
    private int mois;
    private int annee;
    private int semaine_mois;//num semaine du mois (1,2,3,4 ou 5)
    private int semaine_annee;//num semaine par rapport à l'année(sept->aout)
    private Boolean ouvree;
    private String moment;
    private Boolean libre;
    private Seance seance;
    
}
