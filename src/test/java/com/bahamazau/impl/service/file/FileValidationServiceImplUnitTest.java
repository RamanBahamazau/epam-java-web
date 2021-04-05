package com.bahamazau.impl.service.file;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileValidationServiceImplUnitTest {

    private final FileValidationService service = new FileValidationService();

    @ParameterizedTest
    @MethodSource("containOnlyDigitsData")
    public void whenContainOnlyDigits_givenContainOnlyDigitsData(String nextLine, boolean expected) {
        // when
        boolean actual = service.containOnlyDigits(nextLine);
        // then
        assertEquals(actual, expected);
    }

    private static Object[][] containOnlyDigitsData() {
        return new Object[][] {
                {"" , false},
                {"Test string" , false},
                {"1z1 21 32" , false},
                {"0z 1d 2d" , false},
                {"-1 0 1", true},
                {"1 2 3", true}
        };
    }

}
