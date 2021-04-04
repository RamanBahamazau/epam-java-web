package com.bahamazau.impl.service;

import com.bahamazau.api.entity.ArrayEntity;
import com.bahamazau.api.service.SortService;

public class SortServiceImpl implements SortService {

    public void bubbleSort(ArrayEntity arrayEntity) {
        arrayEntity.copyData().ifPresent(currentArray -> {
            int n = currentArray.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (currentArray[j] > currentArray[j + 1]) {
                        int temp = currentArray[j];
                        currentArray[j] = currentArray[j + 1];
                        currentArray[j + 1] = temp;
                    }
                }
            }
            arrayEntity.setData(currentArray);
        });
    }

    public void quickSort(ArrayEntity arrayEntity, int left, int right) {
        arrayEntity.copyData().ifPresent(currentArray -> {
            quickSort(currentArray, left, right);
            arrayEntity.setData(currentArray);
        });
    }

    public void selectSort(ArrayEntity arrayEntity) {
        arrayEntity.copyData().ifPresent(currentArray -> {
            int n = currentArray.length;
            for (int i = 0; i < n - 1; i++) {
                int current = i;
                for (int j = i + 1; j < n; j++) {
                    if (currentArray[j] < currentArray[current]) {
                        current = j;
                    }
                }
                int temp = currentArray[current];
                currentArray[current] = currentArray[i];
                currentArray[i] = temp;
            }
            arrayEntity.setData(currentArray);
        });
    }

    private void quickSort(int[] currentArray, int left, int right) {
        int middle = (left + right) / 2;
        int middleValue = currentArray[middle];
        int i = left, j = right;
        while (i <= j) {
            while (currentArray[i] < middleValue) {
                i++;
            }
            while (currentArray[j] > middleValue) {
                j--;
            }
            if (i <= j) {
                int temp = currentArray[i];
                currentArray[i] = currentArray[j];
                currentArray[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(currentArray, left, j);
        }
        if (right > i) {
            quickSort(currentArray, i, right);
        }
    }

}
