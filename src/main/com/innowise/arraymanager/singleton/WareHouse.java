package main.com.innowise.arraymanager.singleton;

import main.com.innowise.arraymanager.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {

    private static final Logger logger = LogManager.getLogger(WareHouse.class);
    private static WareHouse instance;
    private Map<Integer, int[]> storage = new HashMap<>();

    public static WareHouse getInstance() {
        if (instance == null) {
            instance = new WareHouse();
        }
        return instance;
    }

    public void putToStorage(int entityId, Entity entity) {
        storage.put(entityId, entity.getArray());
    }

    public void removeIntoStorage(int idForRemove) {
    }


}
