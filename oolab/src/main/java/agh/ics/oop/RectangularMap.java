package agh.ics.oop;
import java.util.ArrayList;
import java.util.HashMap;

public class RectangularMap extends AbstractWorldMap{
    private final Vector2d lowerLeftCorner;
    private final Vector2d upperRightCorner;


    public RectangularMap(int width, int height){
        this.animals = new HashMap<>();
        this.lowerLeftCorner = new Vector2d(0, 0);
        this.upperRightCorner = new Vector2d(width, height);
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if (super.place(animal)){
            return true;
        }

        throw new IllegalArgumentException(animal.getLocation() + " is invalid animal placement!");
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
    public int getMinX() {
        return this.lowerLeftCorner.getX();
    }

    @Override
    public int getMinY() {
        return this.lowerLeftCorner.getY();
    }

    @Override
    public int getMaxX() {
        return this.upperRightCorner.getX();
    }

    @Override
    public int getMaxY() {
        return this.getUpperRight().getY();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeftCorner) && position.precedes(upperRightCorner) && super.canMoveTo(position);
    }
}
