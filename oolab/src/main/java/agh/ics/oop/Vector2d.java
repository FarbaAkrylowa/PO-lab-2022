package agh.ics.oop;

public class Vector2d {
        final public int x;
        final public int y;

        public Vector2d(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "0";
        }

        public boolean precedes(Vector2d other){
            return this.x <= other.x && this.y <= other.y;
        }

        public boolean follows(Vector2d other){
            return this.x >= other.x && this.y >= other.y;
        }

        public Vector2d add(Vector2d other){
            // wszystko fajnie ale tu mamy tylko lokalnie stworzony ten nowy Vector2d
            // Vector2d new_vector = new Vector2d(this.x + other.x, this.y + other.y);
            return new Vector2d(this.x + other.x, this.y + other.y);
        }

        public Vector2d subtract(Vector2d other){
            return new Vector2d(this.x - other.x, this.y - other.y);
        }

        public Vector2d upperRight(Vector2d other){
//            int a = Math.max(this.x, other.x);
//            int b = Math.max(this.y, other.y);
            return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
        }

        public Vector2d lowerLeft(Vector2d other){
//            int a = Math.min(this.x, other.x);
//            int b = Math.min(this.y, other.y);
            return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
        }

        public Vector2d opposite(){
            return new Vector2d(-this.x, -this.y);
        }

        public boolean equals(Object other){
            return true;
        }
}
