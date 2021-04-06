package com.bahamazau.impl.service.stream;

import com.bahamazau.api.exception.ArrayException;
import com.bahamazau.api.service.FileReaderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

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
        Path path = Path.of(filePath);
        try (Stream<String> fileLines = Files.lines(path)) {
            return fileLines.filter(validationService::containOnlyDigits)
                    .findFirst()
                    .orElseThrow(() -> new ArrayException(NOT_ONLY_DIGITS_MSG));
        } catch (IOException e) {
            throw new ArrayException(NOT_EXISTS_MSG);
        }
    }
}
