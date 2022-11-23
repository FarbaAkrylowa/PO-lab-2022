package agh.ics.oop;

public interface IPositionChangedObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
