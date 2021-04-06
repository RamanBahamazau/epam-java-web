package com.bahamazau.impl.service.stream;

import com.bahamazau.api.entity.ArrayEntity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateServiceImplUnitTest {

    private final UpdateServiceImpl service = new UpdateServiceImpl();

    @ParameterizedTest
    @MethodSource("replaceArrayElementData")
    public void whenReplaceArrayElement_givenReplaceArrayElementData(int[] array, int newElement, int oldElement, int[] expected) {
        // given
        ArrayEntity arrayEntity = new ArrayEntity(array);
        // when
        service.replaceArrayElement(arrayEntity, newElement, oldElement);
        // then
        assertEquals(arrayEntity.copyData().get()[0], expected[0]);
    }

    public static Object[][] replaceArrayElementData() {
        return new Object[][] {
                {new int[] {1, 1, 3}, 1, 3, new int[]{3, 3, 3}}
        };
    }

}
