package main.com.innowise.arraymanager.factory;

import main.com.innowise.arraymanager.entity.Entity;

public interface EntityFactory {
    Entity createEntity(int[] array);

    Entity createEmptyEntity();

}
