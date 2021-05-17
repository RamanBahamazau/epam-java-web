package com.bahamazau.api.observer;

public interface ShapeObservable {

    public void attach(ShapeObserver shapeObserver);
    public void detach(ShapeObserver shapeObserver);
    public void notifyObservers();

}
