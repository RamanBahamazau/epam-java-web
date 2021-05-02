package com.bahamazau.impl.entity;

import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.impl.service.TetrahedronService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class TetrahedronFactory {

    private static final Logger LOGGER = LogManager.getLogger();
    private final TetrahedronService validator = new TetrahedronService();

    public Optional<Tetrahedron> createTetrahedron(long id, List<Dot> dots) {
        LOGGER.info("Method to create tetrahedron start");

        if (validator.isTetrahedron(dots)) {
            Tetrahedron tetrahedron = new Tetrahedron(id, dots);

            LOGGER.info("Tetrahedron with id = " + id + " added to repository");
            return Optional.of(tetrahedron);
        } else {
            LOGGER.info("The figure with id = " + id + " is not a tetrahedron");
        }
        LOGGER.info("Tetrahedron created");

        return Optional.empty();
    }

}
