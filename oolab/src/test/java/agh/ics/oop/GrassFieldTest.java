package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    IWorldMap map = new GrassField(10);
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
        Animal alpaca = new Animal(map, new Vector2d(4, 7));
        assertTrue(map.place(boar));
        assertTrue(map.place(piglet));
        assertTrue(map.place(tapir));
        assertFalse(map.place(alpaca));
    }

    @Test
    void isOccupied() {
        map.place(boar);
        map.place(piglet);
        map.place(tapir);
        assertTrue(map.isOccupied(boar.getLocation()));
        assertTrue(map.isOccupied(piglet.getLocation()));
        assertTrue(map.isOccupied(tapir.getLocation()));

        if (map.objectAt(new Vector2d(2, 1)) instanceof Grass){
            assertTrue(map.isOccupied(new Vector2d(2, 1)));
        } else assertFalse(map.isOccupied(new Vector2d(2, 1)));

        if (map.objectAt(new Vector2d(6, 2)) instanceof Grass){
            assertTrue(map.isOccupied(new Vector2d(6, 2)));
        } else assertFalse(map.isOccupied(new Vector2d(6, 2)));

        if (map.objectAt(new Vector2d(3, 0)) instanceof Grass){
            assertTrue(map.isOccupied(new Vector2d(3, 0)));
        } else assertFalse(map.isOccupied(new Vector2d(3, 0)));
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
