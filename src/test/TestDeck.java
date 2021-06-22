package test;

import org.junit.*;
import static org.junit.Assert.*;
import model.*;

public class TestDeck{

    Deck d;

    public TestDeck(){
        super();
    }

    @Before()
    public void setUp(){
        d = new Deck();
    }

    @After()
    public void tearDown(){
        d = null;
    }

    @Test()
    public void testAddGetPickBuilder(){
        Builder b1 = new Builder(0,1,BuilderType.Apprenti,1,1,1,1);
        assertTrue(d.addBuilder(b1));
        assertEquals(d.getBuilder(0),b1);
        assertNull(d.getBuilder(1));
        assertNull(d.getBuild(0));
        assertEquals(d.pickBuilder(0),b1);
        assertNull(d.getBuilder(0));
    }
    
    @Test()
    public void testAddGetPickBuild(){
        Build b1 = new Build(0,"manoir",1,1,false,1,1,1,1);
        assertTrue(d.addBuild(b1));
        assertEquals(d.getBuild(0),b1);
        assertNull(d.getBuild(1));
        assertNull(d.getBuilder(0));
        assertEquals(d.pickBuild(0),b1);
        assertNull(d.getBuild(0));
    }
    @Test()
        public void testAddGetPickMachine(){
            Machine m1 = new Machine(0,"moulin",1,1,1,1,1,1,1,1,1);
            assertTrue(d.addBuild(m1));
            assertEquals(d.getBuilder(0),null);
            assertEquals(d.getBuild(0),m1);
            assertEquals(d.getMachine(0),m1);
            assertEquals(d.pickBuild(0),m1);
            assertNull(d.getBuilder(0));
            assertNull(d.getBuild(0));
            assertNull(d.getMachine(0));
            assertTrue(d.addBuild(m1));
            assertEquals(d.pickBuild(0),m1);
            assertNull(d.getBuilder(0));
            assertNull(d.getBuild(0));
            assertNull(d.getMachine(0));
            assertTrue(d.addMachine(m1));
            assertEquals(d.pickMachine(0),m1);
            assertNull(d.getBuilder(0));
            assertNull(d.getBuild(0));
            assertNull(d.getMachine(0));
        }
}