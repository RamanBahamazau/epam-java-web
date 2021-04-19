package com.bahamazau.impl.service.custom;

import com.bahamazau.api.entity.ArrayEntity;
import com.bahamazau.impl.service.stream.UpdateServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        assertNotEquals(arrayEntity.copyData(), Optional.empty());
        assertEquals(arrayEntity.copyData().get()[0], expected[0]);
    }

    public static Object[][] replaceArrayElementData() {
        return new Object[][] {
                {new int[] {1, 1, 3}, 1, 3, new int[]{3, 3, 3}}
        };
    }

}
