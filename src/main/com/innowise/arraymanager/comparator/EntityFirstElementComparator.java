package com.innowise.arraymanager.comparator;

import com.innowise.arraymanager.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class EntityFirstElementComparator implements Comparator<Entity> {
    private static final Logger logger = LogManager.getLogger(EntityFirstElementComparator.class);

    @Override
    public int compare(Entity first, Entity second) {
        logger.info("Comparing first entity element id");
        return Integer.compare(first.getArray()[0], second.getArray()[0]);
    }
}
