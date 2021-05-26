package com.bahamazau.composite.common;

import com.bahamazau.composite.TextType;

public abstract class TextElementMother {

    protected TextType textType;

    protected TextElementMother(TextType textType) {
        this.textType = textType;
    }

    public TextType getTextType() {
        return textType;
    }

}
