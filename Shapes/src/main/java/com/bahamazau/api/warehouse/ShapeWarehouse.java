package com.bahamazau.api.warehouse;

import com.bahamazau.impl.tetrahedron.warehouse.ShapeWarehouseParameter;

public interface ShapeWarehouse {

    public void putParameter(long key, double surfaceArea, double volume, double perimeter);
    public ShapeWarehouseParameter getParameter(long key);
    public void remove(long key);

}
