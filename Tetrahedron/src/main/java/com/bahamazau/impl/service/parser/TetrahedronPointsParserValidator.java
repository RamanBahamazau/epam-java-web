package com.bahamazau.impl.service.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronPointsParserValidator {

    private static final String REGEX_FOR_POINTS = "(-?(0|[1-9]\\d*)(\\.\\d+)?)";
    private static final String REGEX_FOR_SPLIT = "\\s+";

    private static final Logger LOGGER = LogManager.getLogger();

    public boolean isLineValid(String line) {
        LOGGER.info("Method to validate points line start");

        boolean isVal = false;
        String[] elements = line.split(REGEX_FOR_SPLIT);
        if (elements.length == 12) {
            for (String element : elements) {
                isVal = element.matches(REGEX_FOR_POINTS);
                if (!isVal) {
                    LOGGER.info("The string "+line+" has an invalid parameter");
                    break;
                }
            }
        } else {
            LOGGER.info("The string "+line+" has not enough parameters " + elements.length);
        }

        return isVal;
    }

}
