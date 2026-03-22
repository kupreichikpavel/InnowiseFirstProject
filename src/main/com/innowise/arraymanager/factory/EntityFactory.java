package com.innowise.arraymanager.factory;

import com.innowise.arraymanager.entity.Entity;

public interface EntityFactory {
    Entity createEntity(int[] array);

    Entity createEmptyEntity();

}
