package com.bahamazau.impl.service.custom;

import com.bahamazau.api.entity.ArrayEntity;
import com.bahamazau.api.service.SearchService;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class SearchServiceImpl implements SearchService {

    @Override
    public OptionalInt findMax(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();

            int maxValue = array[0];
            for (int element: array) {
                maxValue = element > maxValue ? element : maxValue;
            }

            return OptionalInt.of(maxValue);
        }

        return OptionalInt.empty();
    }

    @Override
    public OptionalInt findMin(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();

            int minValue = array[0];
            for (int element: array) {
                minValue = element < minValue ? element : minValue;
            }

            return OptionalInt.of(minValue);
        }

        return OptionalInt.empty();
    }

    @Override
    public OptionalDouble findAvg(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            final int[] array = arrayEntity.copyData().get();
            double avgValue = (double) sum(arrayEntity) / array.length;
            return OptionalDouble.of(avgValue);
        }

        return OptionalDouble.empty();
    }

    @Override
    public OptionalInt findSum(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            int sum = sum(arrayEntity);
            return OptionalInt.of(sum);
        }

        return OptionalInt.empty();
    }

    @Override
    public OptionalLong findCountPositiveElements(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            int count = 0;
            for (int element: arrayEntity.copyData().get()) {
                if (element > 0) {
                    count ++;
                }
            }
            return OptionalLong.of(count);
        }

        return OptionalLong.empty();
    }

    @Override
    public OptionalLong findCountNegativeElements(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            int count = 0;
            for (int element: arrayEntity.copyData().get()) {
                if (element < 0) {
                    count ++;
                }
            }

            return OptionalLong.of(count);
        }

        return OptionalLong.empty();
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
