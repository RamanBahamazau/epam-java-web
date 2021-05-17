package com.bahamazau.impl.tetrahedron.service.parser;

import com.bahamazau.api.entity.dot.Dot;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TetrahedronPointsParserUnitTest {

    private final TetrahedronPointsParser parser = new TetrahedronPointsParser();

    @Test
    public void shouldReturnListDot_whenReadDataFromFile_givenNotEmptyString() {
        // given
        final String inputLine = "0.5 0.288 0.816 0 0 0 1 0 0 0.5 0.866 0";

        List<Double[]> expected = Arrays.asList(
                new Double[] {0.5, 0.288, 0.816},
                new Double[] {0d, 0d, 0d},
                new Double[] {1d, 0d, 0d},
                new Double[] {0.5, 0.866, 0d}
        );
        // when
        List<Dot> actual = parser.parseDots(inputLine);
        // then
        for (int i = 0; i < actual.size(); i++) {
            double actualX = actual.get(i).getX();
            double expectedX = expected.get(i)[0];
            assertEquals(actualX, expectedX, 0);

            double actualY = actual.get(i).getY();
            double expectedY = expected.get(i)[1];
            assertEquals(actualY, expectedY,0);

            double actualZ = actual.get(i).getZ();
            double expectedZ = expected.get(i)[2];
            assertEquals(actualZ, expectedZ, 0);
        }
    }

    @Test
    public void shouldReturnEmptyList_whenReadDataFromFile_givenNotValidStringWithElevenPoints() {
        // given
        final String inputLine = "0.5 0.288 0.816 0 0 0 1 0 0 0.5 0.866";
        // when
        List<Dot> actual = parser.parseDots(inputLine);
        // then
        assertEquals(actual, new ArrayList<>());
    }

}
