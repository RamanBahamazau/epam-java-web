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

/**
 * TODO: transform methods for irregular tetrahedrons.
 */
public class TetrahedronService implements ShapeService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public double calculateSurfaceArea(Shape shape) throws CustomException {
        Tetrahedron tetrahedron = convertShape(shape);

        double surfaceArea = 0;
        for (Triangular triangular: triangleList(tetrahedron)) {
            surfaceArea += triangular.calculateFaceArea();
        }

        LOGGER.info("Surface area of tetrahedron is equal to: " + surfaceArea);
        return surfaceArea;
    }

    @Override
    public double calculateVolume(Shape shape) throws CustomException {
        Tetrahedron tetrahedron = convertShape(shape);

        Triangular baseTriangular = new Triangular(
                tetrahedron.getBaseDot1(), tetrahedron.getBaseDot2(), tetrahedron.getBaseDot3());
        double baseArea = baseTriangular.calculateFaceArea();
        double height = calculateHeight(tetrahedron);
        double volume = baseArea * height / 3;

        LOGGER.info("Volume of tetrahedron is equal to: " + volume);
        return volume;
    }

    public boolean isTetrahedron(List<Dot> dotList) {
        return (distanceBetweenDots(dotList.get(1), dotList.get(2)) != 0
                    && distanceBetweenDots(dotList.get(2), dotList.get(3)) != 0
                    && distanceBetweenDots(dotList.get(3), dotList.get(1)) != 0)
                && isValid(dotList.get(0), dotList.get(1), dotList.get(2), dotList.get(3));
    }

    private boolean isValid(Dot apexDot, Dot baseDot1, Dot baseDot2, Dot baseDot3) {
        return isValidX(baseDot1, baseDot2, baseDot3, apexDot)
                || isValidY(baseDot1, baseDot2, baseDot3, apexDot)
                || isValidZ(baseDot1, baseDot2, baseDot3, apexDot);
    }

    private boolean isValidX(Dot dot1, Dot dot2, Dot dot3, Dot apexDot) {
        Triangular triangular = new Triangular(dot1, dot2, dot3);
        return triangular.isBasedOnYZ() && dot1.getX() != apexDot.getX()
                && (areNotCross(dot1.getY(), dot2.getY(), dot3.getY()) || areNotCross(dot1.getZ(), dot2.getZ(), dot3.getZ()));
    }

    private boolean isValidY(Dot dot1, Dot dot2, Dot dot3, Dot apexDot) {
        Triangular triangular = new Triangular(dot1, dot2, dot3);
        return triangular.isBasedOnXZ() && dot1.getY() != apexDot.getY()
                && (areNotCross(dot1.getX(), dot2.getX(), dot3.getX()) || areNotCross(dot1.getZ(), dot2.getZ(), dot3.getZ()));
    }

    private boolean isValidZ(Dot dot1, Dot dot2, Dot dot3, Dot apexDot) {
        Triangular triangular = new Triangular(dot1, dot2, dot3);
        return triangular.isBasedOnXY() && dot1.getZ() != apexDot.getZ()
                && (areNotCross(dot1.getY(), dot2.getY(), dot3.getY()) || areNotCross(dot1.getX(), dot2.getX(), dot3.getX()));
    }

    private boolean areNotCross(double coordinate1, double coordinate2, double coordinate3) {
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

        double calculateFaceArea() {
            double edge1 = distanceBetweenDots(dot1, dot2);
            double edge2 = distanceBetweenDots(dot2, dot3);
            double edge3 = distanceBetweenDots(dot3, dot1);
            double p = (edge1 + edge2 + edge3) / 2;

            return Math.sqrt(p * (p - edge1) * (p - edge2) * (p - edge3));
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

    private double distanceBetweenDots(Dot a, Dot b) {
        double sum = Math.pow(a.getX() - b.getX(), 2)
                + Math.pow(a.getY() - b.getY(), 2)
                + Math.pow(a.getZ() - b.getZ(), 2);
        return Math.sqrt(sum);
    }

    private double calculateHeight(Tetrahedron tetrahedron) {
        Dot tetrahedronApex = tetrahedron.getApex();
        Dot baseDot1 = tetrahedron.getBaseDot1();
        Dot baseDot2 = tetrahedron.getBaseDot2();
        Dot baseDot3 = tetrahedron.getBaseDot3();

        double height = 0;
        Triangular baseTriangular = new Triangular(baseDot1, baseDot2, baseDot3);
        if (baseTriangular.isBasedOnYZ()) {
            height = Math.abs(tetrahedronApex.getX() - baseDot1.getX());
        } else if (baseTriangular.isBasedOnXZ()) {
            height = Math.abs(tetrahedronApex.getY() - baseDot1.getY());
        } else if (baseTriangular.isBasedOnXY()) {
            height = Math.abs(tetrahedronApex.getZ() - baseDot1.getZ());
        }

        LOGGER.info("Height of tetrahedron is equal to: " + height);
        return height;
    }

    private Tetrahedron convertShape(Shape shape) throws CustomException {
        if (!isTetrahedron(shape.getDots())) {
            String errorMsg = "Shape is not tetrahedron!";
            LOGGER.error(errorMsg);
            throw new CustomException(errorMsg);
        }

        return (Tetrahedron) shape;
    }

}
