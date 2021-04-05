package com.bahamazau.impl.service;

import com.bahamazau.api.entity.ArrayEntity;
import com.bahamazau.api.service.UpdateService;

public class UpdateServiceImpl implements UpdateService {

    @Override
    public void replaceArrayElement(ArrayEntity arrayEntity, int newElement, int oldElement) {
        if (arrayEntity.copyData().isPresent()) {
            int[] newArray = new int[arrayEntity.copyData().get().length];
            for (int index = 0; index < arrayEntity.copyData().get().length; index++) {
                newArray[index] = arrayEntity.copyData().get()[index] == oldElement ? newElement : oldElement;
            }

            arrayEntity.setData(newArray);
        }
    }
}
