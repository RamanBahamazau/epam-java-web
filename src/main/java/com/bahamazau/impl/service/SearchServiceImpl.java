package com.bahamazau.impl.service;

import com.bahamazau.api.service.SearchService;
import com.bahamazau.entity.ArrayEntity;

import java.util.Optional;

public class SearchServiceImpl implements SearchService {

    @Override
    public Optional<Integer> findMax(ArrayEntity arrayEntity) {
        Integer maxValue = null;
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();

            maxValue = array[0];
            for (int element: array) {
                maxValue = element > maxValue ? element : maxValue;
            }
        }

        return Optional.ofNullable(maxValue);
    }

    @Override
    public Optional<Integer> findMin(ArrayEntity arrayEntity) {
        Integer minValue = null;
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();

            minValue = array[0];
            for (int element: array) {
                minValue = element < minValue ? element : minValue;
            }
        }

        return Optional.ofNullable(minValue);
    }

}
