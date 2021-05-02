package com.bahamazau.api;

import com.bahamazau.api.entity.Shape;
import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.impl.exception.CustomException;

import java.util.List;

public interface ShapeService {

    double calculateSurfaceArea(Shape shape) throws CustomException;
    double calculateVolume(Shape shape) throws CustomException;

    boolean isTetrahedron(List<Dot> dotList);
    boolean isBasedOnXY(Shape shape) throws CustomException;
    boolean isBasedOnXZ(Shape shape) throws CustomException;
    boolean isBasedOnYZ(Shape shape) throws CustomException;

}
