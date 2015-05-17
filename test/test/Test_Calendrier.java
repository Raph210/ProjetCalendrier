/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Calendrier;
import model.Formation;
import model.Module;
import org.junit.Test;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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
    @Test
    public void testAnneeBisextile() {
        Calendrier c1 = new Calendrier(2014);//Annee 2014-2015
        Calendrier c2 = new Calendrier(2015);//Annee 2015-2016(2016 Bisextile)
        assertEquals(365, c1.getNbjourtotal());
        assertEquals(366, c2.getNbjourtotal());
    }

    @Test
    public void joursOuvre() {
        Calendrier c1 = new Calendrier(2014);
        int indexjournee;
        indexjournee = c1.getIndexJour(31, 5);//Le 31/05 est un dimanche donc par defaut non ouvre
        assertEquals(false, c1.getJoursAprem().get(indexjournee).getOuvree());
        c1.getJoursAprem().get(indexjournee).setOuvree(true);//On test la possibilité de modifier le statut d'un jour.
        assertEquals(true, c1.getJoursAprem().get(indexjournee).getOuvree());
    }
    @Test
    public void affectationOuvre() {
        Calendrier c1 = new Calendrier(2014);
        Formation f = new Formation("Miage", 3);
        Module m = new Module("Programmtion Interface Java ", "IHM", 2, f);
        int indexjournee;
        indexjournee = c1.getIndexJour(31,5);//Le 31/05 est un dimanche donc par defaut non ouvre (false)
        assertEquals(false, c1.getJoursAprem().get(indexjournee).addSeance(m));
        indexjournee = c1.getIndexJour(1,6);//Le 1er juin est un lundi donc le jour est ouvree (true)
        assertEquals(true, c1.getJoursAprem().get(indexjournee).addSeance(m));
    }

}
