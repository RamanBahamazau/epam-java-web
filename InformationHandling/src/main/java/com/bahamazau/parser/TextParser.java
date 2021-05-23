package com.bahamazau.parser;

import com.bahamazau.composite.TextType;

public abstract class TextParser {

    protected final String regex;

    protected TextType nextType;
    protected TextParser[] nextParsers;

    protected TextParser(TextType nextType, String regex, TextParser... nextParsers) {
        this.nextType = nextType;
        this.regex = regex;
        this.nextParsers = nextParsers;
    }

    protected TextParser(String regex, TextParser... nextParsers) {
        this.regex = regex;
        this.nextParsers = nextParsers;
    }

    protected abstract void parse(String text);

}
