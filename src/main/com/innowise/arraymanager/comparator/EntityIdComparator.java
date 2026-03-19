package main.com.innowise.arraymanager.comparator;


import main.com.innowise.arraymanager.entity.Entity;

import java.util.Comparator;

public class EntityIdComparator implements Comparator<Entity> {

    @Override
    public int compare(Entity first, Entity second) {
        return Integer.compare(first.getId(), second.getId());
    }
}