package com.bahamazau.impl.tetrahedron.repository.specification;

import com.bahamazau.api.repository.specification.ShapeSpecification;
import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronIdSpecification implements ShapeSpecification<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();

    private long id;

    public TetrahedronIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        boolean isEqual = tetrahedron != null && tetrahedron.getId() == id;

        LOGGER.info("Id is equal: " + isEqual);
        return isEqual;
    }

}
