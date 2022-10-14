package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(MapDirection dir){
        return "s";
    }

    public MapDirection next(MapDirection dir){
        return EAST;
    }

    public MapDirection previous(MapDirection dir){
        return EAST;
    }

    public Vector2d toUnitVector(MapDirection dir){
        return new Vector2d(0, 0);
    }
}
