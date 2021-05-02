package com.bahamazau.impl.service.parser;

import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.api.entity.dot.DotFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronPointsParser {

    private static final Logger LOGGER = LogManager.getLogger();
    private final DotFactory pointFactory = new DotFactory();

    private final TetrahedronPointsParserValidator validator = new TetrahedronPointsParserValidator();

    private static final String REGEX_FOR_SPLIT = "\\s+";

    public List<Dot> parseDots(String line) {
        LOGGER.info("Method to parse data from file start");

        List<Dot> dots = new ArrayList<>();
        if (validator.isLineValid(line)) {
            String[] pointsLine = line.split(REGEX_FOR_SPLIT);
            for (int i = 0; i < pointsLine.length; i += 3) {
                double x = Double.parseDouble(pointsLine[i]);
                double y = Double.parseDouble(pointsLine[i + 1]);
                double z = Double.parseDouble(pointsLine[i + 2]);
                Dot point = pointFactory.createPoint(x, y, z);
                dots.add(point);
            }
        }

        return dots;
    }

}
