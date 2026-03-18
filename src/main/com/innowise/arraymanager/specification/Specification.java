package main.com.innowise.arraymanager.specification;

import main.com.innowise.arraymanager.entity.Entity;

public interface Specification {
    boolean isSatisfiedBy(Entity entity);
}

