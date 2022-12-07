package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class Animal implements IMapElement {
    private MapDirection orientation;
    private Vector2d location;
    private final IWorldMap map;
    private final List<IPositionChangedObserver> observers;

    public Animal(IWorldMap map){
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.location = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.observers = new LinkedList<>();
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getLocation(){
        return location;
    }

    @Override
    public String toString(){
        return switch (this.orientation){
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public boolean isAt(Vector2d position){
        return this.location.equals(position);
    }

    public void addObserver(IPositionChangedObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangedObserver observer){
        this.observers.remove(observer);
    }

    public void positionChangedA(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangedObserver obs: this.observers){
            obs.positionChanged(oldPosition, newPosition);
        }
    }
    public void move(MoveDirection direction){
        MapDirection currOrient = this.orientation;

        Vector2d newLocation = this.location;
        Vector2d oldPos = this.location;
        Vector2d unitVector = currOrient.toUnitVector();
        switch (direction){
            case RIGHT -> this.orientation = currOrient.next();
            case LEFT -> this.orientation = currOrient.previous();
            case FORWARD -> {
                newLocation = newLocation.add(unitVector);
                if (this.map.canMoveTo(newLocation)){
                    this.location = newLocation;
                }
                positionChangedA(oldPos, this.location);
            }
            case BACKWARD -> {
                newLocation = newLocation.add(unitVector.opposite());
                if (this.map.canMoveTo(newLocation)) {
                    this.location = newLocation;
                }
                positionChangedA(oldPos, this.location);
            }
        }
    }

    @Override
    public String getImagePath() {
        return switch (this.orientation){
            case EAST -> "src/main/resources/right.png";
            case WEST -> "src/main/resources/left.png";
            case NORTH -> "src/main/resources/up.png";
            case SOUTH -> "src/main/resources/down.png";
        };
    }
}
