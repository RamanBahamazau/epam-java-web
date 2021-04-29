package com.bahamazau.impl.entity;

import com.bahamazau.api.Observable;
import com.bahamazau.api.Observer;
import com.bahamazau.impl.entity.dot.Dot;
import com.bahamazau.impl.observer.TetrahedronEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Dot getDot1() {
        return dots.get(0);
    }

    public void setDot1(Dot dot) {
        this.dots.set(0, dot);
        notifyObservers();
    }

    public Dot getDot2() {
        return dots.get(1);
    }

    public void setDot2(Dot dot) {
        this.dots.set(1, dot);
        notifyObservers();
    }

    public Dot getDot3() {
        return dots.get(2);
    }

    public void setDot3(Dot dot) {
        this.dots.set(2, dot);
        notifyObservers();
    }

    public Dot getDot4() {
        return dots.get(3);
    }

    public void setDot4(Dot dot) {
        this.dots.set(3, dot);
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return id == that.id && observers.equals(that.observers)
                && getDot1().equals(that.getDot1()) && getDot2().equals(that.getDot2())
                && getDot3().equals(that.getDot3()) && getDot4().equals(that.getDot4());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getDot1(), getDot2(), getDot3(), getDot4(), observers);
    }

    @Override
    public String toString() {
        return new StringBuilder("Tetrahedron {\n")
                .append(" ID: ").append(id).append('\n')
                .append(" Dot 1: ").append(getDot1()).append('\n')
                .append(" Dot 2: ").append(getDot2()).append('\n')
                .append(" Dot 3: ").append(getDot3()).append('\n')
                .append(" Dot 4: ").append(getDot4()).append('\n')
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
