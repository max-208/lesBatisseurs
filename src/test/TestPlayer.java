package test;

import org.junit.*;
import static org.junit.Assert.*;
import model.*;

public class TestPlayer {
    Player p;

    public TestPlayer(){
        super();
    }

    @Before()
    public void setUp(){
        p = new Player(PlayerType.Human);
    }

    @After()
    public void tearDown(){
        p = null;
    }

    @Test()
    public void testActionVersEcus(){
        assertEquals(p.getEcus(), 10);
        p.nouveauTour();
        assertTrue( p.actionVersEcu(1) );
        assertEquals(p.getEcus(), 11);
        assertTrue( p.actionVersEcu(2) );
        assertEquals(p.getEcus(), 14);
        p.nouveauTour();
        assertTrue( p.actionVersEcu(3) );
        assertEquals(p.getEcus(), 20);
        assertFalse( p.actionVersEcu(1) );
    }

    @Test()
    public void testEcuVersAction(){
        assertEquals(p.getEcus(), 10);
        assertEquals(p.getAction(), 0);
        p.nouveauTour();
        assertEquals(p.getAction(), 3);
        assertTrue( p.ecuVersAction(1) );
        assertEquals(p.getEcus(), 5);
        assertEquals(p.getAction(), 4);
        assertFalse( p.ecuVersAction(2) );
    }

    @Test()
    public void testChantier(){
        assertEquals(p.getPointVictoire(), 0);
        assertEquals(p.getEcus(), 10);
        p.cards.addBuild(new Build(1,"manoir", 3, 2, false, 1, 1, 1, 1));
        p.cards.addBuilder(new Builder(1,5, BuilderType.Apprenti, 1, 1, 1, 1));
        p.nouveauTour();
        assertEquals(p.getAction(), 3);
        assertTrue(p.ouvrirChantier(p.cards.getBuild(1)));
        assertEquals(p.getAction(), 2);
        assertTrue(p.envoyerTravailler(p.cards.getBuild(1), p.cards.getBuilder(1)));
        assertEquals(p.getAction(), 1);
        assertEquals(p.getPointVictoire(), 2);
        assertEquals(p.getEcus(), 8);
    }
}
