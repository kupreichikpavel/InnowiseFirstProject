package main.com.innowise.arraymanager.observer.impl;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;
import main.com.innowise.arraymanager.observer.EntityObserver;
import main.com.innowise.arraymanager.service.EntityStatisticsCalculator;
import main.com.innowise.arraymanager.service.impl.EntityStatisticsCalculatorImpl;
import main.com.innowise.arraymanager.singleton.EntityParameters;
import main.com.innowise.arraymanager.singleton.WareHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityStatisticsObserver implements EntityObserver {

    private static final Logger logger = LogManager.getLogger(EntityStatisticsObserver.class);
    private final EntityStatisticsCalculator statisticsCalculator = new EntityStatisticsCalculatorImpl();

    @Override
    public void update(Entity entity) {
        logger.info("Update statistics");
        try {
            EntityParameters parameters = statisticsCalculator.calculate(entity);
            WareHouse wareHouse = WareHouse.getInstance();
            wareHouse.put(entity.getId(), parameters);
        } catch (EntityException e) {
            logger.warn("Failed to update statistics for entity id={}", entity.getId());
        }

    }

}
