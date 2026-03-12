package main.com.innowise.service;

import main.com.innowise.entity.Entity;
import main.com.innowise.exception.EntityException;

public interface FindingMinMaxValueInterface {
    int findMin(Entity entity) throws EntityException;

    int findMax(Entity entity) throws EntityException;
}

