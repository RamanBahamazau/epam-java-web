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

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readDataFromFile(String path) throws CustomException {
        validateFilePath(path);
        File file = new File(path);

        List<String> dataFromFile = new ArrayList<>();
        try (Stream<String> linesStream = Files.lines(file.toPath())) {
            linesStream.forEach(dataFromFile::add);
        } catch (Exception e) {
            throw new CustomException("File is not found", e);
        }

        return dataFromFile;
    }

    public void validateFilePath(String path) throws CustomException {
        if(path == null || path.isEmpty()) {
            String message = String.format("File path '%s' is empty", path);

            LOGGER.error(message);
            throw new CustomException(message);
        }
    }

}
