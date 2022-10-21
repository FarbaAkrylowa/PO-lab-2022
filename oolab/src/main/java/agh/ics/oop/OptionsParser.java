package agh.ics.oop;
import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse(String[] moves){
        MoveDirection[] convertedMoves = new MoveDirection[100];
        int counter = 0, currId = 0, movesLen = moves.length;

        for (String move : moves) {
            switch (move) {
                case "f", "forward" -> {
                    convertedMoves[currId] = MoveDirection.FORWARD;
                    currId += 1;
                }
                case "b", "backward" -> {
                    convertedMoves[currId] = MoveDirection.BACKWARD;
                    currId += 1;
                }
                case "r", "right" -> {
                    convertedMoves[currId] = MoveDirection.RIGHT;
                    currId += 1;
                }
                case "l", "left" -> {
                    convertedMoves[currId] = MoveDirection.LEFT;
                    currId += 1;
                }
            }
        }

        return Arrays.copyOfRange(convertedMoves, 0, currId);
    }
}
