package com.bahamazau.impl.service;

import com.bahamazau.api.entity.ArrayEntity;
import com.bahamazau.api.service.SearchService;

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

    @Override
    public Optional<Integer> findAvg(ArrayEntity arrayEntity) {
        int avgValue = 0;
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();
            avgValue = sum(arrayEntity) / array.length;
        }

        return Optional.ofNullable(avgValue);
    }

    @Override
    public Optional<Integer> findSum(ArrayEntity arrayEntity) {
        return Optional.ofNullable(sum(arrayEntity));
    }

    private int sum(ArrayEntity arrayEntity) {
        int sum = 0;
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();

            for (int element: array) {
                sum += element;
            }
        }

        return sum;
    }

    @Override
    public Optional<Integer> findCountPositiveElements(ArrayEntity arrayEntity) {
        int count = 0;
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();

            for (int element: array) {
                if (element > 0) {
                    count ++;
                }
            }
        }

        return Optional.ofNullable(count);
    }

    @Override
    public Optional<Integer> findCountNegativeElements(ArrayEntity arrayEntity) {
        int count = 0;
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();

            for (int element: array) {
                if (element < 0) {
                    count ++;
                }
            }
        }

        return Optional.ofNullable(count);
    }

}
