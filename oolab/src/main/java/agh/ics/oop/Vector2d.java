package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
        final public int x;
        final public int y;

        public Vector2d(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return "(" + this.x + ", " + this.y + ")";
        }

        public boolean precedes(Vector2d other){
            return this.x <= other.x && this.y <= other.y;
        }

        public boolean follows(Vector2d other){
            return this.x >= other.x && this.y >= other.y;
        }

        public Vector2d add(Vector2d other){
            return new Vector2d(this.x + other.x, this.y + other.y);
        }

        public Vector2d subtract(Vector2d other){
            return new Vector2d(this.x - other.x, this.y - other.y);
        }

        public Vector2d upperRight(Vector2d other){
            int a = Math.max(this.x, other.x);
            int b = Math.max(this.y, other.y);
            return new Vector2d(a, b);
        }

        public Vector2d lowerLeft(Vector2d other){
            int a = Math.min(this.x, other.x);
            int b = Math.min(this.y, other.y);
            return new Vector2d(a, b);
        }

        public Vector2d opposite(){
            return new Vector2d(-this.x, -this.y);
        }

        @Override
        public boolean equals(Object other){
            if (this == other){
                return true;
            }
            if (!(other instanceof Vector2d)){
                return false;
            }
            Vector2d that = (Vector2d) other;

            // return that.x == this.x && that.y == this.y;
            return Integer.compare(that.x, this.x) == 0 && Integer.compare(that.y, this.y) == 0;
        }

        @Override
        public int hashCode(){
            // stackoverflow <3
            int hash = Math.max(x, y);
            hash = (hash >> 16) | (hash >>> 16);
            hash = hash ^ Math.min(x, y);
            return hash;
        }
}
