package com.bahamazau.impl.observer;

import com.bahamazau.impl.entity.Tetrahedron;

import java.util.EventObject;

public class TetrahedronEvent extends EventObject {

    public TetrahedronEvent(Tetrahedron source) {
        super(source);
    }

    @Override
    public Tetrahedron getSource() {
        return (Tetrahedron) super.getSource();
    }

}
