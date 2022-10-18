package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    void nextMethodTest(){
        MapDirection test1 = MapDirection.NORTH;
        MapDirection test2 = MapDirection.SOUTH;
        MapDirection test3 = MapDirection.EAST;
        MapDirection test4 = MapDirection.WEST;

        assertEquals(MapDirection.EAST, test1.next());
        assertEquals(MapDirection.WEST, test2.next());
        assertEquals(MapDirection.SOUTH, test3.next());
        assertEquals(MapDirection.NORTH, test4.next());
    }

    @Test
    void previousMethodTest(){
        MapDirection test1 = MapDirection.NORTH;
        MapDirection test2 = MapDirection.SOUTH;
        MapDirection test3 = MapDirection.EAST;
        MapDirection test4 = MapDirection.WEST;

        assertEquals(MapDirection.WEST, test1.previous());
        assertEquals(MapDirection.EAST, test2.previous());
        assertEquals(MapDirection.NORTH, test3.previous());
        assertEquals(MapDirection.SOUTH, test4.previous());
    }
}