package com.bahamazau.parser;

import com.bahamazau.composite.TextElement;
import static com.bahamazau.composite.TextType.*;

import com.bahamazau.composite.TextType;
import com.bahamazau.composite.common.TextElementMother;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TextParserMother {

    protected final String regex;

    protected TextType textType;
    protected TextParserMother[] nextParsers;

    protected TextParserMother(TextType textType, String regex, TextParserMother... nextParsers) {
        this.textType = textType;
        this.regex = regex;
        this.nextParsers = nextParsers;
    }

    // TODO: split method on different parsers, especially WordParser
    public TextElementMother parse(String text) {
        List<TextElementMother> textElementList = new ArrayList<>();
        Arrays.stream(nextParsers).forEach(nextParser -> {
            String[] textElementValues = text.trim().split(regex);
//            if (textElementValues.length != 0 && !textElementValues[0].isEmpty()) {
            List<TextElementMother> childTextElementList = parse(textElementValues, nextParser);
            if (!childTextElementList.isEmpty()) {
                textElementList.addAll(childTextElementList);
            }
            //          }
        });

        return new TextElement(textType, textElementList);
    }

    private List<TextElementMother> parse(String[] textElementValues, TextParserMother nextParser) {
        List<TextElementMother> textElementList = new ArrayList<>();
        Arrays.stream(textElementValues).forEach(textElementValue -> {
            List<TextElementMother> childTextElementList = ((TextElement) nextParser.parse(textElementValue)).getTextElements();

            if (!childTextElementList.isEmpty()) {
                TextElement textElement = new TextElement(textType, childTextElementList);
                textElementList.add(textElement);
            }
        });

        return textElementList;
    }

}