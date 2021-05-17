package com.bahamazau.impl.tetrahedron.comporator;

import com.bahamazau.api.ShapeService;
import com.bahamazau.api.entity.Shape;
import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import com.bahamazau.impl.tetrahedron.service.TetrahedronService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.OptionalDouble;

public class TetrahedronVolumeComparator implements Comparator<Tetrahedron> {

    private final static Logger LOGGER = LogManager.getLogger();

    private final ShapeService<Tetrahedron> calculateService = new TetrahedronService();

    @Override
    public int compare(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2) {
        OptionalDouble volumeOptional1 = calculateService.calculateVolume(tetrahedron1);
        double volume1 = volumeOptional1.isPresent() ? volumeOptional1.getAsDouble() : 0;

        OptionalDouble volumeOptional2 = calculateService.calculateVolume(tetrahedron2);
        double volume2 = volumeOptional2.isPresent() ? volumeOptional2.getAsDouble() : 0;

        int resultOfСomparation = Double.compare(volume1, volume2);

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
