package com.bahamazau.impl.tetrahedron.observer.impl;

import com.bahamazau.api.ShapeService;
import com.bahamazau.api.entity.Shape;
import com.bahamazau.api.observer.ShapeObserver;
import com.bahamazau.impl.tetrahedron.observer.TetrahedronEvent;
import com.bahamazau.impl.tetrahedron.service.TetrahedronService;
import com.bahamazau.impl.tetrahedron.warehouse.ShapeWarehouse;

import java.util.OptionalDouble;

public class TetrahedronShapeObserver implements ShapeObserver<TetrahedronEvent> {

    private final ShapeService service = new TetrahedronService();

    @Override
    public void changeParameters(TetrahedronEvent event) {
        Shape tetrahedron = event.getSource();

        OptionalDouble surfaceAreaOptional = service.calculateSurfaceArea(tetrahedron);
        double surfaceArea = surfaceAreaOptional.isPresent() ? surfaceAreaOptional.getAsDouble() : 0;

        OptionalDouble volumeOptional = service.calculateVolume(tetrahedron);
        double volume = volumeOptional.isPresent() ? volumeOptional.getAsDouble() : 0;

        OptionalDouble perimeterOptional = service.calculatePerimeter(tetrahedron);
        double perimeter = perimeterOptional.isPresent() ? perimeterOptional.getAsDouble() : 0;

        ShapeWarehouse.getInstance().putParameter(tetrahedron.getId(), surfaceArea, volume, perimeter);
    }

}
