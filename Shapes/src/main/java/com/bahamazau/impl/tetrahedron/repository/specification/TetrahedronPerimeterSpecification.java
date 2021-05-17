package com.bahamazau.impl.tetrahedron.repository.specification;

import com.bahamazau.api.ShapeService;
import com.bahamazau.api.repository.specification.ShapeSpecification;
import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import com.bahamazau.impl.tetrahedron.service.TetrahedronService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;

public class TetrahedronPerimeterSpecification implements ShapeSpecification<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();

    private double minPerimeter;
    private double maxPerimeter;

    private final ShapeService<Tetrahedron> calculateService = new TetrahedronService();

    public TetrahedronPerimeterSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        OptionalDouble perimeterOptional = calculateService.calculateSurfaceArea(tetrahedron);
        double perimeter = perimeterOptional.isPresent() ? perimeterOptional.getAsDouble() : 0;

        boolean inRange = minPerimeter <= perimeter && perimeter <= maxPerimeter;

        LOGGER.info("Perimeter is in range: " + inRange);
        return inRange;
    }

}
