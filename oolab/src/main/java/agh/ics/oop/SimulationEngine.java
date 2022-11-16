package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final IWorldMap map;
    private final MoveDirection[] directions;
    private final List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalsLocations){
        this.map = map;
        this.directions = moves;
        this.animals = new ArrayList<>();

        for (Vector2d pos: animalsLocations){
            Animal newAnimal = new Animal(map, pos);
            this.animals.add(newAnimal);
            map.place(newAnimal);
        }
    }

    @Override
    public void run() {
        int len = this.directions.length;
        for (int i = 0; i < len; i++){
            System.out.println(this.map);
            animals.get(i % animals.size()).move(directions[i]);
        }
        System.out.println(this.map);
    }
}
