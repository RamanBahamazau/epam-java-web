package com.bahamazau.parser;

import com.bahamazau.composite.TextElement;
import com.bahamazau.composite.TextType;
import com.bahamazau.composite.common.TextElementMother;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TextParser {

    protected final String regex;

    protected TextType textType;
    protected TextParser[] nextParsers;

    protected TextParser(TextType textType, String regex, TextParser... nextParsers) {
        this.textType = textType;
        this.regex = regex;
        this.nextParsers = nextParsers;
    }

    public List<TextElementMother> parse(String text) {
        List<TextElementMother> textElementList = new ArrayList<>();
        Arrays.stream(nextParsers).forEach(nextParser -> {
            String[] textElementValues = text.split(regex);

            List<TextElementMother> childTextElementList = parse(textElementValues, nextParser);
            textElementList.addAll(childTextElementList);
        });

        return textElementList;
    }

    private List<TextElementMother> parse(String[] textElementValues, TextParser nextParser) {
        List<TextElementMother> textElementList = new ArrayList<>();
        Arrays.stream(textElementValues).forEach(textElementValue -> {
            List<TextElementMother> childTextElements = nextParser.parse(textElementValue);

            TextElement textElement = new TextElement(textType, childTextElements);
            textElementList.add(textElement);
        });

        return textElementList;
    }

}