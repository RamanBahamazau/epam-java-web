package com.bahamazau.api.service;

import com.bahamazau.api.entity.ArrayEntity;

import java.util.Optional;

public interface SearchService {

    public Optional<Integer> findMax(ArrayEntity arrayEntity);
    public Optional<Integer> findMin(ArrayEntity arrayEntity);

    public Optional<Integer> findAvg(ArrayEntity arrayEntity);
    public Optional<Integer> findSum(ArrayEntity arrayEntity);

    public Optional<Integer> findCountPositiveElements(ArrayEntity arrayEntity);
    public Optional<Integer> findCountNegativeElements(ArrayEntity arrayEntity);

}
