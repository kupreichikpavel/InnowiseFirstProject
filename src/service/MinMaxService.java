package service;

import entity.Entity;
import interfacesForArray.MinMaxInterface;

import java.util.Arrays;

public class MinMaxService implements MinMaxInterface {

    @Override
    public int findMin(Entity array) {
        int[] arr = array.getArray();
        return Arrays.stream(array.getArray())
                .min()
                .orElseThrow();
    }

    @Override
    public int findMax(Entity array) {
        return Arrays.stream(array.getArray())
                .max()
                .orElseThrow();
    }

}
