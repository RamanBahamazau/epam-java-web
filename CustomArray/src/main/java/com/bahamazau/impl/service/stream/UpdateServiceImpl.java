package com.bahamazau.impl.service.stream;

import com.bahamazau.api.entity.ArrayEntity;
import com.bahamazau.api.service.UpdateService;

import java.util.Arrays;

public class UpdateServiceImpl implements UpdateService {

    @Override
    public void replaceArrayElement(ArrayEntity arrayEntity, int newElement, int oldElement) {
        arrayEntity.copyData().ifPresent(array -> {
            int[] newArray = new int[array.length];
            final int[] index = {0};
            Arrays.stream(array).forEach(element -> {
                newArray[index[0]] = element == oldElement ? newElement : oldElement;
                index[0]++;
            });

            arrayEntity.setData(newArray);
        });
    }
}
