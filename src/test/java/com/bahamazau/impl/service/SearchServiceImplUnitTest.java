package com.bahamazau.impl.service;

import com.bahamazau.api.entity.ArrayEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchServiceImplUnitTest {

    private static final Integer MAX_VALUE = 3;
    private static final Integer MIN_VALUE = 1;

    private final SearchServiceImpl service = new SearchServiceImpl();

    @ParameterizedTest
    @MethodSource("findMaxData")
    public void whenFindMax_givenFindMaxData(int[] array, Integer expectedValue) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        Optional<Integer> expected = Optional.ofNullable(expectedValue);
        // when
        Optional<Integer> actual = service.findMax(arrayEntity);
        // then
        assertEquals(actual, expected);
    }

    public static Object[][] findMaxData() {
        return new Object[][] {
                {new int[0] , null},
                {new int[] {1, 2, MAX_VALUE}, MAX_VALUE},
                {new int[] {1, MAX_VALUE, 2}, MAX_VALUE},
                {new int[] {MAX_VALUE, 2, 1}, MAX_VALUE}
        };
    }

    @ParameterizedTest
    @MethodSource("findMinData")
    public void whenFindMin_givenFindMinData(int[] array, Integer expectedValue) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        Optional<Integer> expected = Optional.ofNullable(expectedValue);
        // when
        Optional<Integer> actual = service.findMin(arrayEntity);
        // then
        assertEquals(actual, expected);
    }

    public static Object[][] findMinData() {
        return new Object[][] {
                {new int[0] , null},
                {new int[] {MIN_VALUE, 2, 3}, MIN_VALUE},
                {new int[] {3, MIN_VALUE, 2}, MIN_VALUE},
                {new int[] {3, 2, MIN_VALUE}, MIN_VALUE}
        };
    }

    @ParameterizedTest
    @MethodSource("findAvgData")
    public void whenFindAvg_givenFindAvgData(int[] array, Double expectedValue) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        Optional<Double> expected = Optional.ofNullable(expectedValue);
        // when
        Optional<Double> actual = service.findAvg(arrayEntity);
        // then
        assertEquals(actual, expected);
    }

    private static Object[][] findAvgData() {
        return new Object[][] {
                {new int[0] , null},
                {new int[] {3, 2, 1}, 2d},
                {new int[] {3, 2}, 2.5d},
                {new int[] {3}, 3d}
        };
    }

    @ParameterizedTest
    @MethodSource("findSumData")
    public void whenFindSum_givenFindSumData(int[] array, Integer expectedValue) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        Optional<Integer> expected = Optional.ofNullable(expectedValue);
        // when
        Optional<Integer> actual = service.findSum(arrayEntity);
        // then
        assertEquals(actual, expected);
    }

    private static Object[][] findSumData() {
        return new Object[][] {
                {new int[0] , null},
                {new int[] {3, 2, 1}, 6}
        };
    }

    @ParameterizedTest
    @MethodSource("findCountPositiveElementsData")
    public void whenFindCountPositiveElements_givenFindCountPositiveElementsData(int[] array, Integer expectedValue) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        Optional<Integer> expected = Optional.ofNullable(expectedValue);
        // when
        Optional<Integer> actual = service.findCountPositiveElements(arrayEntity);
        // then
        assertEquals(actual, expected);
    }

    private static Object[][] findCountPositiveElementsData() {
        return new Object[][] {
                {new int[0] , null},
                {new int[] {1, 2, 3}, 3},
                {new int[] {0, 1, 2}, 2},
                {new int[] {-1, 0, 1}, 1},
                {new int[] {-1, -1, 0}, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("findCountNegativeElementsData")
    public void whenFindCountNegativeElements_givenFindCountNegativeElementsData(int[] array, Integer expectedValue) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        Optional<Integer> expected = Optional.ofNullable(expectedValue);
        // when
        Optional<Integer> actual = service.findCountNegativeElements(arrayEntity);
        // then
        assertEquals(actual, expected);
    }

    private static Object[][] findCountNegativeElementsData() {
        return new Object[][] {
                {new int[0] , null},
                {new int[] {-1, -2, -3}, 3},
                {new int[] {0, -1, -2}, 2},
                {new int[] {-1, 0, 1}, 1},
                {new int[] {0, 1, 2}, 0}
        };
    }

}
