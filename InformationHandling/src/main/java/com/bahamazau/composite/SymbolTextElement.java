package com.bahamazau.composite;

import com.bahamazau.composite.common.TextElementMother;

public class SymbolTextElement extends TextElementMother {

    private char value;

    protected SymbolTextElement(TextType textType, char value) {
        super(textType);
        this.value = value;
    }

}
