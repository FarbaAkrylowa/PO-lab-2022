package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangularMapTest {
    IWorldMap map = new RectangularMap(10, 10);
    Animal boar = new Animal(map, new Vector2d(2, 2));
    Animal piglet = new Animal(map, new Vector2d(4, 7));
    Animal tapir = new Animal(map, new Vector2d(3, 1));

    @Test
    void canMoveTo() {
        map.place(boar);
        map.place(piglet);
        map.place(tapir);
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(3, 0)));
        assertFalse(map.canMoveTo(new Vector2d(4, 7)));
        assertFalse(map.canMoveTo(new Vector2d(3, 1)));
    }

    @Test
    void place() {
        assertTrue(map.place(boar));
        assertTrue(map.place(piglet));
        assertTrue(map.place(tapir));
    }

    @Test
    void exceptionPlaceTest(){
        Animal alpaca = new Animal(map, new Vector2d(4, 7));
        assertTrue(map.place(boar));
        assertTrue(map.place(piglet));
        assertTrue(map.place(tapir));

        try {
            map.place(alpaca);
        } catch (IllegalArgumentException exception){
            assertEquals(alpaca.getLocation() + " is invalid animal placement!", exception.getMessage());
        }
    }

    @Test
    void isOccupied() {
        map.place(boar);
        map.place(piglet);
        map.place(tapir);
        assertTrue(map.isOccupied(boar.getLocation()));
        assertTrue(map.isOccupied(piglet.getLocation()));
        assertTrue(map.isOccupied(tapir.getLocation()));
        assertFalse(map.isOccupied(new Vector2d(2, 1)));
        assertFalse(map.isOccupied(new Vector2d(6, 2)));
        assertFalse(map.isOccupied(new Vector2d(3, 0)));
    }

    @Test
    void objectAt() {
        map.place(boar);
        map.place(piglet);
        map.place(tapir);
        assertEquals(map.objectAt(boar.getLocation()), boar);
        assertEquals(map.objectAt(piglet.getLocation()), piglet);
        assertEquals(map.objectAt(tapir.getLocation()), tapir);
    }
}
