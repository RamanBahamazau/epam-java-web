package com.bahamazau.impl.service.stream;

import com.bahamazau.api.entity.ArrayEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SortServiceImplUnitTest {

    private final SortServiceImpl service = new SortServiceImpl();

    @ParameterizedTest
    @MethodSource("sortData")
    public void whenSort_givenSortData(int[] array, int[] expected) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        // when
        service.sort(arrayEntity);
        // then
        assertNotEquals(arrayEntity.copyData(), Optional.empty());
        assertEquals(arrayEntity.copyData().get()[0], expected[0]);
    }

    public static Object[][] sortData() {
        return new Object[][] {
                {new int[] {1, 2, 3}, new int[]{1, 2, 3}},
                {new int[] {2, 3, 1}, new int[]{1, 2, 3}},
                {new int[] {3, 2, 1}, new int[]{1, 2, 3}}
        };
    }

}
