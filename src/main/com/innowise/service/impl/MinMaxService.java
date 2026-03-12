package main.com.innowise.service.impl;

import main.com.innowise.entity.Entity;
import main.com.innowise.exception.EntityException;
import main.com.innowise.factory.impl.EntityFactory;
import main.com.innowise.service.FindingMinMaxValueInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class MinMaxService implements FindingMinMaxValueInterface {
    private static final Logger logger = LogManager.getLogger(EntityFactory.class);

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

}
