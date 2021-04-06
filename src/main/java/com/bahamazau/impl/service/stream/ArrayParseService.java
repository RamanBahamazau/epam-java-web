package com.bahamazau.impl.service.stream;

import com.bahamazau.api.exception.ArrayException;
import com.bahamazau.impl.service.custom.ValidationService;

import java.util.Arrays;

public class ArrayParseService {

    private static final String NOT_ONLY_DIGITS_MSG = "File is not containing only digits strings!";

    private static final String SPACES_REGEX = "\\s+";

    private final com.bahamazau.impl.service.custom.ValidationService validationService = new ValidationService();

    public int[] parseToArray(String string) throws ArrayException {
        if (validationService.containOnlyDigits(string)) {
            return Arrays.stream(string.split(SPACES_REGEX)).mapToInt(Integer::parseInt).toArray();
        }

        throw new ArrayException(NOT_ONLY_DIGITS_MSG);
    }

}
