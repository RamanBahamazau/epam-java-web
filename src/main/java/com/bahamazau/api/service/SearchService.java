package com.bahamazau.api.service;

import com.bahamazau.entity.ArrayEntity;

import java.util.Optional;

public interface SearchService {

    Optional<Integer> findMax(ArrayEntity arrayEntity);
    Optional<Integer> findMin(ArrayEntity arrayEntity);

}
