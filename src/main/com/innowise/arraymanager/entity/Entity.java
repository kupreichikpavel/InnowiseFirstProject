package main.com.innowise.arraymanager.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;


public class Entity {

    private static final Logger logger = LogManager.getLogger(Entity.class);
    private int[] array;
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id;

    public Entity(int[] array) {
        this.id = counter.incrementAndGet();
        this.array = array;
    }

    public int getId() {
        return id;
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
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
            int[] entityArray = arrays.getArray();

            if (this.id != arrays.id) {
                return false;
            }
            if (this.array.length == entityArray.length) {
                for (int i = 0; i < entityArray.length; i++) {
                    if (this.array[i] != entityArray[i]) {
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
        return Arrays.hashCode(array) * 31 + id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entity{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}