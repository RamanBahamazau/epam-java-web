package com.bahamazau.api.entity.dot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DotFactory {

    private static final Logger LOGGER = LogManager.getLogger();

    public Dot createDot(double x, double y, double z) {
        Dot dot = new Dot(x, y, z);

        LOGGER.info("Dot has created: " + dot);
        return dot;
    }

}
