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
}