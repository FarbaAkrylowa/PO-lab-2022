package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangedObserver {
    protected abstract Vector2d getUpperRight();
    protected abstract Vector2d getLowerLeft();
    protected Map<Vector2d, Animal> animals;
    public AbstractWorldMap() {

        this.animals = new HashMap<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getLocation())){
            this.animals.put(animal.getLocation(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.animals.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer animalsMap = new MapVisualizer(this);
        return animalsMap.draw(getLowerLeft(), getUpperRight());
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }
}
