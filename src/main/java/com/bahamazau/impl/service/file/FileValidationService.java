package com.bahamazau.impl.service.file;

import java.util.regex.Pattern;

public class FileValidationService {

    private static final String SPACES_REGEX = "\\s+";

    private static final String NOT_DIGITS_REGEX = "[^-?\\d]";
    private static final Pattern PATTERN_NOT_DIGITS = Pattern.compile(NOT_DIGITS_REGEX);

    /**
     * Validation of String on containing only digits validation.
     *
     * @param nextLine string for parse on array
     * @return true if string is not empty and contain only digits
     */
    boolean containOnlyDigits(String nextLine) {
        for (String element: nextLine.split(SPACES_REGEX)) {
            if (PATTERN_NOT_DIGITS.matcher(element).find()) {
                return false;
            }
        }

        return !nextLine.isEmpty();
    }
}
