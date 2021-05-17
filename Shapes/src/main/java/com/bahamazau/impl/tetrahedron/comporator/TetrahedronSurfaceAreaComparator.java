package com.bahamazau.impl.tetrahedron.comporator;

import com.bahamazau.api.ShapeService;
import com.bahamazau.api.entity.Shape;
import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import com.bahamazau.impl.tetrahedron.service.TetrahedronService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.OptionalDouble;

public class TetrahedronSurfaceAreaComparator implements Comparator<Tetrahedron> {

    private final static Logger LOGGER = LogManager.getLogger();

    private final ShapeService<Tetrahedron> calculateService = new TetrahedronService();

    @Override
    public int compare(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2) {
        OptionalDouble surfaceAreaOptional1 = calculateService.calculateSurfaceArea(tetrahedron1);
        double surfaceArea1 = surfaceAreaOptional1.isPresent() ? surfaceAreaOptional1.getAsDouble() : 0;

        OptionalDouble surfaceAreaOptional2 = calculateService.calculateSurfaceArea(tetrahedron2);
        double surfaceArea2 = surfaceAreaOptional2.isPresent() ? surfaceAreaOptional2.getAsDouble() : 0;

        int resultOfСomparation = Double.compare(surfaceArea1, surfaceArea2);

        logComparation(resultOfСomparation);
        return resultOfСomparation;
    }

    private void logComparation(int resultOfСomparation) {
        String textResultOfComparation = "";
        if (resultOfСomparation == -1) {
            textResultOfComparation = "greater then";
        } else if (resultOfСomparation == 0) {
            textResultOfComparation = "equal to";
        } else if (resultOfСomparation == 1) {
            textResultOfComparation = "less then";
        }

        LOGGER.info(String.join(" ", "First is", textResultOfComparation, "second."));
    }

}
