package com.bahamazau.impl.tetrahedron.service;

import com.bahamazau.impl.tetrahedron.exception.CustomException;
import com.bahamazau.api.ShapeFileReaderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TetrahedronFileReaderService implements ShapeFileReaderService {

    static final String FILE_NOT_FOUND_MSG = "File is not found";
    static final String FILE_PATH_IS_EMPTY_MSG = "File path is empty";

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readDataFromFile(String path) throws CustomException {
        validateFilePath(path);
        File file = new File(path);

        List<String> dataFromFile = new ArrayList<>();
        try (Stream<String> linesStream = Files.lines(file.toPath())) {
            linesStream.forEach(dataFromFile::add);
        } catch (Exception e) {
            throw new CustomException(FILE_NOT_FOUND_MSG, e);
        }

        return dataFromFile;
    }

    public void validateFilePath(String filePath) throws CustomException {
        if(filePath == null || filePath.isEmpty()) {
            LOGGER.error(FILE_PATH_IS_EMPTY_MSG);
            throw new CustomException(FILE_PATH_IS_EMPTY_MSG);
        }
    }

}
