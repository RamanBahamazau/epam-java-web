package com.bahamazau.impl.tetrahedron.comparator;

import com.bahamazau.api.ShapeService;
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

        int result = Double.compare(volume1, volume2);

        log(result);
        return result;
    }

    private void log(int result) {
        String textResult = "";
        if (result == -1) {
            textResult = "greater then";
        } else if (result == 0) {
            textResult = "equal to";
        } else if (result == 1) {
            textResult = "less then";
        }

        LOGGER.info(String.join(" ", "First is", textResult, "second."));
    }

}
