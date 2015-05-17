/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;

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

     public Jour(Calendar c, int v_semaine_annee, String v_moment) {
        this.jour_mois = c.get(Calendar.DAY_OF_MONTH);
        this.mois = c.get(Calendar.MONTH);
        this.annee = c.get(Calendar.YEAR);
        this.jour_semaine = c.get(Calendar.DAY_OF_WEEK);
        this.semaine_mois = c.get(Calendar.WEEK_OF_MONTH);
        this.semaine_annee = v_semaine_annee;
        this.moment = v_moment;
        this.libre=true;
        if (this.jour_semaine == 1 || this.jour_semaine == 7) {
            this.ouvree = false;
        } else {
            this.ouvree = true;
        }

    }
    public int getJour_mois() {
        return jour_mois;
    }

    public void setJour_mois(int jour_mois) {
        this.jour_mois = jour_mois;
    }

    public int getJour_semaine() {
        return jour_semaine;
    }

    public void setJour_semaine(int jour_semaine) {
        this.jour_semaine = jour_semaine;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getSemaine_mois() {
        return semaine_mois;
    }

    public void setSemaine_mois(int semaine_mois) {
        this.semaine_mois = semaine_mois;
    }

    public int getSemaine_annee() {
        return semaine_annee;
    }

    public void setSemaine_annee(int semaine_annee) {
        this.semaine_annee = semaine_annee;
    }

    public Boolean getOuvree() {
        return ouvree;
    }

    public void setOuvree(Boolean ouvree) {
        this.ouvree = ouvree;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public Boolean getLibre() {
        return libre;
    }

    public void setLibre(Boolean libre) {
        this.libre = libre;
    }

    public Seance getSeance() {
        return seance;
    }

}
