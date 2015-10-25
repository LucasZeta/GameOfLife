package com.lucaszeta.gameoflife.model;

import junit.framework.TestCase;

public class GameModelTest extends TestCase {

    GameModel model;

    public void setUp() throws Exception {
        super.setUp();

        model = new GameModel(10, 10);
    }

    public void testDimensions() throws Exception {
        assertEquals(10, model.getRows());
        assertEquals(10, model.getColumns());
    }

    public void testIsAlive() throws Exception {
        assertFalse(model.isAlive(1, 1));
        model.heal(1, 1);
        assertTrue(model.isAlive(1, 1));
    }

    public void testIsDead() throws Exception {
        model.heal(1, 1);
        assertTrue(model.isAlive(1, 1));

        model.kill(1, 1);
        assertFalse(model.isAlive(1, 1));
    }

    public void testUnderPopulation() throws Exception {
        model.heal(1, 1);
        model.heal(1, 2);
        model.heal(1, 3);
        assertTrue(model.willLive(1, 2));

        model.kill(1, 3);
        assertFalse(model.willLive(1, 2));
    }

    public void testSurvival() throws Exception {
        model.heal(1, 1);
        model.heal(1, 2);
        model.heal(1, 3);
        model.heal(2, 2);

        assertTrue(model.willLive(1, 2));

        model.kill(2, 2);
        assertTrue(model.willLive(1, 2));

        model.kill(1, 1);
        assertFalse(model.willLive(1, 2));
    }

    public void testOverPopulation() throws Exception {
        model.heal(1, 1);
        model.heal(1, 2);
        model.heal(1, 3);
        model.heal(2, 2);
        assertTrue(model.willLive(1, 2));

        model.heal(2, 1);
        assertFalse(model.willLive(1, 2));
    }

    public void testReproduction() throws Exception {
        assertFalse(model.willLive(2, 2));

        model.heal(1, 1);
        assertFalse(model.willLive(2, 2));

        model.heal(1, 2);
        assertFalse(model.willLive(2, 2));

        model.heal(1, 3);
        assertTrue(model.willLive(2, 2));
    }

    public void testOutOfBounds() throws Exception {
        model.heal(-1, 1);
        assertFalse(model.isAlive(-1, 1));

        model.heal(1, 1);
        assertTrue(model.isAlive(1, 1));

        model.heal(12, 1);
        assertFalse(model.isAlive(12, 1));
    }
}