package com.bahamazau.api;

import com.bahamazau.api.entity.Shape;
import com.bahamazau.impl.tetrahedron.exception.CustomException;

public interface ShapeService {

    double calculateSurfaceArea(Shape shape) throws CustomException;
    double calculateVolume(Shape shape) throws CustomException;
    double calculatePerimeter(Shape shape) throws CustomException;

    boolean isShape(Shape shape);
    boolean isBasedOnXY(Shape shape) throws CustomException;
    boolean isBasedOnXZ(Shape shape) throws CustomException;
    boolean isBasedOnYZ(Shape shape) throws CustomException;

}
