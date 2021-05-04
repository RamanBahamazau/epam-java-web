package com.bahamazau.impl.tetrahedron.warehouse;

public class TetrahedronParameter {

    private double surfaceArea;
    private double volume;
    private double perimeter;

    public TetrahedronParameter(double surfaceArea, double volume, double perimeter) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
        this.perimeter = perimeter;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getPerimeter() {
        return perimeter;
    }
}
