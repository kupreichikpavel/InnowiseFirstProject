package main.com.innowise.arraymanager.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {

    private static final Logger logger = LogManager.getLogger(WareHouse.class);
    private static WareHouse instance;
    private final Map<Integer, EntityParameters> storage = new HashMap<>();

    private WareHouse() {
    }

    public static WareHouse getInstance() {
        if (instance == null) {
            instance = new WareHouse();
        }
        return instance;
    }


    public void put(int entityId, EntityParameters entityParametrs) {
        logger.info("Put parameters to storage");
        storage.put(entityId, entityParametrs);
    }

    public void remove(int id) {
        logger.info("Remove parameters to storage");
        storage.remove(id);
    }

    public EntityParameters get(int id) {
        logger.info("Get parameters to storage");
        return storage.get(id);
    }

}
