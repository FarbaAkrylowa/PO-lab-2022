package agh.ics.oop;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrass;
    private final Vector2d lowerLeftCorner;
    private final Vector2d upperRightCorner;
    private final Map<Vector2d, Grass> grassPlaces;

    public GrassField(int n){
        this.numberOfGrass = n;
        this.animals = new HashMap<>();
        this.grassPlaces = new HashMap<>();
        this.lowerLeftCorner = new Vector2d(0, 0);
        this.upperRightCorner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        int grassCount = 0;
        while (grassCount < this.numberOfGrass){
            if (placeNewGrass()){
                grassCount++;
            }
        }
    }

    @Override
    protected Vector2d getUpperRight() {
        int urx = 0, ury = 0;
        for (Map.Entry<Vector2d, Animal> animal: animals.entrySet()){
            if (animal.getValue().getLocation().x > urx){
                urx = animal.getValue().getLocation().x;
            }
            if (animal.getValue().getLocation().y > ury){
                ury = animal.getValue().getLocation().y;
            }
        }

        for (Map.Entry<Vector2d, Grass> grass: grassPlaces.entrySet()){
            if (grass.getValue().getPosition().x > urx){
                urx = grass.getValue().getPosition().x;
            }
            if (grass.getValue().getPosition().y > ury){
                ury = grass.getValue().getPosition().y;
            }
        }
        return new Vector2d(urx, ury);
    }

    @Override
    protected Vector2d getLowerLeft() {
        int llx = Integer.MAX_VALUE, lly = Integer.MAX_VALUE;
        for (Map.Entry<Vector2d, Animal> animal: animals.entrySet()){
            if (animal.getValue().getLocation().x < llx){
                llx = animal.getValue().getLocation().x;
            }
            if (animal.getValue().getLocation().y < lly){
                lly = animal.getValue().getLocation().y;
            }
        }

        for (Map.Entry<Vector2d, Grass> grass: grassPlaces.entrySet()){
            if (grass.getValue().getPosition().x < llx){
                llx = grass.getValue().getPosition().x;
            }
            if (grass.getValue().getPosition().y < lly){
                lly = grass.getValue().getPosition().y;
            }
        }

        return new Vector2d(llx, lly);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOccupied(position) && position.follows(lowerLeftCorner)){
            return true;
        }
        else if (objectAt(position) instanceof Grass) {
            grassPlaces.remove(position);
            placeNewGrass();
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (super.place(animal)){
            return true;
        }
        else {
            if (objectAt(animal.getLocation()) instanceof Grass occupyingObject){
                this.grassPlaces.remove(occupyingObject.getPosition());
                this.animals.put(animal.getLocation(), animal);
                animal.addObserver(this);
                placeNewGrass();
                return true;
            }
            else return false;
        }
    }

    public boolean placeNewGrass(){
        // TODO: but later
        Random randomGrassPlace = new Random();
        boolean placed = false;

        while (!placed){
            int x = randomGrassPlace.nextInt((int) Math.sqrt(10 * this.numberOfGrass));
            int y = randomGrassPlace.nextInt((int) Math.sqrt(10 * this.numberOfGrass));
            Grass newGrass = new Grass(new Vector2d(x, y));

            if (!isOccupied(newGrass.getPosition())){
                this.grassPlaces.put(newGrass.getPosition(), newGrass);
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
}
