package com.bahamazau.impl.tetrahedron.comporator;

import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Comparator;

public class TetrahedronIdComparator implements Comparator<Tetrahedron> {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2) {
        int resultOfСomparation = Long.compare(tetrahedron1.getId(), tetrahedron2.getId());

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
