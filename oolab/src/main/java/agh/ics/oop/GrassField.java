package agh.ics.oop;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrass;
    private final Vector2d lowerLeftCorner;
    private final Vector2d upperRightCorner;
    private final List<Grass> grassPlaces;
    private final MapVisualizer visualizeMap;

    public GrassField(int n){
        this.numberOfGrass = n;
        this.animals = new ArrayList<>();
        this.grassPlaces = new ArrayList<>();
        this.lowerLeftCorner = new Vector2d(0, 0);
        this.upperRightCorner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.visualizeMap = new MapVisualizer(this);

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

        for (Animal animal: animals){
            if (animal.getLocation().x > urx){
                urx = animal.getLocation().x;
            }

            if (animal.getLocation().y > ury){
                ury = animal.getLocation().y;
            }
        }

        for (Grass grass: grassPlaces){
            if (grass.getPosition().x > urx){
                urx = grass.getPosition().x;
            }

            if (grass.getPosition().y > ury){
                ury = grass.getPosition().y;
            }
        }
        return new Vector2d(urx, ury);
    }

    @Override
    protected Vector2d getLowerLeft() {
        int llx = Integer.MAX_VALUE, lly = Integer.MAX_VALUE;

        for (Animal animal: animals){
            if (animal.getLocation().x < llx){
                llx = animal.getLocation().x;
            }

            if (animal.getLocation().y < lly){
                lly = animal.getLocation().y;
            }
        }

        for (Grass grass: grassPlaces){
            if (grass.getPosition().x < llx){
                llx = grass.getPosition().x;
            }

            if (grass.getPosition().y < lly){
                lly = grass.getPosition().y;
            }
        }
        return new Vector2d(llx, lly);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
//        boolean occupied = isOccupied(position);

        if (super.canMoveTo(position) && position.follows(lowerLeftCorner)){
            return true;
        }
        else if (objectAt(position) instanceof Grass) {
            for (Grass grass: grassPlaces){
                Vector2d grassPos = grass.getPosition();

                if (position.equals(grassPos)){
                    grassPlaces.remove(grass);
                    placeNewGrass();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
//        if (!isOccupied(animal.getLocation())){
//            this.animals.add(animal);
//            return true;
//        }
        if (super.place(animal)){
            return true;
        }
        else {
            Object occupyingObject = objectAt(animal.getLocation());
            if (occupyingObject instanceof Grass){
                for (Grass grass: grassPlaces){
                    Vector2d animalPos = animal.getLocation();
                    Vector2d grassPos = grass.getPosition();

                    if (animalPos.equals(grassPos)){
                        grassPlaces.remove(grass);
                        placeNewGrass();
                        break;
                    }
                }
                this.animals.add(animal);
                return true;
            }
            else return false;
        }
    }

    public boolean placeNewGrass(){
        Random randomGrassPlace = new Random();
        boolean placed = false;

        while (!placed){
            int x = randomGrassPlace.nextInt((int) Math.sqrt(10 * this.numberOfGrass));
            int y = randomGrassPlace.nextInt((int) Math.sqrt(10 * this.numberOfGrass));
            Grass newGrass = new Grass(new Vector2d(x, y));

            if (!isOccupied(newGrass.getPosition())){
                this.grassPlaces.add(newGrass);
                placed = true;
            }
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)){
            return true;
        }

        for (Grass grass: grassPlaces){
            if (grass.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object animalCheck = super.objectAt(position);
        if(animalCheck != null){
            return animalCheck;
        }

        for (Grass grass: grassPlaces){
            if (grass.getPosition().equals(position)){
                return grass;
            }
        }
        return null;
    }
}
