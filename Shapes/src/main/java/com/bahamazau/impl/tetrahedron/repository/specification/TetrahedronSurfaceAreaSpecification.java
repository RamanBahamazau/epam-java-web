package com.bahamazau.impl.tetrahedron.repository.specification;

import com.bahamazau.api.ShapeService;
import com.bahamazau.api.repository.specification.ShapeSpecification;
import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import com.bahamazau.impl.tetrahedron.service.TetrahedronService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;

public class TetrahedronSurfaceAreaSpecification implements ShapeSpecification<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();

    private double minSurfaceArea;
    private double maxSurfaceArea;

    private final ShapeService<Tetrahedron> calculateService = new TetrahedronService();

    public TetrahedronSurfaceAreaSpecification(double minSurfaceArea, double maxSurfaceArea) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        OptionalDouble surfaceAreaOptional = calculateService.calculateSurfaceArea(tetrahedron);
        double surfaceArea = surfaceAreaOptional.isPresent() ? surfaceAreaOptional.getAsDouble() : 0;

        boolean inRange = minSurfaceArea <= surfaceArea && surfaceArea <= maxSurfaceArea;

        LOGGER.info("Surface area is in range: " + inRange);
        return inRange;
    }

}
