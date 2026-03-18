package main.com.innowise.arraymanager.service.impl;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.service.AverageCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AverageCalculatorImpl implements AverageCalculator {
    private static final Logger logger = LogManager.getLogger(AverageCalculatorImpl.class);

    @Override
    public int findAverageElement(Entity entity) {
        logger.info("Finding average element in array");
        if (entity.getArray().length == 0) {
            return 0;
        }
        int averageElement = 0;
        for (int i = 0; i < entity.getArray().length; i++) {
            averageElement += entity.getArray()[i];
        }
        averageElement = averageElement / entity.getArray().length;
        return averageElement;
    }
}
