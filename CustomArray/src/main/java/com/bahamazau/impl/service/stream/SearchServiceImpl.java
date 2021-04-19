package com.bahamazau.impl.service.stream;

import com.bahamazau.api.entity.ArrayEntity;
import com.bahamazau.api.service.SearchService;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class SearchServiceImpl implements SearchService {

    @Override
    public OptionalInt findMax(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            return Arrays.stream(arrayEntity.copyData().get()).max();
        }

        return OptionalInt.empty();
    }

    @Override
    public OptionalInt findMin(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            return Arrays.stream(arrayEntity.copyData().get()).min();
        }

        return OptionalInt.empty();
    }

    @Override
    public OptionalDouble findAvg(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            return Arrays.stream(arrayEntity.copyData().get()).average();
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
            long count = Arrays.stream(arrayEntity.copyData().get()).filter(value -> value > 0).count();
            return OptionalLong.of(count);
        }

        return OptionalLong.empty();
    }

    @Override
    public OptionalLong findCountNegativeElements(ArrayEntity arrayEntity) {
        if (arrayEntity.copyData().isPresent()) {
            long count = Arrays.stream(arrayEntity.copyData().get()).filter(value -> value < 0).count();
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
