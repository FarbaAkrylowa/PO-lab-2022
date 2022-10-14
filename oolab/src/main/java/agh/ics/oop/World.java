package agh.ics.oop;


public class World {
    public static void main(String[] args){
        System.out.println("Start");
        Direction[] moves = new Direction[100];
        int arr_len = args.length;

        convert(args, moves, arr_len);
        run(moves, arr_len);
        System.out.println("Stop");
        System.out.println();


    }

    public static void convert(String[] args, Direction[] moves, int arr_len){
        // niestety nie znalazlem zadnego innego sposobu na zamiane typu naszych argumentow na enum niz
        // stworzenie nowej tablicy typu enum z naszego zadania i zapisanie do niej odpowiednich enumow
        // zauwazylem opcje uzycia interfacu stream, ale niestety nie udalo mi sie wprowadzic go do mojego kodu
        for(int i = 0; i < arr_len; i++){
            switch (args[i]){
                case "f" -> moves[i] = Direction.FORWARD;
                case "b" -> moves[i] = Direction.BACKWARD;
                case "l" -> moves[i] = Direction.LEFT;
                case "r" -> moves[i] = Direction.RIGHT;
                default -> moves[i] = Direction.NONE;
            }
        }
    }

    public static void run(Direction[] moves, int arr_len){
//        Ten fragment kodu był jednym z podpunktow laboratorium, jednak w następnych nasze wyjście miało wyglądać
//        nieco inaczej, dlatego też je zakomentowałem
//        System.out.println("Zwierzak idzie do przodu");
//        for(int i = 0; i < arr_len; i++){
//            if(i != arr_len - 1){
//                System.out.print(moves[i] + ", ");
//            }
//            else {
//                System.out.println(moves[i]);
//            }
//        }

        for(int i = 0; i < arr_len; i++){
            switch (moves[i]) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
                default -> System.out.println("Nieznana komenda");
            }
        }
    }
}
