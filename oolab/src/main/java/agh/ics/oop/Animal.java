package agh.ics.oop;

public class Animal {
    private MapDirection orientation;
    private Vector2d location;
    private final IWorldMap map;

    public Animal(IWorldMap map){
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.location = initialPosition;
        this.orientation = MapDirection.NORTH;
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

    public void move(MoveDirection direction){
        MapDirection currOrient = this.orientation;

        Vector2d newLocation = this.location;
        Vector2d unitVector = currOrient.toUnitVector();
        switch (direction){
            case RIGHT -> this.orientation = currOrient.next();
            case LEFT -> this.orientation = currOrient.previous();
            case FORWARD -> {
                newLocation = newLocation.add(unitVector);
                if (this.map.canMoveTo(newLocation)){
                    this.location = newLocation;
                }
            }
            case BACKWARD -> {
                newLocation = newLocation.add(unitVector.opposite());
                if (this.map.canMoveTo(newLocation)) {
                    this.location = newLocation;
                }
            }
        }
    }
}
