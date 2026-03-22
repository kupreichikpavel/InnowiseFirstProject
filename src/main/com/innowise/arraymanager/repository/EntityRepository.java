package com.innowise.arraymanager.repository;

import com.innowise.arraymanager.entity.Entity;
import com.innowise.arraymanager.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface EntityRepository {
    void add(Entity entity);

    void remove(Entity entity);

    List<Entity> getEntities();

    List<Entity> query(Specification specification);

    List<Entity> sort(Comparator<Entity> comparator);


}
