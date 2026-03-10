package service.impl;

import entity.Entity;
import exception.EntityException;
import service.FindingMinMaxValueInterface;

import java.util.Arrays;


public class MinMaxService implements FindingMinMaxValueInterface {

    @Override
    public int findMin(Entity entity) {
        return Arrays.stream(entity.getArray())
                .min()
                .orElseThrow(() -> new EntityException("Cant find min value"));
    }

    @Override
    public int findMax(Entity entity) {
        return Arrays.stream(entity.getArray())
                .max()
                .orElseThrow(() -> new EntityException("Cant find max value"));
    }

}
