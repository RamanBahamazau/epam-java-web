package com.bahamazau.impl.tetrahedron.repository.specification;

import com.bahamazau.api.ShapeService;
import com.bahamazau.api.repository.specification.ShapeSpecification;
import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import com.bahamazau.impl.tetrahedron.service.TetrahedronService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;

public class TetrahedronVolumeSpecification implements ShapeSpecification<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();

    private double minVolumeArea;
    private double maxVolumeArea;

    private final ShapeService<Tetrahedron> calculateService = new TetrahedronService();

    public TetrahedronVolumeSpecification(double minVolumeArea, double maxVolumeArea) {
        this.minVolumeArea = minVolumeArea;
        this.maxVolumeArea = maxVolumeArea;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        OptionalDouble volumeOptional = calculateService.calculateSurfaceArea(tetrahedron);
        double volume = volumeOptional.isPresent() ? volumeOptional.getAsDouble() : 0;

        boolean inRange = minVolumeArea <= volume && volume <= maxVolumeArea;

        LOGGER.info("Surface area is in range: " + inRange);
        return inRange;
    }

}
