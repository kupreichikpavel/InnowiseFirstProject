package entity;

import java.util.Arrays;

public class Entity {
    private int[] array;
    private int id;

    public Entity(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
