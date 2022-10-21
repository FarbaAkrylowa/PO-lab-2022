package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    Vector2d vec1 = new Vector2d(0, 0);
    Vector2d vec2 = new Vector2d(-2, -2);
    Vector2d vec3 = new Vector2d(2, 2);
    Vector2d vec4 = new Vector2d(-3, 1);
    Vector2d vec5 = new Vector2d(1, -3);
    Vector2d vec6 = new Vector2d(3, 2);
    Vector2d vec7 = new Vector2d(-3, -2);
    Vector2d vec8 = new Vector2d(-1, 1);
    Vector2d vec9 = new Vector2d(2, 2);
    Vector2d vec10 = new Vector2d(-4, -4);

    @Test
    void equalsTest(){
        assertEquals(vec1, vec1);
        assertEquals(vec3, vec9);
        assertEquals(vec9, vec3);
        assertNotEquals(vec2, vec3);
        assertNotEquals(vec1, vec4);
        assertNotEquals(vec5, vec2);
        assertNotEquals(vec5, vec6);
        assertNotEquals(vec8, vec7);
        assertNotEquals(vec1, vec2);
    }

    @Test
    void toStringTest(){
        assertNotEquals("(1, 1)", vec1.toString());
        assertEquals("(-2, -2)", vec2.toString());
        assertEquals("(-1, 1)", vec8.toString());
        assertEquals("(-3, 1)", vec4.toString());
        assertEquals("(0, 0)", vec1.toString());
    }

    @Test
    void precedesTest(){
        assertTrue(vec1.precedes(vec3));
        assertTrue(vec10.precedes(vec7));
        assertTrue(vec7.precedes(vec2));
        assertFalse(vec4.precedes(vec1));
        assertTrue(vec8.precedes(vec9));
        assertTrue(vec8.precedes(vec8));
    }

    @Test
    void followsTest(){
        assertFalse(vec1.follows(vec3));
        assertFalse(vec10.follows(vec7));
        assertFalse(vec7.follows(vec2));
        assertFalse(vec4.follows(vec1));
        assertFalse(vec8.follows(vec9));
        assertTrue(vec8.follows(vec8));
    }

    @Test
    void upperRightTest(){
        assertEquals(new Vector2d(0, 0), vec2.upperRight(vec1));
        assertEquals(new Vector2d(1, 0), vec1.upperRight(vec5));
        assertEquals(new Vector2d(1, -2), vec7.upperRight(vec5));
        assertEquals(new Vector2d(3, 2), vec6.upperRight(vec3));
        assertEquals(new Vector2d(0, 1), vec1.upperRight(vec4));
    }

    @Test
    void lowerLeftTest(){
        assertEquals(new Vector2d(-2, -2), vec2.lowerLeft(vec1));
        assertEquals(new Vector2d(0, -3), vec1.lowerLeft(vec5));
        assertEquals(new Vector2d(-3, -3), vec7.lowerLeft(vec5));
        assertEquals(new Vector2d(2, 2), vec6.lowerLeft(vec3));
        assertEquals(new Vector2d(-3, 0), vec1.lowerLeft(vec4));
    }

    @Test
    void addTest(){
        assertEquals(new Vector2d(2, 2), vec1.add(vec3));
        assertEquals(new Vector2d(0, 0), vec2.add(vec3));
        assertEquals(new Vector2d(-1, 3), vec4.add(vec3));
        assertEquals(new Vector2d(1, 3), vec9.add(vec8));
        assertEquals(new Vector2d(-7, -6), vec10.add(vec7));
        assertEquals(new Vector2d(4, 4), vec3.add(vec3));
    }

    @Test
    void subtractTest(){
        assertEquals(new Vector2d(2, 2), vec1.subtract(vec2));
        assertEquals(new Vector2d(-3, 1), vec4.subtract(vec1));
        assertEquals(new Vector2d(6, 4), vec6.subtract(vec7));
        assertEquals(new Vector2d(-6, -4), vec7.subtract(vec6));
        assertEquals(new Vector2d(-3, -1), vec8.subtract(vec9));
        assertEquals(new Vector2d(0, 0), vec9.subtract(vec9));
    }

    @Test
    void oppositeTest(){
        assertEquals(vec1.opposite(), new Vector2d(0, 0));
        assertEquals(vec2.opposite(), new Vector2d(2, 2));
        assertEquals(vec6.opposite(), new Vector2d(-3, -2));
        assertEquals(vec10.opposite(), new Vector2d(4, 4));
        assertEquals(vec5.opposite(), new Vector2d(-1, 3));
        assertEquals(vec8.opposite(), new Vector2d(1, -1));
    }
}