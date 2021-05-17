package com.bahamazau.impl.tetrahedron.comparator;

import com.bahamazau.api.entity.dot.Dot;
import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class TetrahedronVolumeComparatorTest {

    private final Comparator<Tetrahedron> comparator = new TetrahedronVolumeComparator();

    private final List<Dot> tetrahedronDotList1 = asList(
            new Dot(0.5, 0.288, 0.816),
            new Dot(0, 0, 0),
            new Dot(1, 0, 0),
            new Dot(0.5, 0, 0.866));
    private final List<Dot> tetrahedronDotList2 = asList(
            new Dot(0, 0, 0),
            new Dot(0, 1, 2),
            new Dot(0, 2, 2),
            new Dot(3, 3, 2));

    @Test
    public void shouldReturnMinusOne_whenCompare_givenFirstShapeWithVolumeLessThenSecond() {
        // given
        Tetrahedron tetrahedron1 = new Tetrahedron(1L, tetrahedronDotList1);
        Tetrahedron tetrahedron2 = new Tetrahedron(2L, tetrahedronDotList2);

        int expected = -1;
        // when
        int actual = comparator.compare(tetrahedron1, tetrahedron2);
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMinusOne_whenCompare_givenShapesWithSameVolume() {
        // given
        Tetrahedron tetrahedron1 = new Tetrahedron(1L, tetrahedronDotList1);
        Tetrahedron tetrahedron2 = new Tetrahedron(2L, tetrahedronDotList1);

        int expected = 0;
        // when
        int actual = comparator.compare(tetrahedron1, tetrahedron2);
        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnOne_whenCompare_givenFirstShapeWithVolumeGreaterThenSecond() {
        // given
        Tetrahedron tetrahedron1 = new Tetrahedron(1L, tetrahedronDotList2);
        Tetrahedron tetrahedron2 = new Tetrahedron(2L, tetrahedronDotList1);

        int expected = 1;
        // when
        int actual = comparator.compare(tetrahedron1, tetrahedron2);
        // then
        assertEquals(expected, actual);
    }

}
