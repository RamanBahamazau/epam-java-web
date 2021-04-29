package com.bahamazau.impl.entity;

import com.bahamazau.impl.entity.dot.Dot;
import com.bahamazau.impl.service.TetrahedronServiceImpl;

public class TetrahedronFactoryValidator {

    private final TetrahedronServiceImpl distanceService = new TetrahedronServiceImpl();

    public boolean isTetrahedron(Dot dot1, Dot dot2, Dot dot3, Dot dot4) {
        return (distanceService.calculateDistanceBetweenPoints(dot2, dot3) != 0
                && distanceService.calculateDistanceBetweenPoints(dot3, dot4) != 0
                && distanceService.calculateDistanceBetweenPoints(dot4, dot2) != 0)
                && isValid(dot2, dot3, dot4, dot1);
    }

    private boolean isValid(Dot dot1, Dot dot2, Dot dot3, Dot apexDot) {
        return isValidX(dot1, dot2, dot3, apexDot) || isValidY(dot1, dot2, dot3, apexDot) || isValidZ(dot1, dot2, dot3, apexDot);
    }

    private boolean isValidX(Dot dot1, Dot dot2, Dot dot3, Dot apexDot) {
        return isPublic(dot1.getX(), dot2.getX(), dot3.getX(), apexDot.getX())
                && (isPrivate(dot1.getY(), dot2.getY(), dot3.getY()) || isPrivate(dot1.getZ(), dot2.getZ(), dot3.getZ()));
    }

    private boolean isValidY(Dot dot1, Dot dot2, Dot dot3, Dot apexPoint) {
        return isPublic(dot1.getY(), dot2.getY(), dot3.getY(), apexPoint.getY())
                && (isPrivate(dot1.getX(), dot2.getX(), dot3.getX()) || isPrivate(dot1.getZ(), dot2.getZ(), dot3.getZ()));
    }

    private boolean isValidZ(Dot dot1, Dot dot2, Dot dot3, Dot apexPoint) {
        return isPublic(dot1.getZ(), dot2.getZ(), dot3.getZ(), apexPoint.getZ())
                && (isPrivate(dot1.getY(), dot2.getY(), dot3.getY())  || isPrivate(dot1.getX(), dot2.getX(), dot3.getX()));
    }

    private boolean isPublic(double coordinate1, double coordinate2, double coordinate3, double apexCoordinate) {
        return coordinate1 == coordinate2 && coordinate2 == coordinate3 && coordinate1 != apexCoordinate;
    }

    private boolean isPrivate(double coordinate1, double coordinate2, double coordinate3) {
        return coordinate1 == coordinate2 && coordinate2 != coordinate3
                || coordinate1 == coordinate3 && coordinate1 != coordinate2
                || coordinate2 == coordinate3 && coordinate2 != coordinate1;
    }

}
