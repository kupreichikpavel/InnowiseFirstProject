package main.com.innowise.arraymanager.service;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;

public interface EntityAnalyzer {
    int findMin(Entity entity) throws EntityException;

    int findMax(Entity entity) throws EntityException;

    int sum(Entity entity);
}

