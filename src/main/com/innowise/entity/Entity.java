package main.com.innowise.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;



public class Entity {

    private static final Logger logger = LogManager.getLogger(Entity.class);

    private int[] array;

   public Entity(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            logger.error("Equals two identical array.");
            return true;
        }

        if (o == null) {
            logger.error("Empty object in equals method.");
            return false;
        }

        if (o.getClass().equals(this.getClass())) {
            Entity arrays = (Entity) o;
            if (this.array.length == arrays.getArray().length) {
                for (int i = 0; i < arrays.getArray().length; i++) {
                    if (this.array[i] != arrays.getArray()[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array) * 31;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}