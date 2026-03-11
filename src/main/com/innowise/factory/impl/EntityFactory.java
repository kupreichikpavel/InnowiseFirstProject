package main.com.innowise.factory.impl;

import main.com.innowise.Main;
import main.com.innowise.entity.Entity;
import main.com.innowise.factory.EntityFactoryInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityFactory implements EntityFactoryInterface {
    private static final Logger logger = LogManager.getLogger(EntityFactory.class);

    @Override
    public Entity createEntity(int[] array) {
        logger.info("Create new Entity");
        return new Entity(array);
    }

    @Override
    public Entity createEmptyEntity() {
        logger.info("Create empty Entity");
        return new Entity(new int[0]);
    }

}
