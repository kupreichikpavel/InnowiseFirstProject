package main.com.innowise.service.impl;

import main.com.innowise.entity.Entity;
import main.com.innowise.exception.EntityException;
import main.com.innowise.service.EntityCalculationInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityCalculationService implements EntityCalculationInterface {
    private final int sum;
    private final int average;
    private final int min;
    private final int max;
    private static final Logger logger = LogManager.getLogger(EntityCalculationService.class);
    private AverageService averageService = new AverageService();
    private MinMaxService minMaxService = new MinMaxService();
    private SumService sumService = new SumService();

    public EntityCalculationService(int sum, int average, int min, int max) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    @Override
    public void calculation(Entity entity) {
        int averageNum = averageService.findAverageElement(entity);
        int sumValue = sumService.sum(entity);
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
