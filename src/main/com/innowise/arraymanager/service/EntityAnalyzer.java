package com.innowise.arraymanager.service;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.exception.EntityException;

public interface EntityAnalyzer {
    int findMin(Entity entity) throws EntityException;

    int findMax(Entity entity) throws EntityException;

    int sum(Entity entity);
}

