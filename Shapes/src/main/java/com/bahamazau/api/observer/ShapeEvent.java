package com.bahamazau.api.observer;

import java.util.EventObject;

public class ShapeEvent<Shape> extends EventObject {

    public ShapeEvent(Shape source) {
        super(source);
    }

    @Override
    public Shape getSource() {
        return (Shape) super.getSource();
    }

}
