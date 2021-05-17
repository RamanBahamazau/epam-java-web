package com.bahamazau.impl.tetrahedron.comporator;

import static org.junit.Assert.assertEquals;

import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import org.junit.Test;

public class TetrahedronIdComparatorTest {

    private final TetrahedronIdComparator comparator = new TetrahedronIdComparator();

    @Test
    public void shouldReturnMinusOne_whenCompare_givenFirstShapeWithIdLessThenSecond() {
        // given
        Tetrahedron tetrahedron1 = new Tetrahedron(1L, null);
        Tetrahedron tetrahedron2 = new Tetrahedron(2L, null);

        int expected = -1;
        // when
        int actual = comparator.compare(tetrahedron1, tetrahedron2);
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMinusOne_whenCompare_givenShapesWithSameId() {
        // given
        Tetrahedron tetrahedron1 = new Tetrahedron(1L, null);
        Tetrahedron tetrahedron2 = new Tetrahedron(1L, null);

        int expected = 0;
        // when
        int actual = comparator.compare(tetrahedron1, tetrahedron2);
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnOne_whenCompare_givenFirstShapeWithIdGreaterThenSecond() {
        // given
        Tetrahedron tetrahedron1 = new Tetrahedron(2L, null);
        Tetrahedron tetrahedron2 = new Tetrahedron(1L, null);

        int expected = 1;
        // when
        int actual = comparator.compare(tetrahedron1, tetrahedron2);
        // then
        assertEquals(expected, actual);
    }

}
