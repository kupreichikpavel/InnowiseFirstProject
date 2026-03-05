package service;

import entity.Entity;
import interfacesForArray.SumInterface;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class SumService implements SumInterface {
    @Override
    public int sum(Entity array) {
        int[] arr = array.getArray();
        return Arrays.stream(array.getArray())
                .sum();
    }
}
