package agh.ics.oop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsParser {
    public MoveDirection[] parse(String[] moves){
        List<MoveDirection> convertedMoves = new ArrayList<>();
        for (String move: moves){
            switch (move){
                case "f", "forward" -> convertedMoves.add(MoveDirection.FORWARD);
                case "b", "backward" -> convertedMoves.add(MoveDirection.BACKWARD);
                case "l", "left" -> convertedMoves.add(MoveDirection.LEFT);
                case "r", "right" -> convertedMoves.add(MoveDirection.RIGHT);
            }
        }

        MoveDirection[] newMoves = new MoveDirection[convertedMoves.size()];
        convertedMoves.toArray(newMoves);
        return newMoves;
    }
}
