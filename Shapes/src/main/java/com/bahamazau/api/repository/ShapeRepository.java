package com.bahamazau.api.repository;

import com.bahamazau.api.repository.specification.ShapeSpecification;

import java.util.Comparator;
import java.util.List;

public interface ShapeRepository<Shape> {

    public void add(Shape shape);
    public void remove(Shape shape);

    public long nextId();

    public List<Shape> query(ShapeSpecification<Shape> specification);
    public List<Shape> sort(Comparator<? super Shape> comparator);

}
