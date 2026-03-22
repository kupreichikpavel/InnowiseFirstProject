package com.innowise.arraymanager.specification;

import com.innowise.arraymanager.entity.Entity;

public interface Specification {
    boolean isSatisfiedBy(Entity entity);
}

