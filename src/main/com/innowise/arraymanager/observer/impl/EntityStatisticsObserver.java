package main.com.innowise.arraymanager.observer.impl;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.exception.EntityException;
import main.com.innowise.arraymanager.observer.EntityObserver;
import main.com.innowise.arraymanager.service.impl.EntityAnalyzerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityStatisticsObserver implements EntityObserver {
    private static final Logger logger = LogManager.getLogger(EntityStatisticsObserver.class);

    @Override
    public void update(Entity entity) {

        EntityAnalyzerImpl minMaxService = new EntityAnalyzerImpl();
        logger.info("Update information about entity obj");
        int sum = minMaxService.sum(entity);
        int findMin;
        int findMax;
        try{
             findMin = minMaxService.findMin(entity);
             findMax = minMaxService.findMax(entity);
        }catch (EntityException e){
            logger.warn("Error entity for finding min or max value");
        }



    }
}
