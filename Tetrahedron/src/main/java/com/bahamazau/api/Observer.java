package com.bahamazau.api;

import com.bahamazau.impl.observer.TetrahedronEvent;

public interface Observer {

    void changeParameters(TetrahedronEvent event);

}
