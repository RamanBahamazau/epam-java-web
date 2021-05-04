package com.bahamazau.impl.tetrahedron.service.parser;

import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.api.entity.dot.DotFactory;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronPointsParser {

    private static final String REGEX_FOR_SPLIT = "\\s+";

    private final DotFactory pointFactory = new DotFactory();
    private final TetrahedronPointsParserValidator validator = new TetrahedronPointsParserValidator();

    public List<Dot> parseDots(String line) {
        List<Dot> dots = new ArrayList<>();
        if (validator.isLineValid(line)) {
            String[] pointsLine = line.split(REGEX_FOR_SPLIT);
            for (int i = 0; i < pointsLine.length; i += 3) {
                double x = Double.parseDouble(pointsLine[i]);
                double y = Double.parseDouble(pointsLine[i + 1]);
                double z = Double.parseDouble(pointsLine[i + 2]);
                Dot point = pointFactory.createDot(x, y, z);
                dots.add(point);
            }
        }

        return dots;
    }

}
