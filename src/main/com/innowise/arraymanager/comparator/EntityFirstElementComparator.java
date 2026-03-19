package main.com.innowise.arraymanager.comparator;

import main.com.innowise.arraymanager.entity.Entity;

import java.util.Comparator;

public class EntityFirstElementComparator implements Comparator<Entity> {
    @Override
    public int compare(Entity first, Entity second) {
        return Integer.compare(first.getArray()[0], second.getArray()[0]);
    }
}
