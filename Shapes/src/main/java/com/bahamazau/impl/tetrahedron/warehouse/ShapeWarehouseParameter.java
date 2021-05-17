package com.bahamazau.impl.tetrahedron.warehouse;

import java.util.Objects;

public class ShapeWarehouseParameter {

    private final double surfaceArea;
    private final double volume;
    private final double perimeter;

    public ShapeWarehouseParameter(double surfaceArea, double volume, double perimeter) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeWarehouseParameter that = (ShapeWarehouseParameter) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 && Double.compare(that.volume, volume) == 0 && Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(surfaceArea, volume, perimeter);
    }

}
