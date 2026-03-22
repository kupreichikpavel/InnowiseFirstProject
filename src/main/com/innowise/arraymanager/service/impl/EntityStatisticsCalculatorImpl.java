package com.innowise.arraymanager.service.impl;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.exception.EntityException;
import com.innowise.arraymanager.service.EntityStatisticsCalculator;
import com.innowise.arraymanager.singleton.EntityParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityStatisticsCalculatorImpl implements EntityStatisticsCalculator {

    private static final Logger logger = LogManager.getLogger(EntityStatisticsCalculatorImpl.class);
    private final AverageCalculatorImpl averageService = new AverageCalculatorImpl();
    private final EntityAnalyzerImpl service = new EntityAnalyzerImpl();


    @Override
    public EntityParameters calculate(Entity entity) throws EntityException {
        logger.info("Calculation EntityParameters");
        int averageNum = averageService.findAverageElement(entity);
        int sumValue = service.sum(entity);
        int maxValue = service.findMax(entity);
        int minValue = service.findMin(entity);
        return new EntityParameters(sumValue, minValue, maxValue, averageNum);
    }
}
