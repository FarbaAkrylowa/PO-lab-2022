package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args){
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();

        // f b r l f f r r f f f f f f f f
        // lab7 sortedSet - treeSet recommended
        // orderX = new treeSet<>(Comparator.comparing(Vector2d :: getX()))
        // javafx periodic event
//        try {
//            MoveDirection[] directions = new OptionsParser().parse(args);
//            IWorldMap map = new GrassField(10);
//            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(5,6)};
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//        } catch (IllegalArgumentException exception){
//            System.out.println(exception.getMessage());
//        }

        Application.launch(App.class, args);
    }
}
