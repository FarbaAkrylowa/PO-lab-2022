package agh.ics.oop;

public class World {
    public static void main(String[] args){
        /*
            Pojawienie się dwóch zwierząt w jednym miejscu - mój pomysł:
            Tworzymy sobie tablice 2D wielkości naszej mapy typu boolean - [i][j] = true jeśli stoi tam zwierz wpp. false
            W metodzie move klasy Animal dodajemy odpowiedni warunek na sprawdzenie czy jakies zwierze nie siedzi na danym
            polu na ktore chcemy przejsc.
            Jeśli mozna prejsc to aktualną pozycję w tablicy oznaczamy jako false, a pole na ktore przeszliśmy ustawiamy
            na true.
        */
        // JFrame
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();

        // f b r l f f r r f f f f f f f f

//        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new GrassField(10);
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();

    }
}
