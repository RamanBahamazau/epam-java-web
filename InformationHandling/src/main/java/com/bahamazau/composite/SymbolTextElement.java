package com.bahamazau.composite;

import static com.bahamazau.composite.TextType.*;

import com.bahamazau.composite.common.TextElementMother;

public class SymbolTextElement extends TextElementMother {

    private char value;

    public SymbolTextElement(char value) {
        super(SYMBOL);
        this.value = value;
    }

}
