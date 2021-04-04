package com.bahamazau.entity;

import java.util.Arrays;
import java.util.Optional;

public class ArrayEntity {

    private int[] data;

    public ArrayEntity(int... data) {
        this.data = data;
    }

    public Optional<int[]> selectData() {
        int[] data = new int[this.data.length];
        System.arraycopy(this.data, 0, data, 0, this.data.length);

        return Optional.ofNullable(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayEntity that = (ArrayEntity) o;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    @Override
    public String toString() {
        return "ArrayEntity{" +
                "currentArray=" + Arrays.toString(data) +
                '}';
    }
}
