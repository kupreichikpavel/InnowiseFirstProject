package main.com.innowise.arraymanager.specification.impl;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.singleton.WareHouse;
import main.com.innowise.arraymanager.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpecificationBySumGreaterThan implements Specification {
    private static final Logger logger = LogManager.getLogger(SpecificationBySumGreaterThan.class);
    private final int sum;

    public SpecificationBySumGreaterThan(int value) {
        this.sum = value;
    }

    @Override
    public boolean isSatisfiedBy(Entity entity) {
        logger.info("Specification by sum greater than  value");
        var params = WareHouse.getInstance().get(entity.getId());
        return params.getSum() < sum;
    }
}