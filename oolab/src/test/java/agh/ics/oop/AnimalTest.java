package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    Animal sloth = new Animal();
    Animal peacock = new Animal();
    Animal hedgehog = new Animal();
    Animal anteater = new Animal();
    Animal axolotl = new Animal();
    Animal camel = new Animal();
    MapDirection n = MapDirection.NORTH, s = MapDirection.SOUTH, w = MapDirection.WEST, e = MapDirection.EAST;
    MoveDirection f = MoveDirection.FORWARD, b = MoveDirection.BACKWARD, r = MoveDirection.RIGHT, l = MoveDirection.LEFT;

    @Test
    void moveTest(){
        String[] movesToTest = {"abba", "b", "essa", "r", "forward", "r", "analfabeta", "f", "f", "right", "forward",
                "dale",  "f", "right", "frlb", "f", "forward", "forward", "left", "todorki", "f", "f", "r", "forward",
                "izuku", "r", "f", "left", "forward", "tokoyami", "r", "f", "right", "forward", "bakugo", "right",
                "backward", "g", "b", "backward", "eren", "giorno"};

        MapDirection[] rightOrients = {n, e, e, s, s, s, w, w, w, n, n, n, n, w, w, w, n, n, e, e, n, n, e, e, s, s, w, w, w, w};

        Vector2d[] rightLoc = {new Vector2d(2, 1), new Vector2d(2, 1), new Vector2d(3, 1), new Vector2d(3, 1),
        new Vector2d(3, 0), new Vector2d(3, 0), new Vector2d(3, 0), new Vector2d(2, 0), new Vector2d(1, 0),
        new Vector2d(1, 0), new Vector2d(1, 1), new Vector2d(1, 2), new Vector2d(1,3), new Vector2d(1, 3),
        new Vector2d(0, 3), new Vector2d(0, 3), new Vector2d(0, 3), new Vector2d(0, 4), new Vector2d(0, 4),
        new Vector2d(1, 4), new Vector2d(1, 4), new Vector2d(1, 4), new Vector2d(1, 4), new Vector2d(2, 4),
        new Vector2d(2, 4), new Vector2d(2, 3), new Vector2d(2, 3), new Vector2d(3, 3), new Vector2d(4, 3),
        new Vector2d(4, 3)};

        OptionsParser parserTest = new OptionsParser();
        MoveDirection[] convertedMovesToTest = parserTest.parse(movesToTest);

        int len = convertedMovesToTest.length;

        Animal kerfus = new Animal();
        assertEquals(MapDirection.NORTH, kerfus.getOrientation());
        assertEquals(new Vector2d(2, 2), kerfus.getLocation());
        for (int i = 0; i < len; i++){
            kerfus.move(convertedMovesToTest[i]);

            assertEquals(rightOrients[i], kerfus.getOrientation());
            assertEquals(rightLoc[i], kerfus.getLocation());
        }
    }

    @Test
    void isAtTest(){
        peacock.setLocation(new Vector2d(3, 3));
        axolotl.setLocation(new Vector2d(0, 0));
        anteater.setLocation(new Vector2d(-3, 2));
        hedgehog.setLocation(new Vector2d(-6, -9));

        assertTrue(peacock.isAt(new Vector2d(3, 3)));
        assertFalse(peacock.isAt(new Vector2d(2, -1)));
        assertTrue(axolotl.isAt(new Vector2d(0, 0)));
        assertFalse(axolotl.isAt(new Vector2d(-3, -10)));
        assertTrue(anteater.isAt(new Vector2d(-3, 2)));
        assertFalse(anteater.isAt(new Vector2d(7, 7)));
        assertTrue(hedgehog.isAt(new Vector2d(-6, -9)));
        assertFalse(hedgehog.isAt(new Vector2d(3, -8)));

        MoveDirection[] moves = {l, f, r, f, l, f, f, r, f, f};
        Vector2d[] locations = {new Vector2d(2, 2), new Vector2d(1, 2), new Vector2d(1, 2),
        new Vector2d(1, 3), new Vector2d(1, 3), new Vector2d(0, 3), new Vector2d(0, 3),
        new Vector2d(0, 3), new Vector2d(0, 4), new Vector2d(0, 4)};

        for (int i = 0; i < moves.length; i++){
            camel.move(moves[i]);
            assertTrue(camel.isAt(locations[i]));
        }
    }

    @Test
    void toStringTest(){
        peacock.setOrientation(MapDirection.SOUTH);
        peacock.setLocation(new Vector2d(3, 3));

        axolotl.setOrientation(MapDirection.WEST);
        axolotl.setLocation(new Vector2d(0, 0));

        anteater.setOrientation(MapDirection.EAST);
        anteater.setLocation(new Vector2d(-3, 2));

        hedgehog.setOrientation(MapDirection.NORTH);
        hedgehog.setLocation(new Vector2d(-6, -9));

        camel.setOrientation(MapDirection.WEST);
        camel.setLocation(new Vector2d(0, -7));

        assertEquals("Północ (2, 2)", sloth.toString());
        assertEquals("Południe (3, 3)", peacock.toString());
        assertEquals("Zachód (0, 0)", axolotl.toString());
        assertEquals("Wschód (-3, 2)", anteater.toString());
        assertEquals("Północ (-6, -9)", hedgehog.toString());
        assertEquals("Zachód (0, -7)", camel.toString());
    }
}
