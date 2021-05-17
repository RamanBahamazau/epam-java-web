package com.bahamazau.impl.tetrahedron.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShapeWarehouse {

    private final static Logger LOGGER = LogManager.getLogger();

    private static ShapeWarehouse instance;
    private final Map<Long, ShapeWarehouseParameter> parameterMap = new HashMap<>();

    public static ShapeWarehouse getInstance() {
        if(instance == null) {
            instance = new ShapeWarehouse();
        }

        LOGGER.info("Warehouse has been initialized.");
        return instance;
    }

    public void putParameter(long key, double surfaceArea, double volume, double perimeter) {
        ShapeWarehouseParameter parameter = new ShapeWarehouseParameter(surfaceArea, volume, perimeter);
        parameterMap.put(key, parameter);

        LOGGER.info(String.join(" ","Tetrahedron with id =", String.valueOf(key), "was put on warehouse."));
    }

    public ShapeWarehouseParameter getParameter(long key) {
        ShapeWarehouseParameter parameter = parameterMap.get(key);

        LOGGER.info(String.join(" ","Tetrahedron with id =", String.valueOf(key), "was gotten from warehouse."));
        return parameter;
    }

    public void remove(long key) {
        parameterMap.remove(key);

        LOGGER.info(String.join(" ","Tetrahedron with id =", String.valueOf(key), "was removed from warehouse."));
    }
}
