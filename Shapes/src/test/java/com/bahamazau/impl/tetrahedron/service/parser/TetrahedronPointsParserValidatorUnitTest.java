package com.bahamazau.impl.tetrahedron.service.parser;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TetrahedronPointsParserValidatorUnitTest {

    private final TetrahedronPointsParserValidator validator = new TetrahedronPointsParserValidator();

    @Test
    public void shouldReturnFalse_whenIsLineValid_givenNotValidStringWithElevenElements() {
        // given
        final String inputLine = "0.5 0.288 0.816 0 0 0 1 0 0 0.5 0.866";
        // when
        boolean actual = validator.isLineValid(inputLine);
        // then
        assertFalse(actual);
    }

    @Test
    public void shouldReturnFalse_whenIsLineValid_givenNotValidStringWithTextElement() {
        // given
        final String inputLine = "0.5 text 0.816 0 0 0 1 0 0 0.5 0.866 0";
        // when
        boolean actual = validator.isLineValid(inputLine);
        // then
        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrue_whenIsLineValid_givenValidString() {
        // given
        final String inputLine = "0.5 0.288 0.816 0 0 0 1 0 0 0.5 0.866 0";
        // when
        boolean actual = validator.isLineValid(inputLine);
        // then
        assertTrue(actual);
    }

}
