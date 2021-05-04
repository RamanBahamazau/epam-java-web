package com.bahamazau.impl.tetrahedron.observer.impl;

import com.bahamazau.api.ShapeService;
import com.bahamazau.api.entity.Shape;
import com.bahamazau.api.Observer;
import com.bahamazau.impl.tetrahedron.exception.CustomException;
import com.bahamazau.impl.tetrahedron.observer.TetrahedronEvent;
import com.bahamazau.impl.tetrahedron.service.TetrahedronService;
import com.bahamazau.impl.tetrahedron.warehouse.TetrahedronWarehouse;

public class TetrahedronObserver implements Observer {

    private final ShapeService service = new TetrahedronService();
    private final TetrahedronWarehouse warehouse = TetrahedronWarehouse.getInstance();

    @Override
    public void changeParameters(TetrahedronEvent event) {
        Shape tetrahedron = event.getSource();

        try {
            double surfaceArea = service.calculateSurfaceArea(tetrahedron);
            double volume = service.calculateVolume(tetrahedron);
            double perimeter = service.calculatePerimeter(tetrahedron);

            warehouse.putParameter(tetrahedron.getId(), surfaceArea, volume, perimeter);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

}
