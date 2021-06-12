package test;

import org.junit.*;
import static org.junit.Assert.*;
import model.*;

public class TestBuild {
    Build b;
    public TestBuild(){
        super();
    }

    @Before()
    public void setUp(){
        b= new Build("Manoir",1,false,1,1,1,1);
    }

    @After()
    public void tearDown(){
        b = null;
    }

    @Test
    public void testGetters(){
        assertEquals(b.getNom(),"Manoir");
        assertEquals(b.getGain(),1);
        assertFalse(b.getEstMachine());
        assertFalse(b.getEstComplet());
        assertEquals(b.getCoutPierre(),1);
        assertEquals(b.getCoutBois(),1);
        assertEquals(b.getCoutSavoir(),1);
        assertEquals(b.getCoutTuile(),1);
    }

    @Test
    public void testConstruction(){
        assertFalse(b.getEstComplet());
        assertEquals(b.getWorkedPierre(),0);
        assertEquals(b.getWorkedBois(),0);
        assertEquals(b.getWorkedSavoir(),0);
        assertEquals(b.getWorkedTuile(),0);
        Builder b1 = new Builder(1,BuilderType.Apprenti,1,1,0,0);
        b.addBuilder(b1);
        assertFalse(b.getEstComplet());
        assertEquals(b.getWorkedPierre(),1);
        assertEquals(b.getWorkedBois(),1);
        assertEquals(b.getWorkedSavoir(),0);
        assertEquals(b.getWorkedTuile(),0);
        Builder b2 = new Builder(1,BuilderType.Apprenti,0,1,1,0);
        b.addBuilder(b2);
        assertFalse(b.getEstComplet());
        assertEquals(b.getWorkedPierre(),1);
        assertEquals(b.getWorkedBois(),2);
        assertEquals(b.getWorkedSavoir(),1);
        assertEquals(b.getWorkedTuile(),0);
        Builder b3 = new Builder(1,BuilderType.Apprenti,0,0,1,1);
        b.addBuilder(b3);
        assertTrue(b.getEstComplet());
        assertEquals(b.getWorkedPierre(),0);
        assertEquals(b.getWorkedBois(),0);
        assertEquals(b.getWorkedSavoir(),0);
        assertEquals(b.getWorkedTuile(),0);
    }
}
