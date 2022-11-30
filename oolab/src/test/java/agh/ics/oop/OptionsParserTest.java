package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    MoveDirection f = MoveDirection.FORWARD, b = MoveDirection.BACKWARD;
    MoveDirection r = MoveDirection.RIGHT, l = MoveDirection.LEFT;
    String[] movesToTest1 = {"b", "right", "forward", "r", "f", "f", "right", "f", "f", "r", "forward",
            "f", "f", "left", "f", "f", "r", "f", "right", "forward", "left",
            "f", "r", "f", "r", "f"};
    String[] movesToTest2 = {"b", "right", "forward", "f l rb", "r", "f", "f", "right", "f", "f", "z", "c", "r", "forward",
            "f", "f", "left", "f", "f", "r", "f", "right", "forward", "left",
            "hj", "lf", "f", "sds", "r", "f", "r", "f", "v"};

    @Test
    void parseRightCasesTest(){
        MoveDirection[] answers = {b, r, f, r, f, f, r, f, f, r, f, f, f, l, f, f, r, f, r, f, l, f, r, f, r, f};

        OptionsParser parserTest = new OptionsParser();
        MoveDirection[] convertedMovesToTest = parserTest.parse(movesToTest1);

        assertArrayEquals(answers, convertedMovesToTest);
    }

    @Test
    void parseExceptionTest(){
        try{
            OptionsParser parserExceptTest = new OptionsParser();
            MoveDirection[] convertedMoves = parserExceptTest.parse(movesToTest2);
        } catch (IllegalArgumentException exception){
            assertEquals("f l rb is invalid move specification!", exception.getMessage());
        }
    }
}
