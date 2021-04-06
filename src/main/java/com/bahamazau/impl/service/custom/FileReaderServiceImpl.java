package com.bahamazau.impl.service.custom;

import com.bahamazau.api.exception.ArrayException;
import com.bahamazau.api.service.FileReaderService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderServiceImpl implements FileReaderService {

    private static final String NOT_EXISTS_MSG = "File doesn't exist!";
    private static final String NOT_ONLY_DIGITS_MSG = "File is not containing only digits strings!";
    private static final String NOT_CLOSING_FILE_MSG = "File is not containing only digits strings!";

    private final ValidationService validationService = new ValidationService();

    /**
     * Search in file string with only digits.
     *
     * @param filePath of file
     * @return only digits file line
     * @throws ArrayException if file is not existing or not containing only digits string
     */
    @Override
    public String readOnlyDigitsLine(String filePath) throws ArrayException {
        File file = new File(filePath);
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                if (validationService.containOnlyDigits(nextLine)) {
                    return nextLine;
                }
            }
        } catch (FileNotFoundException e) {
            throw new ArrayException(NOT_EXISTS_MSG);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    new ArrayException(NOT_CLOSING_FILE_MSG);
                }
            }
        }

        throw new ArrayException(NOT_ONLY_DIGITS_MSG);
    }
}
