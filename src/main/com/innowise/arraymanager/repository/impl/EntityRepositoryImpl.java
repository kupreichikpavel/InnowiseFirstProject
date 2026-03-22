package com.innowise.arraymanager.repository.impl;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.exception.EntityException;
import com.innowise.arraymanager.observer.impl.EntityStatisticsObserver;
import com.innowise.arraymanager.repository.EntityRepository;
import com.innowise.arraymanager.service.EntityStatisticsCalculator;
import com.innowise.arraymanager.service.impl.EntityStatisticsCalculatorImpl;
import com.innowise.arraymanager.singleton.EntityParameters;
import com.innowise.arraymanager.singleton.WareHouse;
import com.innowise.arraymanager.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EntityRepositoryImpl implements EntityRepository {
    private static final Logger logger = LogManager.getLogger(EntityRepositoryImpl.class);
    private final List<Entity> entities = new ArrayList<>();
    private static EntityRepositoryImpl instance;
    private final EntityStatisticsObserver entityStatisticsObserver = new EntityStatisticsObserver();
    private final EntityStatisticsCalculator calculator = new EntityStatisticsCalculatorImpl();

    private EntityRepositoryImpl() {
    }

    public static EntityRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new EntityRepositoryImpl();
        }
        return instance;
    }


    @Override
    public void add(Entity entity) {
        logger.info("Add entity to repository id: {}", entity.getId());
        entities.add(entity);
        entity.attach(entityStatisticsObserver);

        try {
            EntityParameters params = calculator.calculate(entity);
            WareHouse.getInstance().put(entity.getId(), params);
        } catch (EntityException e) {
            logger.warn("Error calculating initial stats for entity id={}", entity.getId(), e);
        }
    }

    @Override
    public void remove(Entity entity) {
        logger.info("Remove entity from repository id : {}", entity.getId());
        entities.remove(entity);
        entity.detach(entityStatisticsObserver);
        WareHouse.getInstance().remove(entity.getId());
    }


    public List<Entity> query(Specification specification) {
        return entities.stream()
                .filter(specification::isSatisfiedBy)
                .toList();
    }

    @Override
    public List<Entity> getEntities() {
        return new ArrayList<>(entities);
    }


    @Override
    public List<Entity> sort(Comparator<Entity> comparator) {
        return entities.stream()
                .sorted(comparator)
                .toList();
    }
}
