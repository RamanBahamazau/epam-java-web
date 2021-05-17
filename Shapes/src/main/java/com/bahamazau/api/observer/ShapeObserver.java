package com.bahamazau.api.observer;

public interface ShapeObserver<ShapeEvent> {

    public void changeParameters(ShapeEvent event);

}
