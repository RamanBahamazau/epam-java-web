package com.bahamazau;

import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.impl.entity.TetrahedronFactory;
import com.bahamazau.impl.exception.CustomException;
import com.bahamazau.impl.service.parser.TetrahedronPointsParser;
import com.bahamazau.impl.repository.TetrahedronRepositoryImpl;
import com.bahamazau.impl.repository.TetrahedronRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShapesMain {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final TetrahedronRepository tetrahedronRepository = TetrahedronRepository.getInstance();
    private static final TetrahedronFactory tetrahedronFactory = new TetrahedronFactory();

    public static void main(String[] args) {
        TetrahedronRepositoryImpl dataReader = new TetrahedronRepositoryImpl();
        TetrahedronPointsParser tetrahedronPointsParser = new TetrahedronPointsParser();

        try {
            List<String> dataFromFile = dataReader.readDataFromFile("./src/main/resources/data/data.txt");

            LOGGER.info("Method to create tetrahedron repository start");
            dataFromFile.forEach(line -> {
                List<Dot> dots = tetrahedronPointsParser.parseDots(line);

                if (!dots.isEmpty()) {
                    tetrahedronFactory.createTetrahedron(tetrahedronRepository.nextId(), dots)
                            .ifPresent(tetrahedronRepository::add);
                }
            });
            LOGGER.info("Tetrahedron repository created");

            LOGGER.info(tetrahedronRepository.getTetrahedrons());
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
