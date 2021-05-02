package com.bahamazau.impl.observer.impl;

import com.bahamazau.api.ShapeService;
import com.bahamazau.api.entity.Shape;
import com.bahamazau.api.Observer;
import com.bahamazau.impl.exception.CustomException;
import com.bahamazau.impl.observer.TetrahedronEvent;
import com.bahamazau.impl.service.TetrahedronService;
import com.bahamazau.impl.warehouse.TetrahedronWarehouse;

public class TetrahedronObserver implements Observer {

    @Override
    public void changeParameters(TetrahedronEvent event) {
        Shape tetrahedron = event.getSource();
        ShapeService service = new TetrahedronService();
        TetrahedronWarehouse warehouse = TetrahedronWarehouse.getInstance();

        try {
            double volume = service.calculateVolume(tetrahedron);
            double surfaceArea = service.calculateSurfaceArea(tetrahedron);

            warehouse.putParameter(tetrahedron.getId(), surfaceArea, volume);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

}
