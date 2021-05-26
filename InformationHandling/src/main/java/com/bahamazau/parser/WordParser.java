package com.bahamazau.parser;

import com.bahamazau.composite.SymbolTextElement;
import com.bahamazau.composite.TextElement;
import com.bahamazau.composite.common.TextElementMother;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.bahamazau.composite.TextType.*;

public class WordParser extends TextParserMother {

    protected WordParser() {
        super(WORD, "");
    }

    @Override
    public TextElementMother parse(String text) {
        String[] textElementValues = text.split(regex);

        List<TextElementMother> symbolTextElementList = new ArrayList<>();
        Arrays.stream(textElementValues).forEach(textElementValue -> {
            if (!textElementValue.isEmpty()) {
                SymbolTextElement symbolTextElement = new SymbolTextElement(textElementValue.charAt(0));
                symbolTextElementList.add(symbolTextElement);
            }
        });

        List<TextElementMother> textElementList = new ArrayList<>();
        if (!symbolTextElementList.isEmpty()) {
            TextElement textElement = new TextElement(textType, symbolTextElementList);
            textElementList.add(textElement);
        }

        return new TextElement(textType, textElementList);
    }

}