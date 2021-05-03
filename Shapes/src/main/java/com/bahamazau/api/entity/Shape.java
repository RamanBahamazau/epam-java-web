package com.bahamazau.api.entity;

import com.bahamazau.api.entity.dot.Dot;

import java.util.List;

public abstract class Shape {

    protected long id;
    protected List<Dot> dots;

    public long getId() {
        return id;
    }

    public List<Dot> getDots() {
        return dots;
    }

}
