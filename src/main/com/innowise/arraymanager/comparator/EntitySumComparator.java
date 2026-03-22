package com.innowise.arraymanager.comparator;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.singleton.WareHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class EntitySumComparator implements Comparator<Entity> {
    private static final Logger logger = LogManager.getLogger(EntitySumComparator.class);

    @Override
    public int compare(Entity first, Entity second) {
        logger.info("EntitySumComparator compare numbers");
        int firstSum = WareHouse.getInstance().get(first.getId()).getSum();
        int secondSum = WareHouse.getInstance().get(second.getId()).getSum();

        return Integer.compare(firstSum, secondSum);
    }
}

