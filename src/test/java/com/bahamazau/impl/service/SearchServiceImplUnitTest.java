package com.bahamazau.impl.service;

import com.bahamazau.api.entity.ArrayEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchServiceImplUnitTest {

    private static final Optional<Integer> MAX_VALUE_OPTIONAL = Optional.of(3);
    private static final Optional<Integer> MIN_VALUE_OPTIONAL = Optional.of(1);

    private final SearchServiceImpl service = new SearchServiceImpl();

    public static Object[][] findMaxData() {
        return new Object[][] {
                {new int[0] , Optional.empty()},
                {new int[] {1, 2, 3}, MAX_VALUE_OPTIONAL},
                {new int[] {1, 3, 2}, MAX_VALUE_OPTIONAL},
                {new int[] {3, 2, 1}, MAX_VALUE_OPTIONAL}
        };
    }

    @ParameterizedTest
    @MethodSource("findMaxData")
    public void shouldReturnEmpty_whenFindMax(int[] array, Optional<Integer> expected) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        // when
        Optional<Integer> actual = service.findMax(arrayEntity);
        // then
        assertEquals(actual, expected);
    }

    public static Object[][] findMinData() {
        return new Object[][] {
                {new int[0] , Optional.empty()},
                {new int[] {1, 2, 3}, MIN_VALUE_OPTIONAL},
                {new int[] {1, 3, 2}, MIN_VALUE_OPTIONAL},
                {new int[] {3, 2, 1}, MIN_VALUE_OPTIONAL}
        };
    }

    @ParameterizedTest
    @MethodSource("findMinData")
    public void shouldReturnEmpty_whenFindMin(int[] array, Optional<Integer> expected) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        // when
        Optional<Integer> actual = service.findMin(arrayEntity);
        // then
        assertEquals(actual, expected);
    }

}
