/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Rasem Laureen Jihane
 */
public class Calendrier {

    private ArrayList<Jour> joursMatin = new ArrayList<Jour>();
    private ArrayList<Jour> joursAprem = new ArrayList<Jour>();
    private int nbjourtotal = 0;

    /**
     * Constructeur d'un calendrier débutant en septembre et finissant en août.
     * A partir d'une année saisie le constructeur va automatiquement crééer un calendrier.
     * Etapes:
     * 1-Initialisation d'une variable de type calendar qui pointera sur la première semaine du mois de septembre
     * 2-cette variable pointera tour à tour sur les jours suivants
     * 3-Chaques jours sera ajoutés au calendrier
     * 4-la boucle se termine lorsque tous les jours ont été parcourus
     * @param annee_saisie
     * il prend en paramètre une année choisie par l'utilisateur, cette année correspond à l'année de départ du calendrier 
     * Exemple : l'utilisateur saisie "2010" le calendrier créé debutera en septembre 2010 pour finir en aout 2011.
     *
     */
    public Calendrier(int annee_saisie) { //
        Jour j1, j2;//Deux jours un pour le matin un pour l'après midi
        int cpt = 0;
        int maxannee;//Variable utilisé pour stopper la boucle de création des jours
        int maxmois = 8;//Variable utilisé pour stopper la boucle de création des jours
        int semaine_annee = 1;//Compteur du nombre de semaine de l'année(Septembre->Aout)   
        boolean start_nbjour = false;

        Calendar cal = Calendar.getInstance(Locale.FRANCE);//Création d'une var de type Calendar par defaut pointe sur la date actuelle
        cal.set(Calendar.YEAR, annee_saisie); //modification de l'année du calendrier qui pointe desormais sur la date reçu en paramètre       
        maxannee = annee_saisie + 1;

        cal.set(Calendar.MONTH, Calendar.SEPTEMBER);//On se positionne sur le mois de septembre
        cal.set(Calendar.WEEK_OF_MONTH, 1);//On se positionne sur la première semaine de spetembre
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());//On se positionne sur le premier jour de septembre

        while (cal.get(Calendar.YEAR) != maxannee || cal.get(Calendar.MONTH) != maxmois) {
            if (cpt == 7) {//incrémentation du nombre de semaine 
                semaine_annee += 1;
                cpt = 0;
            }
            if ((cal.get(Calendar.DAY_OF_MONTH) == 1)) {
                start_nbjour = true;
            }
            if (start_nbjour == true) {
                nbjourtotal += 1;//incrémentation du nombre de jour
            }
            //ajout du jour sur lequel pointe actuelement la var cal(Calendar)
            j1 = new Jour(cal, semaine_annee, "am");//création d'une matinée
            j2 = new Jour(cal, semaine_annee, "pm");//création d'une après midi
            joursMatin.add(j1);//ajout d'une matinée à la liste des jours
            joursAprem.add(j2);//ajout d'une après midi à la liste des jours
            cal.add(Calendar.DATE, 1);//on passe à la journée suivante
            cpt += 1;
        }
    }

    public int getNbjourtotal() {
        return this.nbjourtotal;
    }

    public ArrayList<Jour> getJoursMatin() {
        return joursMatin;
    }

    public ArrayList<Jour> getJoursAprem() {
        return joursAprem;
    }

    public void setNbjourtotal(int nbjourtotal) {
        this.nbjourtotal = nbjourtotal;
    }
    
    /**
     * Renvoie l'index de l'array list où se trouve un jour du calendrier saisie en paramètre.
     * Par exemple si l'on veut connaitre l'index ou se trouve la journée du 25 décembre.
     * Les parametres seront 25 et 12.
     * @param v_jour le jour souhaité
     * @param v_mois le mois souhaité
     */
    public int getIndexJour(int v_jour, int v_mois) {
        int i;
        int res=0;
        for (i = 0; i < joursAprem.size(); i++) {
            if ((joursAprem.get(i).getJour_mois() == v_jour) 
                    && (joursAprem.get(i).getMois() == v_mois-1)
                    ) {
                res=i;
            }
        }
        return res;
    }

}
