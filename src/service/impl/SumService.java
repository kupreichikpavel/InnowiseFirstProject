package service.impl;

import entity.Entity;
import service.SumInterface;

import java.util.Arrays;


public class SumService implements SumInterface {
    @Override
    public int sum(Entity entity) {
        return Arrays.stream(entity.getArray())
                .sum();
    }
}
