package com.bahamazau.api;

import com.bahamazau.impl.tetrahedron.observer.TetrahedronEvent;

public interface Observer {

    void changeParameters(TetrahedronEvent event);

}
