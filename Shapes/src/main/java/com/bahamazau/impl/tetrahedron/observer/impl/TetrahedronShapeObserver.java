package com.bahamazau.impl.tetrahedron.observer.impl;

import com.bahamazau.api.ShapeService;
import com.bahamazau.api.entity.Shape;
import com.bahamazau.api.observer.ShapeObserver;
import com.bahamazau.impl.tetrahedron.observer.TetrahedronEvent;
import com.bahamazau.impl.tetrahedron.service.TetrahedronService;
import com.bahamazau.impl.tetrahedron.warehouse.TetrahedronWarehouse;

import java.util.OptionalDouble;

public class TetrahedronShapeObserver implements ShapeObserver<TetrahedronEvent> {

    private final ShapeService service = new TetrahedronService();

    @Override
    public void changeParameters(TetrahedronEvent event) {
        Shape tetrahedron = event.getSource();

        OptionalDouble surfaceAreaOptional = service.calculateSurfaceArea(tetrahedron);
        OptionalDouble volumeOptional = service.calculateVolume(tetrahedron);
        OptionalDouble perimeterOptional = service.calculatePerimeter(tetrahedron);

        if (surfaceAreaOptional.isPresent() && volumeOptional.isPresent() && perimeterOptional.isPresent()) {
            TetrahedronWarehouse.getInstance().putParameter(
                    tetrahedron.getId(),
                    surfaceAreaOptional.getAsDouble(),
                    volumeOptional.getAsDouble(),
                    perimeterOptional.getAsDouble());
        }
    }

}
