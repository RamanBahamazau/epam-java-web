package com.bahamazau.impl.tetrahedron.service.comporator;

import com.bahamazau.api.ShapeComparator;
import com.bahamazau.api.entity.Shape;

public class TetrahedronIdComparator implements ShapeComparator {

    @Override
    public int compare(Shape o1, Shape o2) {
        return Long.compare(o1.getId(), o2.getId());
    }

}
