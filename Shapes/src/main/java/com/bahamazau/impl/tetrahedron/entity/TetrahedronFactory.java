package com.bahamazau.impl.tetrahedron.entity;

import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.impl.tetrahedron.service.TetrahedronService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class TetrahedronFactory {

    private static final Logger LOGGER = LogManager.getLogger();
    private final TetrahedronService validator = new TetrahedronService();

    public Optional<Tetrahedron> createTetrahedron(long id, List<Dot> dots) {
        if (validator.isTetrahedron(dots)) {
            Tetrahedron tetrahedron = new Tetrahedron(id, dots);

            LOGGER.info("Tetrahedron[" + id + "] has been added added to repository");
            return Optional.of(tetrahedron);
        } else {
            LOGGER.warn("The shape[" + id + "] is not a tetrahedron");
        }

        return Optional.empty();
    }

}
