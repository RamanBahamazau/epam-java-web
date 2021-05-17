package com.bahamazau.impl.tetrahedron.repository;

import com.bahamazau.api.repository.ShapeRepository;
import com.bahamazau.api.repository.specification.ShapeSpecification;
import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TetrahedronRepository implements ShapeRepository<Tetrahedron> {

    private static final Logger LOGGER = LogManager.getLogger();

    private static TetrahedronRepository instance;

    private final ArrayList<Tetrahedron> tetrahedrons = new ArrayList<>();

    public static TetrahedronRepository getInstance() {
        if (instance == null) {
            instance = new TetrahedronRepository();
        }

        return instance;
    }

    @Override
    public void add(Tetrahedron tetrahedron){
        tetrahedrons.add(tetrahedron);
        LOGGER.info("Tetrahedron was added to repository.");
    }

    @Override
    public void remove(Tetrahedron tetrahedron){
        tetrahedrons.remove(tetrahedron);
        LOGGER.info("Tetrahedron was removed from repository.");
    }

    public Tetrahedron getTetrahedron(int index){
        return tetrahedrons.get(index);
    }

    @Override
    public long nextId() {
        int size = tetrahedrons.size();
        return ++size;
    }

    @Override
    public List<Tetrahedron> query(ShapeSpecification<Tetrahedron> specification) {
        List<Tetrahedron> tetrahedronList = tetrahedrons.stream().filter(specification::specify).collect(Collectors.toList());

        LOGGER.info("Tetrahedron list was filtered.");
        return tetrahedronList;
    }

    @Override
    public List<Tetrahedron> sort(Comparator<? super Tetrahedron> comparator) {
        List<Tetrahedron> tetrahedronList = tetrahedrons.stream().sorted(comparator).collect(Collectors.toList());

        LOGGER.info("Tetrahedron list was sorted.");
        return tetrahedronList;
    }

}
