package com.bahamazau.api;

import java.util.OptionalDouble;

public interface ShapeService<Shape> {

    OptionalDouble calculateSurfaceArea(Shape shape);
    OptionalDouble calculateVolume(Shape shape);
    OptionalDouble calculatePerimeter(Shape shape);

    boolean isBasedOnXY(Shape shape);
    boolean isBasedOnXZ(Shape shape);
    boolean isBasedOnYZ(Shape shape);

}
