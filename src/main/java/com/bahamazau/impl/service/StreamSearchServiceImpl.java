package com.bahamazau.impl.service;

import com.bahamazau.api.entity.ArrayEntity;
import com.bahamazau.api.service.SearchService;

import java.util.Optional;

public class SearchServiceImpl implements SearchService {

    @Override
    public Optional<Integer> findMax(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();

            int maxValue = array[0];
            for (int element: array) {
                maxValue = element > maxValue ? element : maxValue;
            }

            return Optional.of(maxValue);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Integer> findMin(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();

            int minValue = array[0];
            for (int element: array) {
                minValue = element < minValue ? element : minValue;
            }

            return Optional.of(minValue);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Double> findAvg(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();
            Double avgValue = (double) sum(arrayEntity) / array.length;
            return Optional.of(avgValue);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Integer> findSum(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            Integer sum = sum(arrayEntity);
            return Optional.of(sum);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Integer> findCountPositiveElements(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            int count = 0;
            for (int element: arrayEntity.copyData().get()) {
                if (element > 0) {
                    count ++;
                }
            }
            return Optional.of(count);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Integer> findCountNegativeElements(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            int count = 0;
            for (int element: arrayEntity.copyData().get()) {
                if (element < 0) {
                    count ++;
                }
            }

            return Optional.of(count);
        }

        return Optional.empty();
    }

    private int sum(ArrayEntity arrayEntity) {
        int sum = 0;
        if (arrayEntity.copyData().isPresent()) {
            for (int element: arrayEntity.copyData().get()) {
                sum += element;
            }
        }

        return sum;
    }

}
