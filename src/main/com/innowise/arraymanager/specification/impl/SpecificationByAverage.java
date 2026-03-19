package main.com.innowise.arraymanager.specification.impl;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.singleton.WareHouse;
import main.com.innowise.arraymanager.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpecificationByAverage implements Specification {
    private static final Logger logger = LogManager.getLogger(SpecificationByAverage.class);
    private final int averageValue;

    public SpecificationByAverage(int average) {
        this.averageValue = average;
    }

    @Override
    public boolean isSatisfiedBy(Entity entity) {
        logger.info("Specification by average num");
        var params = WareHouse.getInstance().get(entity.getId());
        return params.getAverage() < averageValue;
    }
}

