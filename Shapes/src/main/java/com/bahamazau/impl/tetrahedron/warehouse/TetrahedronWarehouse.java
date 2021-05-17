package com.bahamazau.impl.tetrahedron.warehouse;

import com.bahamazau.api.warehouse.ShapeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronWarehouse implements ShapeWarehouse {

    private final static Logger LOGGER = LogManager.getLogger();

    private static TetrahedronWarehouse instance;
    private final Map<Long, ShapeWarehouseParameter> parameterMap = new HashMap<>();

    public static TetrahedronWarehouse getInstance() {
        if(instance == null) {
            instance = new TetrahedronWarehouse();
        }

        LOGGER.info("Warehouse has been initialized.");
        return instance;
    }

    @Override
    public void putParameter(long key, double surfaceArea, double volume, double perimeter) {
        ShapeWarehouseParameter parameter = new ShapeWarehouseParameter(surfaceArea, volume, perimeter);
        parameterMap.put(key, parameter);

        LOGGER.info(String.join(" ","Tetrahedron with id =", String.valueOf(key), "was put on warehouse."));
    }

    @Override
    public ShapeWarehouseParameter getParameter(long key) {
        ShapeWarehouseParameter parameter = parameterMap.get(key);

        LOGGER.info(String.join(" ","Tetrahedron with id =", String.valueOf(key), "was gotten from warehouse."));
        return parameter;
    }

    @Override
    public void remove(long key) {
        parameterMap.remove(key);

        LOGGER.info(String.join(" ","Tetrahedron with id =", String.valueOf(key), "was removed from warehouse."));
    }

}
