package com.bahamazau.api;

import com.bahamazau.impl.entity.Tetrahedron;
import com.bahamazau.impl.entity.dot.Dot;

public interface TetrahedronService {

    boolean isBasedOnXY(Tetrahedron tetrahedron);
    boolean isBasedOnXZ(Tetrahedron tetrahedron);
    boolean isBasedOnYZ(Tetrahedron tetrahedron);

    double calculateVolume(Tetrahedron tetrahedron);
    double calculateSurfaceArea(Tetrahedron tetrahedron);
    double calculateHeight(Tetrahedron tetrahedron);
    double calculateBaseArea(Tetrahedron tetrahedron);
    double calculateBasePerimeter(Tetrahedron tetrahedron);
    double calculateDistanceBetweenPoints(Dot a, Dot b);

}
