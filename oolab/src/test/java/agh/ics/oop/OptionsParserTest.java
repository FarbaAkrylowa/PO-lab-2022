package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    void parseTest(){
        String[] movesToTest = {"b", "right", "forward", "f l rb", "r", "f", "f", "right", "f", "f", "z", "c", "r", "forward",
                "f", "f", "left", "f", "f", "r", "f", "right", "forward", "left",
                "hj", "lf", "f", "sds", "r", "f", "r", "f", "v"};
        MoveDirection f = MoveDirection.FORWARD, b = MoveDirection.BACKWARD;
        MoveDirection r = MoveDirection.RIGHT, l = MoveDirection.LEFT;
        MoveDirection[] answers = {b, r, f, r, f, f, r, f, f, r, f, f, f, l, f, f, r, f, r, f, l, f, r, f, r, f};

        OptionsParser parserTest = new OptionsParser();
        MoveDirection[] convertedMovesToTest = parserTest.parse(movesToTest);

        assertArrayEquals(answers, convertedMovesToTest);
    }
}
