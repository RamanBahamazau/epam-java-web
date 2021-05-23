package com.bahamazau.composite.common;

import com.bahamazau.composite.TextElement;

public interface TextCompositeListener {

    public void add(TextElementMother textElement);
    public void update(TextElementMother oldTextElement, TextElement newTextElement);
    public void remove(TextElementMother textElement);

}
