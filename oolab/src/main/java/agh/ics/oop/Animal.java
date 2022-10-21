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
        Vector2d curr_loc = this.getLocation();
        MapDirection curr_orient = this.getOrientation();

        if (direction.equals(MoveDirection.RIGHT)){
            switch (curr_orient){
                case NORTH -> this.setOrientation(MapDirection.EAST);
                case WEST -> this.setOrientation(MapDirection.SOUTH);
                case SOUTH -> this.setOrientation(MapDirection.WEST);
                case EAST -> this.setOrientation(MapDirection.NORTH);
            }
        } else if (direction.equals(MoveDirection.LEFT)) {
            switch (curr_orient) {
                case NORTH -> this.setOrientation(MapDirection.WEST);
                case WEST -> this.setOrientation(MapDirection.NORTH);
                case SOUTH -> this.setOrientation(MapDirection.EAST);
                case EAST -> this.setOrientation(MapDirection.SOUTH);
            }
        }else if (direction.equals(MoveDirection.FORWARD)) {
            switch (curr_orient){
                case NORTH:
                    if (curr_loc.y + 1 <= 4){
                        this.setLocation(new Vector2d(curr_loc.x, curr_loc.y + 1));
                    }
                    break;
                case WEST:
                    if (curr_loc.x - 1 >= 0){
                        this.setLocation(new Vector2d(curr_loc.x - 1, curr_loc.y));
                    }
                    break;
                case SOUTH:
                    if (curr_loc.y - 1 >= 0){
                        this.setLocation(new Vector2d(curr_loc.x, curr_loc.y - 1));
                    }
                    break;
                case EAST:
                    if (curr_loc.x + 1 <= 4){
                        this.setLocation(new Vector2d(curr_loc.x + 1, curr_loc.y));
                    }
                    break;
            }
        }else {
                switch (curr_orient){
                    case NORTH:
                        if (curr_loc.y - 1 >= 0){
                            this.setLocation(new Vector2d(curr_loc.x, curr_loc.y - 1));
                        }
                        break;
                    case WEST:
                        if (curr_loc.x + 1 <= 4){
                            this.setLocation(new Vector2d(curr_loc.x + 1, curr_loc.y));
                        }
                        break;
                    case SOUTH:
                        if (curr_loc.y + 1 <= 4){
                            this.setLocation(new Vector2d(curr_loc.x, curr_loc.y + 1));
                        }
                        break;
                    case EAST:
                        if (curr_loc.x - 1 >= 0){
                            this.setLocation(new Vector2d(curr_loc.x - 1, curr_loc.y));
                        }
                        break;
                }
            }

    }
}
