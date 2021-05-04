package com.bahamazau.impl.tetrahedron.service;

import com.bahamazau.impl.tetrahedron.exception.CustomException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.bahamazau.impl.tetrahedron.service.TetrahedronFileReaderService.FILE_NOT_FOUND_MSG;
import static com.bahamazau.impl.tetrahedron.service.TetrahedronFileReaderService.FILE_PATH_IS_EMPTY_MSG;
import static org.junit.Assert.assertEquals;

public class TetrahedronFileReaderServiceUnitTest {

    private static final TetrahedronFileReaderService dataReader = new TetrahedronFileReaderService();

    @Test
    public void shouldReturnListStringFromFile_whenReadDataFromFile_givenExistingFile() throws CustomException {
        // given
        final String filePath = "./src/main/resources/data/data.txt";

        String[] list = {
                "0.5 0.288 0.816 0 0 0 1 0 0 0.5 0.866 0",
                "2.0 -1   1  5 5 3 2.0  -1 4 1  3",
                "1 3 6  2 2 1  -1 0 1  -4 6 -3",
                "2.0 -1   1  5 5 4  3 2.0     -1  4      1  3",
                "14 4 5   -5f -3 2  -2 -6 -3 -2 2 -1",
                "14 4 5   -5 -3 2  -2 -6 -3 -2 2 -1",
                "-4 2 7  2 -3 0  -10 5 8  -5 2 -4",
                "0 -1 2  -1 -1 6 -2 0 2 0 1 4",
                "2 2 2 0 0 0 0 0 0 2 1 0",
                "1 2 3"};
        List<String> expected = Arrays.asList(list);
        // when
        List<String> actual = dataReader.readDataFromFile(filePath);
        // then
        assertEquals(actual, expected);
    }

    @Test
    public void shouldThrowFileNotFoundCustomException_whenReadDataFromFile_givenNotExistingFile() {
        // given
        final String filePath = "./src/main/resources/data/notExistingFile.txt";

        final String expectedErrorMsg = FILE_NOT_FOUND_MSG;
        // when
        String actualErrorMsg = null;
        try {
            dataReader.readDataFromFile(filePath);
        } catch (CustomException actual) {
            actualErrorMsg = actual.getMessage();
        }
        // then
        assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    @Test
    public void shouldThrowFilePathIsEmptyCustomException_whenReadDataFromFile_givenNullFilePath() {
        // given
        final String filePath = null;

        final String expectedErrorMsg = FILE_PATH_IS_EMPTY_MSG;
        // when
        String actualErrorMsg = null;
        try {
            dataReader.readDataFromFile(filePath);
        } catch (CustomException actual) {
            actualErrorMsg = actual.getMessage();
        }
        // then
        assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    @Test
    public void shouldThrowFilePathIsEmptyCustomException_whenReadDataFromFile_givenEmptyFilePath() {
        // given
        final String filePath = "";

        final String expectedErrorMsg = FILE_PATH_IS_EMPTY_MSG;
        // when
        String actualErrorMsg = null;
        try {
            dataReader.readDataFromFile(filePath);
        } catch (CustomException actual) {
            actualErrorMsg = actual.getMessage();
        }
        // then
        assertEquals(actualErrorMsg, expectedErrorMsg);
    }

}
