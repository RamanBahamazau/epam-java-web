package com.bahamazau.api.service;

import com.bahamazau.api.entity.ArrayEntity;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface SearchService {

    public OptionalInt findMax(ArrayEntity arrayEntity);
    public OptionalInt findMin(ArrayEntity arrayEntity);

    public OptionalDouble findAvg(ArrayEntity arrayEntity);
    public OptionalInt findSum(ArrayEntity arrayEntity);

    public OptionalLong findCountPositiveElements(ArrayEntity arrayEntity);
    public OptionalLong findCountNegativeElements(ArrayEntity arrayEntity);

}
