package com.bahamazau.impl.tetrahedron.observer;

import com.bahamazau.api.entity.Shape;
import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;

import java.util.EventObject;

public class TetrahedronEvent extends EventObject {

    public TetrahedronEvent(Shape source) {
        super(source);
    }

    @Override
    public Shape getSource() {
        return (Shape) super.getSource();
    }

}
