package com.bahamazau.composite;

import com.bahamazau.composite.common.TextCompositeListener;
import com.bahamazau.composite.common.TextElementMother;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextElement extends TextElementMother implements TextCompositeListener {

    private List<TextElementMother> textElements = new ArrayList<>();

    public TextElement(TextType textType, List<TextElementMother> textElements) {
        super(textType);
        this.textElements = textElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextElement that = (TextElement) o;
        return textType.equals(that.textType) && textElements.equals(that.textElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textType, textElements);
    }

    @Override
    public void add(TextElementMother textElement) {
        textElements.add(textElement);
    }

    @Override
    public void update(TextElementMother oldTextElement, TextElement newTextElement) {
        int indexOfOldElement = textElements.indexOf(oldTextElement);
        textElements.set(indexOfOldElement, newTextElement);
    }

    @Override
    public void remove(TextElementMother textElement) {
        textElements.remove(textElement);
    }

}
