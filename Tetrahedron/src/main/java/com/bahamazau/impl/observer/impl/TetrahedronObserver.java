package com.bahamazau.impl.observer.impl;

import com.bahamazau.api.TetrahedronService;
import com.bahamazau.impl.entity.Tetrahedron;
import com.bahamazau.api.Observer;
import com.bahamazau.impl.observer.TetrahedronEvent;
import com.bahamazau.impl.service.TetrahedronServiceImpl;
import com.bahamazau.impl.warehouse.TetrahedronWarehouse;

public class TetrahedronObserver implements Observer {

    @Override
    public void changeParameters(TetrahedronEvent event) {
        Tetrahedron tetrahedron = event.getSource();
        TetrahedronService service = new TetrahedronServiceImpl();
        TetrahedronWarehouse warehouse = TetrahedronWarehouse.getInstance();

        long tetrahedronId = tetrahedron.getId();
        double volume = service.calculateVolume(tetrahedron);
        double surfaceArea = service.calculateSurfaceArea(tetrahedron);
        warehouse.putParameter(tetrahedronId, surfaceArea, volume);
    }

}
