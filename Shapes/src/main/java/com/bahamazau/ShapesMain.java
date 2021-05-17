package com.bahamazau;

import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.impl.tetrahedron.entity.TetrahedronFactory;
import com.bahamazau.api.exception.ShapeException;
import com.bahamazau.impl.tetrahedron.service.TetrahedronFileReaderService;
import com.bahamazau.impl.tetrahedron.service.parser.TetrahedronPointsParser;
import com.bahamazau.impl.tetrahedron.repository.TetrahedronRepository;

import java.util.List;

public class ShapesMain {

    private static final TetrahedronRepository TETRAHEDRON_REPOSITORY_SINGLETON = TetrahedronRepository.getInstance();
    private static final TetrahedronFactory tetrahedronFactory = new TetrahedronFactory();
    private static final TetrahedronFileReaderService dataReader = new TetrahedronFileReaderService();
    private static final TetrahedronPointsParser tetrahedronPointsParser = new TetrahedronPointsParser();

    public static void main(String[] args) {
        try {
            List<String> dataFromFile = dataReader.readDataFromFile("./src/main/resources/data/data.txt");

            dataFromFile.forEach(line -> {
                List<Dot> dots = tetrahedronPointsParser.parseDots(line);

                if (!dots.isEmpty()) {
                    tetrahedronFactory.createTetrahedron(TETRAHEDRON_REPOSITORY_SINGLETON.nextId(), dots)
                            .ifPresent(TETRAHEDRON_REPOSITORY_SINGLETON::add);
                }
            });
        } catch (ShapeException e) {
            e.printStackTrace();
        }
    }
}
