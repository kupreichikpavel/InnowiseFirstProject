package com.innowise.arraymanager.specification.impl;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.singleton.WareHouse;
import com.innowise.arraymanager.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpecificationByMax implements Specification {
    private static final Logger logger = LogManager.getLogger(SpecificationByMax.class);
    private final int maxValue;

    public SpecificationByMax(int max) {
        this.maxValue = max;
    }

    @Override
    public boolean isSatisfiedBy(Entity entity) {
        logger.info("Specification by max value");
        var params = WareHouse.getInstance().get(entity.getId());
        return params.getMax() < maxValue;
    }
}