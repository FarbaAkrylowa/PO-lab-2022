package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private final Vector2d lowerLeftCorner;
    private final Vector2d upperRightCorner;


    public RectangularMap(int width, int height){
        this.animals = new ArrayList<>();
        this.lowerLeftCorner = new Vector2d(0, 0);
        this.upperRightCorner = new Vector2d(width, height);
    }

    @Override
    protected Vector2d getUpperRight() {
        return this.upperRightCorner;
    }

    @Override
    protected Vector2d getLowerLeft() {
        return this.lowerLeftCorner;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeftCorner) && position.precedes(upperRightCorner) && super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }
}
