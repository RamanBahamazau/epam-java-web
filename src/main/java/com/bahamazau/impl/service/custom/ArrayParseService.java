package com.bahamazau.impl.service.custom;

import com.bahamazau.api.exception.ArrayException;

public class ArrayParseService {

    private static final String NOT_ONLY_DIGITS_MSG = "File is not containing only digits strings!";

    private static final String SPACES_REGEX = "\\s+";

    private final ValidationService validationService = new ValidationService();

    public int[] parseToArray(String string) throws ArrayException {
        if (validationService.containOnlyDigits(string)) {
            String[] arrayString = string.split(SPACES_REGEX);
            int[] intArray = new int[arrayString.length];
            for (int index = 0; index < arrayString.length; index++) {
                intArray[index] = Integer.parseInt(arrayString[index]);
            }
        }

        throw new ArrayException(NOT_ONLY_DIGITS_MSG);
    }

}
