package com.bahamazau.impl.service;

import com.bahamazau.api.entity.Shape;
import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.impl.entity.Tetrahedron;
import com.bahamazau.api.ShapeService;
import com.bahamazau.impl.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static java.util.Arrays.asList;

public class TetrahedronService implements ShapeService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public double calculateSurfaceArea(Shape shape) throws CustomException {
        Tetrahedron tetrahedron = convertShape(shape);

        Dot apexPoint = tetrahedron.getApex();
        Dot basePoint1 = tetrahedron.getBaseDot1();
        Dot basePoint2 = tetrahedron.getBaseDot2();
        Dot basePoint3 = tetrahedron.getBaseDot3();

        double area1 = calculateFaceArea(apexPoint, basePoint1, basePoint2);
        double area2 = calculateFaceArea(apexPoint, basePoint2, basePoint3);
        double area3 = calculateFaceArea(apexPoint, basePoint3, basePoint1);
        double baseArea = calculateBaseArea(tetrahedron);
        double surfaceArea = area1 + area2 + area3 + baseArea;

        LOGGER.info("Height of tetrahedron with id=" + tetrahedron.getId() + " : " + surfaceArea);
        return surfaceArea;
    }

    @Override
    public double calculateVolume(Shape shape) throws CustomException {
        Tetrahedron tetrahedron = convertShape(shape);

        double baseArea = calculateBaseArea(tetrahedron);
        double height = calculateHeight(tetrahedron);

        double volume = baseArea * height / 3;
        LOGGER.info("Volume of tetrahedron with id = " + tetrahedron.getId() + " : " + volume);
        return volume;
    }

    @Override
    public boolean isTetrahedron(List<Dot> dotList) {
        return (distanceBetweenPoints(dotList.get(1), dotList.get(2)) != 0
                    && distanceBetweenPoints(dotList.get(2), dotList.get(3)) != 0
                    && distanceBetweenPoints(dotList.get(3), dotList.get(1)) != 0)
                && isValid(dotList.get(0), dotList.get(1), dotList.get(2), dotList.get(3));
    }

    private boolean isValid(Dot apexDot, Dot baseDot1, Dot baseDot2, Dot baseDot3) {
        return isValidX(baseDot1, baseDot2, baseDot3, apexDot)
                || isValidY(baseDot1, baseDot2, baseDot3, apexDot)
                || isValidZ(baseDot1, baseDot2, baseDot3, apexDot);
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

    @Override
    public boolean isBasedOnYZ(Shape shape) throws CustomException {
        Tetrahedron tetrahedron = convertShape(shape);

        Triangular baseTriangular = new Triangular(
                tetrahedron.getBaseDot1(),
                tetrahedron.getBaseDot2(),
                tetrahedron.getBaseDot3());
        boolean isBasedOnYZ = baseTriangular.isBasedOnYZ();

        LOGGER.info("Tetrahedron is based on YZ: " + isBasedOnYZ);
        return isBasedOnYZ;
    }

    @Override
    public boolean isBasedOnXZ(Shape shape) throws CustomException {
        Tetrahedron tetrahedron = convertShape(shape);

        Triangular baseTriangular = new Triangular(
                tetrahedron.getBaseDot1(),
                tetrahedron.getBaseDot2(),
                tetrahedron.getBaseDot3());
        boolean isBasedOnXZ = baseTriangular.isBasedOnXZ();

        LOGGER.info("Tetrahedron is based on XZ: " + isBasedOnXZ);
        return isBasedOnXZ;
    }

    @Override
    public boolean isBasedOnXY(Shape shape) throws CustomException {
        Tetrahedron tetrahedron = convertShape(shape);

        Triangular baseTriangular = new Triangular(
                tetrahedron.getBaseDot1(),
                tetrahedron.getBaseDot2(),
                tetrahedron.getBaseDot3());
        boolean isBasedOnXY = baseTriangular.isBasedOnXY();

        LOGGER.info("Tetrahedron is based on XY: " + isBasedOnXY);
        return isBasedOnXY;
    }

    private class Triangular {

        private final Dot dot1;
        private final Dot dot2;
        private final Dot dot3;

        Triangular(Dot dot1, Dot dot2, Dot dot3) {
            this.dot1 = dot1;
            this.dot2 = dot2;
            this.dot3 = dot3;
        }

        boolean isBasedOnYZ() {
            return this.dot1.getX() == this.dot2.getX() && this.dot2.getX() == this.dot3.getX();
        }

        boolean isBasedOnXY() {
            return this.dot1.getZ() == this.dot2.getZ() && this.dot2.getZ() == this.dot3.getZ();
        }

        boolean isBasedOnXZ() {
            return this.dot1.getY() == this.dot2.getY() && this.dot2.getY() == this.dot3.getY();
        }

    }

    /**
     * Convert tetrahedron on list of triangles.
     *
     * @param tetrahedron
     * @return list surface of tetrahedron
     */
    private List<Triangular> triangleList(Tetrahedron tetrahedron) {
        Dot dot1 = tetrahedron.getApex();
        Dot dot2 = tetrahedron.getBaseDot1();
        Dot dot3 = tetrahedron.getBaseDot2();
        Dot dot4 = tetrahedron.getBaseDot3();

        Triangular triangular1 = new Triangular(dot1, dot2, dot3);
        Triangular triangular2 = new Triangular(dot1, dot2, dot4);
        Triangular triangular3 = new Triangular(dot1, dot3, dot4);
        Triangular triangular4 = new Triangular(dot2, dot3, dot4);

        return asList(triangular1, triangular2, triangular3, triangular4);
    }

    private double calculateBaseArea(Tetrahedron tetrahedron) {
        double area = calculateFaceArea(tetrahedron.getBaseDot1(), tetrahedron.getBaseDot2(), tetrahedron.getBaseDot3());
        LOGGER.info("Base area of tetrahedron with id=" + tetrahedron.getId() + " : " + area);

        return area;
    }

    private double distanceBetweenPoints(Dot a, Dot b) {
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();
        double z = a.getZ() - b.getZ();

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    private double calculateFaceArea(Dot point1, Dot point2, Dot point3) {
        double edge1 = distanceBetweenPoints(point1, point2);
        double edge2 = distanceBetweenPoints(point2, point3);
        double edge3 = distanceBetweenPoints(point3, point1);
        double p = (edge1 + edge2 + edge3) / 2;

        return Math.sqrt(p * (p - edge1) * (p - edge2) * (p - edge3));
    }

    private double calculateHeight(Tetrahedron tetrahedron) {
        Dot apex = tetrahedron.getApex();
        Dot baseDot1 = tetrahedron.getBaseDot1();
        Dot baseDot2 = tetrahedron.getBaseDot2();
        Dot baseDot3 = tetrahedron.getBaseDot3();

        double height = 0;
        if (baseDot1.getX() == baseDot2.getX() && baseDot2.getX() == baseDot3.getX()) {
            height = Math.abs(apex.getX() - baseDot1.getX());
        }
        if (baseDot1.getY() == baseDot2.getY() && baseDot2.getY() == baseDot3.getY()) {
            height = Math.abs(apex.getY() - baseDot1.getY());
        }
        if (baseDot1.getZ() == baseDot2.getZ() && baseDot2.getZ() == baseDot3.getZ()) {
            height = Math.abs(apex.getZ() - baseDot1.getZ());
        }

        LOGGER.info("Height of tetrahedron with id=" + tetrahedron.getId() + " : " + height);
        return height;
    }

    private Tetrahedron convertShape(Shape shape) throws CustomException {
        if (!isTetrahedron(shape.getDots())) {
            throw new CustomException("Shape is not tetrahedron!");
        }

        return (Tetrahedron) shape;
    }

}
