package com.bahamazau.api.comporator;

import com.bahamazau.api.entity.Shape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ShapeComporator extends Comparable<Shape> {

    final static Logger LOGGER = LogManager.getLogger();

    default void logComporation(int resultOfСomparation) {
        String textResultOfСomparation = "";
        switch (resultOfСomparation) {
            case -1:
                textResultOfСomparation = "greater then";
                break;

            case 0:
                textResultOfСomparation = "equal to";
                break;

            case 1:
                textResultOfСomparation = "less then";
                break;
        }

        LOGGER.info(String.join(" ", "First is", textResultOfСomparation, "second."));
    }

}
