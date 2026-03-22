package com.innowise.arraymanager.specification.impl;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.singleton.WareHouse;
import com.innowise.arraymanager.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpecificationByMin implements Specification {
    private final int minValue;
    private static final Logger logger = LogManager.getLogger(SpecificationByMin.class);

    public SpecificationByMin(int min) {
        this.minValue = min;
    }
    @Override
    public boolean isSatisfiedBy(Entity entity) {
        logger.info("Specification by min value");
        var params = WareHouse.getInstance().get(entity.getId());
        return params.getMin() > minValue;
    }
}
