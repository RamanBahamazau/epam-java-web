package com.bahamazau.api.service;

import com.bahamazau.api.entity.ArrayEntity;

public interface SortService {

    void bubbleSort(ArrayEntity arrayEntity);
    void quickSort(ArrayEntity arrayEntity, int left, int right);
    void selectSort(ArrayEntity arrayEntity);

}
