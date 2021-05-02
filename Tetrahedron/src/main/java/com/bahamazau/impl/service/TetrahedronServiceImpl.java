package com.bahamazau.impl.service;

import com.bahamazau.impl.entity.Tetrahedron;
import com.bahamazau.impl.entity.dot.Dot;
import com.bahamazau.api.TetrahedronService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static java.util.Arrays.asList;

public class TetrahedronServiceImpl implements TetrahedronService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public boolean isBasedOnYZ(Tetrahedron tetrahedron) {
        boolean isBasedOnYZ = false;
        for (Triangle triangle: triangleList(tetrahedron)) {
            isBasedOnYZ = triangle.isBasedOnYZ();
        }

        LOGGER.info("Tetrahedron is based on YZ: " + isBasedOnYZ);
        return isBasedOnYZ;
    }

    @Override
    public boolean isBasedOnXZ(Tetrahedron tetrahedron) {
        boolean isBasedOnXZ = false;
        for (Triangle triangle: triangleList(tetrahedron)) {
            isBasedOnXZ = triangle.isBasedOnXZ();
        }

        LOGGER.info("Tetrahedron is based on XZ: " + isBasedOnXZ);
        return isBasedOnXZ;
    }

    @Override
    public boolean isBasedOnXY(Tetrahedron tetrahedron) {
        boolean isBasedOnXY = false;
        for (Triangle triangle: triangleList(tetrahedron)) {
            isBasedOnXY = triangle.isBasedOnXY();
        }

        LOGGER.info("Tetrahedron is based on XY: " + isBasedOnXY);
        return isBasedOnXY;
    }

    @Override
    public double calculateVolume(Tetrahedron tetrahedron) {
        double height = calculateHeight(tetrahedron);
        double baseArea = calculateBaseArea(tetrahedron);
        double volume = height * baseArea / 3;

        LOGGER.info("Volume of tetrahedron with id=" + tetrahedron.getId() + " : " + volume);
        return volume;
    }

    @Override
    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        Dot apexPoint = tetrahedron.getDot1();
        Dot basePoint1 = tetrahedron.getDot2();
        Dot basePoint2 = tetrahedron.getDot3();
        Dot basePoint3 = tetrahedron.getDot4();

        double area1 = calculateFaceArea(apexPoint,basePoint1,basePoint2);
        double area2 = calculateFaceArea(apexPoint,basePoint2,basePoint3);
        double area3 = calculateFaceArea(apexPoint,basePoint3,basePoint1);
        double baseArea = calculateBaseArea(tetrahedron);
        double surfaceArea = area1 + area2 + area3 + baseArea;

        LOGGER.info("Height of tetrahedron with id=" + tetrahedron.getId() + " : " + surfaceArea);
        return surfaceArea;
    }

    @Override
    public double calculateHeight(Tetrahedron tetrahedron) {
        Dot apexPoint = tetrahedron.getDot1();
        Dot basePoint1 = tetrahedron.getDot2();
        Dot basePoint2 = tetrahedron.getDot3();
        Dot basePoint3 = tetrahedron.getDot4();

        double height = 0;
        if (basePoint1.getX() == basePoint2.getX() && basePoint2.getX() == basePoint3.getX()) {
            height = Math.abs(apexPoint.getX() - basePoint1.getX());
        }
        if (basePoint1.getY() == basePoint2.getY() && basePoint2.getY() == basePoint3.getY()) {
            height = Math.abs(apexPoint.getY() - basePoint1.getY());
        }
        if (basePoint1.getZ() == basePoint2.getZ() && basePoint2.getZ() == basePoint3.getZ()) {
            height = Math.abs(apexPoint.getZ() - basePoint1.getZ());
        }

        LOGGER.info("Height of tetrahedron with id=" + tetrahedron.getId() + " : " + height);
        return height;
    }

    @Override
    public double calculateBasePerimeter(Tetrahedron tetrahedron) {
        Dot basePoint1 = tetrahedron.getDot2();
        Dot basePoint2 = tetrahedron.getDot3();
        Dot basePoint3 = tetrahedron.getDot4();

        double baseEdge1 = calculateDistanceBetweenPoints(basePoint1, basePoint2);
        double baseEdge2 = calculateDistanceBetweenPoints(basePoint2, basePoint3);
        double baseEdge3 = calculateDistanceBetweenPoints(basePoint3, basePoint1);
        double perimeter = baseEdge1 + baseEdge2 + baseEdge3;

        LOGGER.info("Base perimeter of tetrahedron with id=" + tetrahedron.getId() + " : " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateBaseArea(Tetrahedron tetrahedron) {
        double area = calculateFaceArea(tetrahedron.getDot2(), tetrahedron.getDot3(), tetrahedron.getDot4());
        LOGGER.info("Base area of tetrahedron with id=" + tetrahedron.getId() + " : " + area);

        return area;
    }

    @Override
    public double calculateDistanceBetweenPoints(Dot a, Dot b) {
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();
        double z = a.getZ() - b.getZ();

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    private class Triangle {

        private final Dot dot1;
        private final Dot dot2;
        private final Dot dot3;

        Triangle(Dot dot1, Dot dot2, Dot dot3) {
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
    private List<Triangle> triangleList(Tetrahedron tetrahedron) {
        Dot dot1 = tetrahedron.getDot1();
        Dot dot2 = tetrahedron.getDot2();
        Dot dot3 = tetrahedron.getDot3();
        Dot dot4 = tetrahedron.getDot4();

        Triangle triangle1 = new Triangle(dot1, dot2, dot3);
        Triangle triangle2 = new Triangle(dot1, dot2, dot4);
        Triangle triangle3 = new Triangle(dot1, dot3, dot4);
        Triangle triangle4 = new Triangle(dot2, dot3, dot4);

        return asList(triangle1, triangle2, triangle3, triangle4);
    }

    private double calculateFaceArea(Dot point1, Dot point2, Dot point3) {
        double edge1 = calculateDistanceBetweenPoints(point1, point2);
        double edge2 = calculateDistanceBetweenPoints(point2, point3);
        double edge3 = calculateDistanceBetweenPoints(point3, point1);
        double p = (edge1 + edge2 + edge3) / 2;

        return Math.sqrt(p * (p - edge1) * (p - edge2) * (p - edge3));
    }

}
