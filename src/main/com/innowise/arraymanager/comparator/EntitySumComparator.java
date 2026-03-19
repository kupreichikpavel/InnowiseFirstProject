package main.com.innowise.arraymanager.comparator;

import main.com.innowise.arraymanager.entity.Entity;
import main.com.innowise.arraymanager.singleton.WareHouse;

import java.util.Comparator;

public class EntitySumComparator implements Comparator<Entity> {
    @Override
    public int compare(Entity first, Entity second) {
        int firstSum = WareHouse.getInstance().get(first.getId()).getSum();
        int secondSum = WareHouse.getInstance().get(second.getId()).getSum();

        return Integer.compare(firstSum, secondSum);
    }
}

