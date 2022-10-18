package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    void equalsTest(){
        Vector2d v1 = new Vector2d(5, 5);
        Vector2d v2 = new Vector2d(5, 5);
        Vector2d v3 = new Vector2d(4, 5);
        Vector2d v4 = new Vector2d(5, 4);
        Vector2d v5 = new Vector2d(4, 4);
        Vector2d v6 = new Vector2d(6, 6);

        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
        assertFalse(v1.equals(v4));
        assertFalse(v1.equals(v5));
        assertFalse(v1.equals(v6));
    }

    @Test
    void toStringTest(){
        Vector2d v1 = new Vector2d(5, 5);
        Vector2d v2 = new Vector2d(-5, 2);
        Vector2d v3 = new Vector2d(-1, -3);

        assertEquals("(5, 5)", v1.toString());
        assertEquals("(-5, 2)", v2.toString());
        assertEquals("(-1, -3)", v3.toString());
    }

    @Test
    void precedesTest(){
        Vector2d v1 = new Vector2d(2, 2);
        Vector2d v2 = new Vector2d(-2, -2);
        Vector2d v3 = new Vector2d(1, 3);
        Vector2d v4 = new Vector2d(3, 1);

        assertTrue(v2.precedes(v2));
        assertTrue(v2.precedes(v1));
        assertFalse(v1.precedes(v2));
        assertFalse(v1.precedes(v3));
        assertFalse(v1.precedes(v4));
    }

    @Test
    void followsTest(){
        Vector2d v1 = new Vector2d(2, 2);
        Vector2d v2 = new Vector2d(-2, -2);
        Vector2d v3 = new Vector2d(1, 3);
        Vector2d v4 = new Vector2d(3, 1);

        assertTrue(v1.follows(v1));
        assertTrue(v1.follows(v2));
        assertFalse(v2.follows(v1));
        assertFalse(v3.follows(v1));
        assertFalse(v4.follows(v1));
    }

    @Test
    void upperRightTest(){
        Vector2d v1 = new Vector2d(2, 1);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d res = new Vector2d(2, 2);

        assertEquals(res, v1.upperRight(v2));
        assertEquals(res, v2.upperRight(v1));
    }

    @Test
    void lowerLeftTest(){
        Vector2d v1 = new Vector2d(2, 1);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d res = new Vector2d(1, 1);

        assertEquals(res, v1.lowerLeft(v2));
        assertEquals(res, v2.lowerLeft(v1));
    }

    @Test
    void addTest(){
        Vector2d v1 = new Vector2d(2, 2);
        Vector2d v2 = new Vector2d(-2, -2);
        Vector2d v3 = new Vector2d(1, 3);

        Vector2d v1_v2 = new Vector2d(0, 0);
        Vector2d v1_v3 = new Vector2d(3, 5);
        Vector2d v2_v3 = new Vector2d(-1, 1);

        assertEquals(v1_v2, v1.add(v2));
        assertEquals(v1_v2, v2.add(v1));
        assertEquals(v1_v3, v1.add(v3));
        assertEquals(v2_v3, v3.add(v2));
    }

    @Test
    void subtractTest(){
        Vector2d v1 = new Vector2d(2, 2);
        Vector2d v2 = new Vector2d(-2, -2);
        Vector2d v3 = new Vector2d(1, 3);

        Vector2d v1_v2 = new Vector2d(4, 4);
        Vector2d v1_v3 = new Vector2d(1, -1);
        Vector2d v2_v3 = new Vector2d(-3, -5);

        assertEquals(v1_v2, v1.subtract(v2));
        assertEquals(v1_v3, v1.subtract(v3));
        assertEquals(v2_v3, v2.subtract(v3));
    }

    @Test
    void oppositeTest(){
        Vector2d v1 = new Vector2d(420, 420);
        Vector2d v2 = new Vector2d(-13, -13);
        Vector2d v3 = new Vector2d(6, -6);
        Vector2d v4 = new Vector2d(-8, 8);

        Vector2d res1 = new Vector2d(-420, -420);
        Vector2d res2 = new Vector2d(13, 13);
        Vector2d res3 = new Vector2d(-6, 6);
        Vector2d res4 = new Vector2d(8, -8);

        assertEquals(res1, v1.opposite());
        assertEquals(res2, v2.opposite());
        assertEquals(res3, v3.opposite());
        assertEquals(res4, v4.opposite());
    }
}