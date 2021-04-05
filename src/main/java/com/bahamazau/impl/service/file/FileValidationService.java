package com.bahamazau.impl.service.file;

import com.bahamazau.api.exception.ArrayException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileValidationService {

    private static final String SPACES_REGEX = "\\s+";

    private static final String NOT_DIGITS_REGEX = "[^-?\\d]";
    private static final Pattern PATTERN_NOT_DIGITS = Pattern.compile(NOT_DIGITS_REGEX);

    void exists(File file) throws ArrayException {
        if (!file.exists()) {
            throw new ArrayException("File doesn't exists");
        }
    }

    boolean containOnlyDigits(String nextLine) {
        for (String element: nextLine.split(SPACES_REGEX)) {
            if (PATTERN_NOT_DIGITS.matcher(element).find()) {
                return false;
            }
        }

        return true;
    }
}
