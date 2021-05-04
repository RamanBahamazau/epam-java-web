package com.bahamazau.impl.tetrahedron.entity;

import com.bahamazau.api.Observable;
import com.bahamazau.api.Observer;
import com.bahamazau.api.entity.Shape;
import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.impl.tetrahedron.observer.TetrahedronEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity of shape "Tetrahedron". Contain id and 4 dots: apex and 3 base dots.
 */
public class Tetrahedron extends Shape implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    Tetrahedron(Long id, List<Dot> dots) {
        this.id = id;
        this.dots = dots;
    }

    public long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
        notifyObservers();
    }

    public Dot getApex() {
        return dots.get(0);
    }

    public void setApex(Dot dot) {
        this.dots.set(0, dot);
        notifyObservers();
    }

    public Dot getBaseDot1() {
        return dots.get(1);
    }

    public void setBaseDot1(Dot dot) {
        this.dots.set(1, dot);
        notifyObservers();
    }

    public Dot getBaseDot2() {
        return dots.get(2);
    }

    public void setBaseDot2(Dot dot) {
        this.dots.set(2, dot);
        notifyObservers();
    }

    public Dot getBaseDot3() {
        return dots.get(3);
    }

    public void setBaseDot3(Dot dot) {
        this.dots.set(3, dot);
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return id == that.id && observers.equals(that.observers)
                && getApex().equals(that.getApex()) && getBaseDot1().equals(that.getBaseDot1())
                && getBaseDot2().equals(that.getBaseDot2()) && getBaseDot3().equals(that.getBaseDot3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getApex(), getBaseDot1(), getBaseDot2(), getBaseDot3(), observers);
    }

    @Override
    public String toString() {
        return new StringBuilder("Tetrahedron {\n")
                .append(" ID: ").append(id).append('\n')
                .append(" Apex Dot: ").append(getApex()).append('\n')
                .append(" Base Dot 1: ").append(getBaseDot1()).append('\n')
                .append(" Base Dot 2: ").append(getBaseDot2()).append('\n')
                .append(" Base Dot 3: ").append(getBaseDot3()).append('\n')
                .append("}")
                .toString();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        TetrahedronEvent event = new TetrahedronEvent(this);
        if (!observers.isEmpty()) {
            for (Observer observer : observers) {
                observer.changeParameters(event);
            }
        }
    }

}
