package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString(){
        switch (this){
            case NORTH: return "Polnoc";
            case EAST: return "Wschod";
            case SOUTH: return "Poludnie";
            case WEST: return "Zachod";
            default: return "Wrong data";
        }
    }

    public MapDirection previous(){
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            default -> NORTH;
        };
    }

    public MapDirection next(){
        return switch (this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            default -> SOUTH;
        };
    }

    public Vector2d toUnitVector(){
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            default -> new Vector2d(1, 0);
        };
    }
}
