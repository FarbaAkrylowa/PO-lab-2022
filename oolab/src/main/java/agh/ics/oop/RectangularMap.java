package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private final Vector2d lowerLeftCorner;
    private final Vector2d upperRightCorner;
//    private static final List<Animal> animals = new ArrayList<>();
    private final List<Animal> animals = new ArrayList<>();
    private final MapVisualizer visualizeMap;


    public RectangularMap(int width, int height){
        this.lowerLeftCorner = new Vector2d(0, 0);
        this.upperRightCorner = new Vector2d(width, height);
        this.visualizeMap = new MapVisualizer(this);
    }

    public Vector2d getLowerLeft(){
        return this.lowerLeftCorner;
    }

    public Vector2d getUpperRight(){
        return this.upperRightCorner;
    }

    @Override
    public String toString(){
        return visualizeMap.draw(this.lowerLeftCorner, this.upperRightCorner);
    }

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
        for (Animal animal: this.animals){
            if (animal.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: this.animals){
            if (animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }
}
