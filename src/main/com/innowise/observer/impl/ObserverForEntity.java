package main.com.innowise.observer.impl;

import main.com.innowise.entity.Entity;
import main.com.innowise.exception.EntityException;
import main.com.innowise.observer.ObserverInterface;
import main.com.innowise.service.impl.MinMaxService;
import main.com.innowise.service.impl.SumService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObserverForEntity implements ObserverInterface {
    private static final Logger logger = LogManager.getLogger(ObserverForEntity.class);

    @Override
    public void update(Entity entity) {
        SumService sumService = new SumService();
        MinMaxService minMaxService = new MinMaxService();
        logger.info("Update information about entity obj");
        int sum = sumService.sum(entity);
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
