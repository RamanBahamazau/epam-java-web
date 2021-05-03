package com.bahamazau;

import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.impl.entity.TetrahedronFactory;
import com.bahamazau.impl.exception.CustomException;
import com.bahamazau.impl.service.TetrahedronFileReaderService;
import com.bahamazau.impl.service.parser.TetrahedronPointsParser;
import com.bahamazau.impl.repository.TetrahedronRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TetrahedronMain {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final TetrahedronRepository TETRAHEDRON_REPOSITORY_SINGLETON = TetrahedronRepository.getInstance();
    private static final TetrahedronFactory tetrahedronFactory = new TetrahedronFactory();

    public static void main(String[] args) {
        TetrahedronFileReaderService dataReader = new TetrahedronFileReaderService();
        TetrahedronPointsParser tetrahedronPointsParser = new TetrahedronPointsParser();

        try {
            List<String> dataFromFile = dataReader.readDataFromFile("./src/main/resources/data/data.txt");

            dataFromFile.forEach(line -> {
                List<Dot> dots = tetrahedronPointsParser.parseDots(line);

                if (!dots.isEmpty()) {
                    tetrahedronFactory.createTetrahedron(TETRAHEDRON_REPOSITORY_SINGLETON.nextId(), dots)
                            .ifPresent(TETRAHEDRON_REPOSITORY_SINGLETON::add);
                }
            });

            LOGGER.info(TETRAHEDRON_REPOSITORY_SINGLETON.getTetrahedrons());
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
