package com.bahamazau.impl.tetrahedron.service;

import com.bahamazau.api.ShapeSpecification;
import com.bahamazau.api.entity.Shape;

public class TetrahedronIdSpecification implements ShapeSpecification {

    private int id;

    public TetrahedronIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specifyShape(Shape shape) {
        return shape.getId() == id;
    }

}
