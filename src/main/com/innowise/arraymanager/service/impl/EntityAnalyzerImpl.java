package com.innowise.arraymanager.service.impl;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.exception.EntityException;
import com.innowise.arraymanager.factory.impl.EntityFactoryImpl;
import com.innowise.arraymanager.service.EntityAnalyzer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class EntityAnalyzerImpl implements EntityAnalyzer {
    private static final Logger logger = LogManager.getLogger(EntityFactoryImpl.class);

    @Override
    public int findMin(Entity entity) throws EntityException {
        logger.info("Finding min value");
        return Arrays.stream(entity.getArray())
                .min()
                .orElseThrow(() -> new EntityException("Cant find min value"));
    }

    @Override
    public int findMax(Entity entity) throws EntityException {
        logger.info("Finding max value");
        return Arrays.stream(entity.getArray())
                .max()
                .orElseThrow(() -> new EntityException("Cant find max value"));
    }
    @Override
    public int sum(Entity entity) {
        logger.info("Sum of elements");
        return Arrays.stream(entity.getArray())
                .sum();
    }

}
