package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangedObserver{
    private final TreeSet<Vector2d> orderX = new TreeSet<>(Comparator.comparing(Vector2d::getX));
    private final TreeSet<Vector2d> orderY = new TreeSet<>(Comparator.comparing(Vector2d::getY));

    public void addPosition(Vector2d position){
        this.orderX.add(position);
        this.orderY.add(position);
    }
    public void removePosition(Vector2d position) {
        this.orderX.remove(position);
        this.orderY.remove(position);
    }

    public Vector2d getLowLeft(){
        return this.orderX.first().lowerLeft(orderY.first());
    }

    public Vector2d getUpRight(){
        return this.orderX.last().upperRight(orderY.last());
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        this.orderX.remove(oldPosition);
        this.orderX.add(newPosition);

        this.orderY.remove(oldPosition);
        this.orderY.add(newPosition);
    }
}
