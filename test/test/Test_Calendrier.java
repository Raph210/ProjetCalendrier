/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.IOException;
import model.Calendrier;
import model.Formation;
import model.Module;
import org.junit.Test;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Rasem
 */
public class Test_Calendrier {

    public Test_Calendrier() {
    }

    /**
     * Test si le calendrier prend en compte les années bisextiles.
     *
     */
    @Test //2
    public void testCreationJours() {
        Calendrier c1 = new Calendrier(2014);
        assertEquals(365, c1.getNbjourtotal());
    }
    
    @Test //3
    public void testAnneeBisextile() {
        Calendrier c1 = new Calendrier(2014);//Annee 2014-2015
        Calendrier c2 = new Calendrier(2015);//Annee 2015-2016(2016 Bisextile)
        assertEquals(365, c1.getNbjourtotal());
        assertEquals(366, c2.getNbjourtotal());
    }

    @Test //4 
    public void joursOuvre() {
        Calendrier c1 = new Calendrier(2014);
        //On se positionne sur le dimanche de la 1ère semaine (donc par defaut non ouvre)
        assertEquals(false, c1.getSemaineAprem(1).get(6).getOuvree());
        c1.getSemaineAprem(1).get(6).setOuvree(true);//On test la possibilité de modifier le statut d'un jour.
        assertEquals(true, c1.getSemaineAprem(1).get(6).getOuvree());
    }
    @Test
    public void affectationOuvre() {
        Calendrier c1 = new Calendrier(2014);
        Formation f = new Formation("Miage", 3);
        Module m = new Module("Programmtion Interface Java ", "IHM", 2, f);
        //On se positionne sur un dimanche donc par defaut non ouvre (false)
        assertEquals(false, c1.getSemaineAprem(1).get(6).addSeance(m));
        //On se positionne sur un lundi donc le jour est ouvree(true) par défaut 
        assertEquals(true, c1.getSemaineAprem(1).get(0).addSeance(m));
    }
    
    @Test //5
    public void testModuleCaracteristiques() {
        Formation f = new Formation("Miage", 3);
        Module m = new Module("Programmation Interface Java", "IHM", 2, f);
        assertEquals("Programmation Interface Java",m.getNom());
        assertEquals("IHM",m.getAbrev());
        assertEquals(2,m.getNbseancetotal());
    }
    @Test //6
    public void testModuleModification() {
        Formation f = new Formation("Miage", 3);
        Module m = new Module("Programmation Interface Java", "IHM", 2, f);
        assertEquals("Programmation Interface Java",m.getNom());
        m.setNom("Expression Communication");
        assertEquals("Expression Communication",m.getNom());
    }
     @Test
    public void testSerialiser() throws IOException{
        Calendrier c1 = new Calendrier(2015);
        c1.serialiser("c1_save_2015");
        assertTrue(new File("C:/Temp/c1_save_2015.dat").isFile());  
    }

}
