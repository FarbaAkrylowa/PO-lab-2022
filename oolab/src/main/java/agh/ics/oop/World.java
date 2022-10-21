package agh.ics.oop;


import java.util.Arrays;

public class World {
    public static void main(String[] args){
//        System.out.println("Start");
//        Direction[] moves = new Direction[100];
//        int arrLen = args.length;
//
//        convert(args, moves);
//        run(Arrays.copyOfRange(moves, 0, arrLen));
//        System.out.println("Stop");
//        System.out.println();
//
//        System.out.println("Lab 2");
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//        System.out.println();

        Animal kerfus = new Animal();
        System.out.println(kerfus);
        MoveDirection[] moveset = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        for (MoveDirection go: moveset){
            kerfus.move(go);
            System.out.println(kerfus);
        }

        OptionsParser control = new OptionsParser();
        MoveDirection[] animalMoves = control.parse(args);

        for (MoveDirection move: animalMoves){
            System.out.println(move);
        }
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
                default -> System.out.print("");
            }
        }
        //        int arr_len = moves.length;
//        for(int i = 0; i < arr_len; i++){
//            switch (moves[i]) {
//                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
//                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
//                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
//                case LEFT -> System.out.println("Zwierzak skreca w lewo");
//                default -> System.out.print("");
//            }
//        }
    }
}
