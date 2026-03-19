package main.com.innowise.arraymanager.service;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;
import main.com.innowise.arraymanager.singleton.EntityParameters;

public interface EntityStatisticsCalculator {
    EntityParameters calculate(Entity entity) throws EntityException;
}
