/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import projetcalendrier.Calendrier;
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
        model.Calendrier c1 = new model.Calendrier(2014);//Annee 2014-2015
        model.Calendrier c2 = new model.Calendrier(2015);//Annee 2015-2016(2016 Bisextile)
        assertEquals(365, c1.getNbjourtotal());
        assertEquals(366, c2.getNbjourtotal());
    }

}
