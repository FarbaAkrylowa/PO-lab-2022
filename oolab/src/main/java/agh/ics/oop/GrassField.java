package agh.ics.oop;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrass;
    private final Map<Vector2d, Grass> grassPlaces;
    private final MapBoundary mapBoundary;

    public GrassField(int n){
        this.numberOfGrass = n;
        this.animals = new HashMap<>();
        this.grassPlaces = new HashMap<>();
        this.mapBoundary = new MapBoundary();

        int grassCount = 0;
        while (grassCount < this.numberOfGrass){
            if (placeNewGrass()){
                grassCount++;
            }
        }
    }

    @Override
    protected Vector2d getUpperRight() {
        return this.mapBoundary.getUpRight();
    }

    @Override
    protected Vector2d getLowerLeft() {
        return this.mapBoundary.getLowLeft();
    }

    @Override
    public int getMinX() {
        return this.mapBoundary.getLowLeft().getX();
    }

    @Override
    public int getMinY() {
        return this.mapBoundary.getLowLeft().getY();
    }

    @Override
    public int getMaxX() {
        return this.mapBoundary.getUpRight().getX();
    }

    @Override
    public int getMaxY() {
        return this.mapBoundary.getUpRight().getY();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOccupied(position)){
            return true;
        }
        else if (objectAt(position) instanceof Grass) {
            placeNewGrass();
            grassPlaces.remove(position);
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if (super.place(animal)){
            this.mapBoundary.addPosition(animal.getLocation());
            animal.addObserver(mapBoundary);
            return true;
        }
        else if (objectAt(animal.getLocation()) instanceof Grass occupyingObject){
            this.mapBoundary.removePosition(occupyingObject.getPosition());
            this.grassPlaces.remove(occupyingObject.getPosition());
            this.animals.put(animal.getLocation(), animal);
            animal.addObserver(this);
            animal.addObserver(mapBoundary);
            this.mapBoundary.addPosition(animal.getLocation());
            placeNewGrass();
            return true;
        }

        else throw new IllegalArgumentException(animal.getLocation() + " is invalid animal placement!");
    }

    public boolean placeNewGrass(){
        Random randomGrassPlace = new Random();
        boolean placed = false;

        while (!placed){
            int x = randomGrassPlace.nextInt((int) Math.sqrt(10 * this.numberOfGrass));
            int y = randomGrassPlace.nextInt((int) Math.sqrt(10 * this.numberOfGrass));
            Grass newGrass = new Grass(new Vector2d(x, y));

            if (!isOccupied(newGrass.getPosition())){
                this.grassPlaces.put(newGrass.getPosition(), newGrass);
                this.mapBoundary.addPosition(newGrass.getPosition());
                placed = true;
            }
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (this.grassPlaces.containsKey(position)){
            return true;
        }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (this.grassPlaces.containsKey(position)){
            return this.grassPlaces.get(position);
        }
        return super.objectAt(position);
    }


    @Override
    public Vector2d[] getMapElements(){
        Vector2d[] animalsOnly = super.getMapElements();
        Vector2d[] mapElements = new Vector2d[animalsOnly.length + this.grassPlaces.size()];

        int index = 0;
        for (Vector2d pos: this.grassPlaces.keySet()){
            mapElements[index] = pos;
            index++;
        }

        for (int j = 0; j < mapElements.length; j++){
            mapElements[index] = animalsOnly[j];
        }
        return mapElements;
    }
}
