package com.bahamazau.impl.service.stream;

import com.bahamazau.api.entity.ArrayEntity;

import java.util.Arrays;

public class SortServiceImpl {

    public void sort(ArrayEntity arrayEntity) {
        arrayEntity.copyData().ifPresent(array -> {
            int[] sortedArray = Arrays.stream(array).sorted().toArray();
            arrayEntity.setData(sortedArray);
        });
    }

}
