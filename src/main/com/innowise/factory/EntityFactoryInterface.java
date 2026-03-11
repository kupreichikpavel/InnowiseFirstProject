package main.com.innowise.factory;

import main.com.innowise.entity.Entity;

public interface EntityFactoryInterface {
    Entity createEntity(int[] array);

    Entity createEmptyEntity();

}
