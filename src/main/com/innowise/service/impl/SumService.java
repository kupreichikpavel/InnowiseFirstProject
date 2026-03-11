package main.com.innowise.service.impl;

import main.com.innowise.entity.Entity;
import main.com.innowise.service.SumInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class SumService implements SumInterface {
    private static final Logger logger = LogManager.getLogger(Entity.class);
    @Override
    public int sum(Entity entity) {
        logger.info("Sum of elements");
        return Arrays.stream(entity.getArray())
                .sum();
    }
}
