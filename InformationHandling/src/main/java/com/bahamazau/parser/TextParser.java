package com.bahamazau.parser;

import com.bahamazau.composite.TextElement;
import com.bahamazau.composite.common.TextElementMother;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.bahamazau.composite.TextType.TEXT;

public class TextParser extends TextParserMother {

    protected TextParser(TextParserMother... nextParsers) {
        super(TEXT, null, nextParsers);
    }

    @Override
    public TextElementMother parse(String text) {
        List<TextElementMother> textElementList = new ArrayList<>();
        Arrays.stream(nextParsers).forEach(nextParser -> {
            TextElementMother textElementMother = nextParser.parse(text);
            textElementList.addAll(((TextElement)textElementMother).getTextElements());
        });

        return new TextElement(textType, textElementList);
    }
}
