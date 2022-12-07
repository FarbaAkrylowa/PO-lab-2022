package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{
    private final IWorldMap map;
    private final MoveDirection[] directions;
    private final List<Animal> animals;
    private final App app;
    private final int moveDelay = 500;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalsLocations, App app){
        this.map = map;
        this.directions = moves;
        this.animals = new ArrayList<>();
        this.app = app;

        for (Vector2d pos: animalsLocations){
            Animal newAnimal = new Animal(map, pos);
            this.animals.add(newAnimal);
            this.map.place(newAnimal);
        }
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            this.app.renderMap(this.map);
        });

        try {
            Thread.sleep(this.moveDelay);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());;
        }

        int len = this.directions.length;
        for (int i = 0; i < len; i++){
            this.animals.get(i % this.animals.size()).move(this.directions[i]);

            Platform.runLater(() -> {
                this.app.renderMap(this.map);
            });

            try {
                Thread.sleep(this.moveDelay);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
