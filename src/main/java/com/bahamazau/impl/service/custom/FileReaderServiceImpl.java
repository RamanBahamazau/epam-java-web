package com.bahamazau.impl.service.custom;

import com.bahamazau.api.exception.ArrayException;
import com.bahamazau.api.service.FileReaderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.apache.log4j.Level.ERROR;

public class FileReaderServiceImpl implements FileReaderService {

    private static final String NOT_EXISTS_MSG = "File doesn't exist!";
    private static final String NOT_ONLY_DIGITS_MSG = "File is not containing only digits strings!";

    private static final Logger LOGGER = LogManager.getLogger(FileReaderServiceImpl.class);

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
                    LOGGER.log(ERROR, e.getMessage());
                }
            }
        }

        LOGGER.log(ERROR, NOT_ONLY_DIGITS_MSG);
        throw new ArrayException(NOT_ONLY_DIGITS_MSG);
    }
}
