package main.com.innowise.service;

import main.com.innowise.entity.Entity;

public interface FindingMinMaxValueInterface {
    int findMin(Entity entity);

    int findMax(Entity entity);
}

