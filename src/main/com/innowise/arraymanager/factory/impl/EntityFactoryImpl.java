package main.com.innowise.arraymanager.factory.impl;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.factory.EntityFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityFactoryImpl implements EntityFactory {
    private static final Logger logger = LogManager.getLogger(EntityFactoryImpl.class);

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
