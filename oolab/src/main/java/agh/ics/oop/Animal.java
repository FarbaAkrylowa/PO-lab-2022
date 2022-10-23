package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d location = new Vector2d(2, 2);

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getLocation(){
        return location;
    }

    public void setOrientation(MapDirection direction){
        this.orientation = direction;
    }

    public void setLocation(Vector2d loc){
        this.location = loc;
    }

    @Override
    public String toString(){
        MapDirection ort = getOrientation();
        Vector2d loc = getLocation();
        // wypluwa Polnoc bo jest z automatu tam wstawione toString
        return ort + " (" + loc.x + ", " + loc.y + ")";
    }

    public boolean isAt(Vector2d position){
        return this.location.equals(position);
    }

    public void move(MoveDirection direction){
        MapDirection currOrient = this.getOrientation();

        Vector2d currLoc = this.getLocation();
        Vector2d unitVector = currOrient.toUnitVector();
        Vector2d topRight = new Vector2d(4, 4);
        Vector2d bottomLeft = new Vector2d(0, 0);

        switch (direction){
            case RIGHT -> this.setOrientation(currOrient.next());
            case LEFT -> this.setOrientation(currOrient.previous());
            case FORWARD -> {
                currLoc = currLoc.add(unitVector);
                if (currLoc.follows(bottomLeft) && currLoc.precedes(topRight)){
                    this.setLocation(currLoc);
                }
            }
            case BACKWARD -> {
                currLoc = currLoc.add(unitVector.opposite());
                if (currLoc.follows(bottomLeft) && currLoc.precedes(topRight)) {
                    this.setLocation(currLoc);
                }
            }
        }
    }
}
