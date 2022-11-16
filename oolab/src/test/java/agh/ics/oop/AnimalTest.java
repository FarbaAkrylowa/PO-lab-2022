package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    // Map and animal for moveOrientLocTest
    IWorldMap map1 = new RectangularMap(4, 4);
    Animal animal1 = new Animal(map1);

    // Map and animals for collidingAnimalsTest
    IWorldMap map2 = new RectangularMap(8, 5);
    Animal seal = new Animal(map2, new Vector2d(2, 1));
    Animal hippo = new Animal(map2, new Vector2d(3, 3));
    Animal camel = new Animal(map2, new Vector2d(6, 2));
    MapDirection n = MapDirection.NORTH, s = MapDirection.SOUTH, w = MapDirection.WEST, e = MapDirection.EAST;
    MoveDirection f = MoveDirection.FORWARD, b = MoveDirection.BACKWARD, r = MoveDirection.RIGHT, l = MoveDirection.LEFT;

    @Test
    void moveOrientLocTest(){
        // Test to check if animal moves properly and doesn't go outside the map (it checks animal's
        // location and orientation).
        // We use instance of IWorldMap, so we check almost every method of IWorldMap/RectangularMap except
        // testing eventual collisions (next test will check behaviour of more than one animal on the map).
        map1.place(animal1);
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

        assertEquals(MapDirection.NORTH, animal1.getOrientation());
        assertEquals(new Vector2d(2, 2), animal1.getLocation());
//        System.out.println(animal1 + " " + animal1.getLocation());
        for (int i = 0; i < len; i++){
            animal1.move(convertedMovesToTest[i]);
//            System.out.println("==========");
//            System.out.println("Current move: " + convertedMovesToTest[i]);
//            System.out.println(animal1 + " " + animal1.getLocation() + " == " + rightOrients[i] + " " + rightLoc[i]);
            assertEquals(rightOrients[i], animal1.getOrientation());
            assertEquals(rightLoc[i], animal1.getLocation());
        }
    }

    @Test
    void collidingAnimalsTest(){
        // Test to check how animals behave during eventual collisions + some kind of SimulationEngine test.
        map2.place(seal);
        map2.place(hippo);
        map2.place(camel);

        MoveDirection[] moves = {l, f, r, f, f, f, f, f, f, r, r, f, f, l, f, r, f, l, f, r, f};
        Vector2d[] hippoLocs = {new Vector2d(3, 3), new Vector2d(2, 3), new Vector2d(1, 3),
                new Vector2d(1, 3), new Vector2d(1, 4), new Vector2d(1, 4), new Vector2d(1, 4)};

        Vector2d[] sealLocs = {new Vector2d(2, 2), new Vector2d(2, 2), new Vector2d(2, 3),
                new Vector2d(2, 3), new Vector2d(2, 3), new Vector2d(2, 4), new Vector2d(2, 4)};

        Vector2d[] camelLocs = {new Vector2d(6, 2), new Vector2d(7, 2), new Vector2d(8, 2),
                new Vector2d(8, 2), new Vector2d(8, 2), new Vector2d(8, 2), new Vector2d(8, 3)};

        int h = 0, s = 0, c = 0;
        for (int i = 0; i < moves.length; i++){
            switch (i % 3){
                case 0 -> {
                    hippo.move(moves[i]);
//                    System.out.println("Hippo " + hippo.getLocation());
                    assertEquals(hippoLocs[h], hippo.getLocation());
                    h++;
                }
                case 1 -> {
                    seal.move(moves[i]);
//                    System.out.println("Seal: " + seal.getLocation());
                    assertEquals(sealLocs[s], seal.getLocation());
                    s++;
                }
                case 2 -> {
                    camel.move(moves[i]);
//                    System.out.println("Camel: " + camel.getLocation());
                    assertEquals(camelLocs[c], camel.getLocation());
                    c++;
                }
            }
        }
    }
}
