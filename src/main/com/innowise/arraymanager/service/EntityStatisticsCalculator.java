package com.innowise.arraymanager.service;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.exception.EntityException;
import com.innowise.arraymanager.singleton.EntityParameters;

public interface EntityStatisticsCalculator {
    EntityParameters calculate(Entity entity) throws EntityException;
}
