package main.com.innowise.arraymanager.service.impl;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;
import main.com.innowise.arraymanager.service.EntityStatisticsCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityStatisticsCalculatorImpl implements EntityStatisticsCalculator {
    private final int sum;
    private final int average;
    private final int min;
    private final int max;
    private static final Logger logger = LogManager.getLogger(EntityStatisticsCalculatorImpl.class);
    private final AverageCalculatorImpl averageService = new AverageCalculatorImpl();
    private final EntityAnalyzerImpl minMaxService = new EntityAnalyzerImpl();

    public EntityStatisticsCalculatorImpl(int sum, int average, int min, int max) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    @Override
    public void calculation(Entity entity) {
        int averageNum = averageService.findAverageElement(entity);
        int sumValue = minMaxService.sum(entity);
        int maxValue;
        int minValue;
        try {
            maxValue = minMaxService.findMax(entity);
            minValue = minMaxService.findMin(entity);
        } catch (EntityException e) {
            logger.warn("Entity exception in minMaxService" + e);
        }


    }
}
