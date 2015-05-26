/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/**
 *
 * @author Rasem Laureen Jihane
 */
public class Calendrier implements Serializable{

    private HashMap<Integer,ArrayList<Jour>> ListeSemainesMatin = new HashMap<>();
    private HashMap<Integer,ArrayList<Jour>> ListeSemainesAprem = new HashMap<>();
    private int nbjourtotal = 0;
    private int annee;

    /**
     * Constructeur d'un calendrier débutant en septembre et finissant en août.
     * A partir d'une année saisie le constructeur va automatiquement crééer un calendrier.
     * Etapes:
     * 1-Initialisation d'une variable de type calendar qui pointera sur la première semaine du mois de septembre
     * 2-cette variable pointera tour à tour sur les jours suivants
     * 3-Chaques jours sera ajoutés dans une semaine qui une fois complète sera ensuite ajouté au calendrier
     * 4-la boucle se termine lorsque tous les jours ont été parcourus
     * @param annee_saisie
     * il prend en paramètre une année choisie par l'utilisateur, cette année correspond à l'année de départ du calendrier 
     * Exemple : l'utilisateur saisie "2010" le calendrier créé debutera en septembre 2010 pour finir en aout 2011.
     *
     */
    public Calendrier(int annee_saisie) { //
        Jour j1, j2;//Deux jours un pour le matin un pour l'après midi
        int cpt = 1;
        this.annee=annee_saisie;
        int maxannee;//Variable utilisé pour stopper la boucle de création des jours
        int maxmois = 8;//Variable utilisé pour stopper la boucle de création des jours
        int semaine_annee = 1;//Compteur du nombre de semaine de l'année(Septembre->Aout)   
        boolean start_nbjour = false;
        ArrayList<Jour> ListejoursMatin = new ArrayList<Jour>();
        ArrayList<Jour> ListejoursAprem = new ArrayList<Jour>();

        Calendar cal = Calendar.getInstance(Locale.FRANCE);//Création d'une var de type Calendar par defaut pointe sur la date actuelle
        cal.set(Calendar.YEAR, annee_saisie); //modification de l'année du calendrier qui pointe desormais sur la date reçu en paramètre       
        maxannee = annee_saisie + 1;

        cal.set(Calendar.MONTH, Calendar.SEPTEMBER);//On se positionne sur le mois de septembre
        cal.set(Calendar.WEEK_OF_MONTH, 1);//On se positionne sur la première semaine de spetembre
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());//On se positionne sur le premier jour de septembre

        while (cal.get(Calendar.YEAR) != maxannee || cal.get(Calendar.MONTH) != maxmois) {
            
            if ((cal.get(Calendar.DAY_OF_MONTH) == 1)) {
                start_nbjour = true;
            }
            if (start_nbjour == true) {
                nbjourtotal += 1;//incrémentation du nombre de jour
            }
            
            //ajout du jour sur lequel pointe actuelement la var cal(Calendar)
            j1 = new Jour(cal, semaine_annee, "am");//création d'une matinée
            j2 = new Jour(cal, semaine_annee, "pm");//création d'une après midi
            ListejoursMatin.add(j1);//ajout d'une matinée à la liste des jours
            ListejoursAprem.add(j2);//ajout d'une après midi à la liste des jours
            
            if (cpt == 7) {//incrémentation du nombre de semaine 
                ListeSemainesMatin.put(semaine_annee,ListejoursMatin);
                ListeSemainesAprem.put(semaine_annee,ListejoursAprem);
                semaine_annee += 1;
                cpt = 0;
                ListejoursMatin = new ArrayList<Jour>();
                ListejoursAprem = new ArrayList<Jour>();
            }
            cal.add(Calendar.DATE, 1);//on passe à la journée suivante
            cpt += 1;
        }
    }
    Calendrier() {
    }
    /**
     * 
     * @return l'annee qui correspond au calendrier courant ex: 2015 pour annee(2015-2016)
     */
    public int getAnnee() {
        return this.annee;
    }

    public int getNbjourtotal() {
        return this.nbjourtotal;
    }    

    
    /**
     * 
     * @param v_numsemaine le numero de semaine que l'on souhaite récupérer
     * @return un ArrayList qui contient les jours (Matinée) d'une semaine passé en paramètre(v_numsemaine)
     */
    public ArrayList<Jour> getSemaineMatin(int v_numsemaine) {
        return ListeSemainesMatin.get(v_numsemaine);
    }
    /**
     * 
     * @param v_numsemaine le numero de semaine que l'on souhaite récupérer
     * @return un ArrayList qui contient les jours (Après Midi) d'une semaine passé en paramètre(v_numsemaine)
     */
    public ArrayList<Jour> getSemaineAprem(int v_numsemaine) {
        return ListeSemainesAprem.get(v_numsemaine);
    }

    
    public void serialiser(String v_chemin)throws FileNotFoundException, IOException {
        String PATH = "C://Temp//"+v_chemin+".dat";
    // Flux de communication
    FileOutputStream fos = new FileOutputStream(PATH);
    // Branché sur un flux de traitement
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(this);
    oos.close();
  }
    
   

}
