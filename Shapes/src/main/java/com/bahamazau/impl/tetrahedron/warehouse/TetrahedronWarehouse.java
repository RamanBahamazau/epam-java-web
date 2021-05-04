package com.bahamazau.impl.tetrahedron.warehouse;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TetrahedronWarehouse {

    private static TetrahedronWarehouse instance;
    private final Map<Long, TetrahedronParameter> parametersMap = new HashMap<>();

    public static TetrahedronWarehouse getInstance() {
        if(instance == null) {
            instance = new TetrahedronWarehouse();
        }

        return instance;
    }

    public TetrahedronParameter getParameter(long key) {
        return parametersMap.get(key);
    }

    public void putParameter(long key, double surfaceArea, double volume, double perimeter) {
        TetrahedronParameter parameter = new TetrahedronParameter(surfaceArea, volume, perimeter);
        parametersMap.put(key, parameter);
    }

    public Collection<TetrahedronParameter> getParameters(){
        return parametersMap.values();
    }

}
