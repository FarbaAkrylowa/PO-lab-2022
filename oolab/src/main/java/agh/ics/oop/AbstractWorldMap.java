package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangedObserver {
    protected abstract Vector2d getUpperRight();
    protected abstract Vector2d getLowerLeft();
    protected Map<Vector2d, Animal> animals;

    public AbstractWorldMap() {
        this.animals = new HashMap<>();
    }

    public abstract int getMinX();
    public abstract int getMinY();
    public abstract int getMaxX();
    public abstract int getMaxY();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getLocation())){
            this.animals.put(animal.getLocation(), animal);
            animal.addObserver(this);
            return true;
        }
        else return false;
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

    public Vector2d[] getMapElements(){
        int i = 0;
        Vector2d[] animalsPos = new Vector2d[this.animals.size()];

        for (Vector2d pos: this.animals.keySet()){
            animalsPos[i] = pos;
            i++;
        }

        return animalsPos;
    }
}
