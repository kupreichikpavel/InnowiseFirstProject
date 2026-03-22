package com.innowise.arraymanager.comparator;


import com.innowise.arraymanager.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class EntityIdComparator implements Comparator<Entity> {
    private static final Logger logger = LogManager.getLogger(EntityIdComparator.class);

    @Override
    public int compare(Entity first, Entity second) {
        logger.info("Comparing entity IDs");
        return Integer.compare(first.getId(), second.getId());
    }
}