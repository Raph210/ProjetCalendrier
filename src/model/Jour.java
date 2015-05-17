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

    /**
     * Constructeur d'un jour. Il initalise une nouvelle journée et vérifie si
     * la journée est ouvrée ou non
     */
    public Jour(Calendar c, int v_semaine_annee, String v_moment) {
        this.jour_mois = c.get(Calendar.DAY_OF_MONTH);
        this.mois = c.get(Calendar.MONTH);
        this.annee = c.get(Calendar.YEAR);
        this.jour_semaine = c.get(Calendar.DAY_OF_WEEK);
        this.semaine_mois = c.get(Calendar.WEEK_OF_MONTH);
        this.semaine_annee = v_semaine_annee;
        this.moment = v_moment;
        this.libre = true;
        if (this.jour_semaine == 1 || this.jour_semaine == 7) {
            this.ouvree = false;
        } else {
            this.ouvree = true;
        }

    }

    /**
     * Ajout d'une séance à un jour. On vérifie si le jour en question est :
     * libre,ouvree et que des seances sont disponibles à l'affectation. C'est
     * dans cette méthode que l'appel au constructeur d'une seance est effectué.
     * après création d'une seance on l'affecte au jour courant et on met à jour
     * sons statut(libre=false).
     *
     * @param module afin d'ajouter une nouvelle seance il est necessaire de
     * connaitre le module associé le module est donc le parametre si le module
     * a la capacité d'acceuilir une nouvel seance il sera alors possible
     * d'affecter une seance au jour.
     */
    public boolean addSeance(Module module) {//permet d'ajouter une seance à un jour
        Seance s;
        int nbseancedispo;
        boolean reponse;
        if (this.ouvree == true && this.libre == true) {//on verifie que la journée est ouvrée et qu'une seance n'est pas dejà affectée
            if (module.getNbseancedispo() > 0) {//on vérifie que le nombre de seance proposé par le module n'est pas dépassé
                s = new Seance(module, module.getSeances().size() + 1, module.getNbseancetotal(), this);//on créé une nouvelle séance
                module.getSeances().add(s);//on ajoute la seance au module
                nbseancedispo = module.getNbseancedispo();
                module.setNbseancedispo(nbseancedispo - 1);//on diminue le nombre de seance dispo
                this.seance = s; //on enregistre la seance dans la class Jour
                this.setLibre((Boolean) false); //on met à jour le statut du jour en occupé    
                System.out.println("Ajout Reussi");
                reponse = true;
            } else {
                System.out.println("Erreur Ajout : Le module ne dispose plus d'assez de seance");
                reponse = false;
            }
        } else {
            System.out.println("Erreur Ajout : Journée non travaillé ou déjà attribué à une séance");
            reponse = false;
        }
        return reponse;
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
