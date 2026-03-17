package main.com.innowise.specification.impl;

import main.com.innowise.entity.Entity;
import main.com.innowise.specification.SpecificationInterface;

public class SpecificationBySum implements SpecificationInterface {
    @Override
    public boolean specification(Entity entity) {
        return false;
    }
}
