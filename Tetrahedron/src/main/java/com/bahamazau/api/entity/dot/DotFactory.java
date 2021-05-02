package com.bahamazau.api.entity.dot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DotFactory {

    private static final Logger LOGGER = LogManager.getLogger();

    public Dot createPoint(double x, double y, double z) {
        LOGGER.info("Method to create point start");
        Dot point = new Dot(x, y, z);
        LOGGER.info("Point created");

        return point;
    }

}
