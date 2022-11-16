package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected Vector2d upperRightCorner;
    protected Vector2d lowerLeftCorner;
    protected List<Animal> animals = new ArrayList<Animal>();
    protected List<Grass> grassPlaces = new ArrayList<Grass>();
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeftCorner) && position.precedes(upperRightCorner) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getLocation())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals){
            if (animal.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals){
            if (animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "asd";
    }
}
