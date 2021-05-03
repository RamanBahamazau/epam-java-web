package com.bahamazau.impl;

import com.bahamazau.impl.entity.Tetrahedron;

import java.util.ArrayList;

public class TetrahedronContainer {

    private final ArrayList<Tetrahedron> tetrahedrons = new ArrayList<>();
    private long lastId = 0;

    private static TetrahedronContainer instance;

    public static TetrahedronContainer getInstance() {
        if (instance == null) {
            instance = new TetrahedronContainer();
        }

        return instance;
    }

    public void add(Tetrahedron tetrahedron){
        tetrahedrons.add(tetrahedron);
    }

    public void remove(Tetrahedron tetrahedron){
        tetrahedrons.remove(tetrahedron);
    }

    public Tetrahedron getTetrahedron(int index){
        return tetrahedrons.get(index);
    }

    public ArrayList<Tetrahedron> getTetrahedrons(){
        return tetrahedrons;
    }

    public long nextId() {
        return lastId++;
    }

}
