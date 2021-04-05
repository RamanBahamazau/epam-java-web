package com.bahamazau.impl.service.file;

import com.bahamazau.api.exception.ArrayException;
import com.bahamazau.api.service.FileReaderService;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderServiceImpl implements FileReaderService {

    private static final String NOT_ONLY_DIGITS_MSG = "File is not containing only digits strings";

    private static final Logger LOGGER = LogManager.getLogger(FileReaderServiceImpl.class);

    private final FileValidationService fileValidationService = new FileValidationService();

    /**
     * Search in file string with only digits.
     *
     * @param filePath of file
     * @return only digits file line
     * @throws ArrayException if file is not existing and not containing only digits string
     */
    @Override
    public String readOnlyDigitsLine(String filePath) throws ArrayException {
        File file = new File(filePath);
        FileReader fileReader = null;

        try {
            fileValidationService.exists(file);
            fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                if (fileValidationService.containOnlyDigits(nextLine)) {
                    return nextLine;
                }
            }
        } catch (ArrayException e) {
            throw new ArrayException(e);
        } catch (FileNotFoundException e) {
            throw new ArrayException("File doesn't exists!");
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    LOGGER.log(Level.ERROR, e.getMessage());
                }
            }
        }

        LOGGER.log(Level.ERROR, NOT_ONLY_DIGITS_MSG);
        throw new ArrayException(NOT_ONLY_DIGITS_MSG);
    }
}
