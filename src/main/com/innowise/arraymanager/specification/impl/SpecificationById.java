package com.innowise.arraymanager.specification.impl;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpecificationById implements Specification {
    private static final Logger logger = LogManager.getLogger(SpecificationById.class);
    private final int valueId;

    public SpecificationById(int id) {
        this.valueId = id;
    }

    @Override
    public boolean isSatisfiedBy(Entity entity) {
        logger.info("Specification by equal id");
        return entity.getId() == valueId;
    }
}
