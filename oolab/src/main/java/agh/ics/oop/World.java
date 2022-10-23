package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main(String[] args){
        Animal kerfus = new Animal();
        OptionsParser moveControl = new OptionsParser();
        MoveDirection[] animalMoves = moveControl.parse(args);

        System.out.println("Kerfuś zaraz wyruszy!");
        System.out.println("=======================");
        for (MoveDirection move: animalMoves){
            System.out.println("Before move: " + kerfus);
            System.out.println("Current move: " + move);
            kerfus.move(move);
            System.out.println("After move: " + kerfus);
            System.out.println("=======================");
        }
        /*
            Pojawienie się dwóch zwierząt w jednym miejscu - mój pomysł:
            Tworzymy sobie tablice 2D wielkości naszej mapy typu boolean - [i][j] = true jeśli stoi tam zwierz wpp. false
            W metodzie move klasy Animal dodajemy odpowiedni warunek na sprawdzenie czy jakies zwierze nie siedzi na danym
            polu na ktore chcemy przejsc.
            Jeśli mozna prejsc to aktualną pozycję w tablicy oznaczamy jako false, a pole na ktore przeszliśmy ustawiamy
            na true.
        */
    }

    public static void convert(String[] args, Direction[] moves){
        int arrLen = args.length;
        for(int i = 0; i < arrLen; i++){
            switch (args[i]){
                case "f" -> moves[i] = Direction.FORWARD;
                case "b" -> moves[i] = Direction.BACKWARD;
                case "l" -> moves[i] = Direction.LEFT;
                case "r" -> moves[i] = Direction.RIGHT;
                default -> moves[i] = Direction.NONE;
            }
        }
    }

    public static void run(Direction[] moves){
        for (Direction move : moves) {
            switch (move) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
            }
        }
    }
}
