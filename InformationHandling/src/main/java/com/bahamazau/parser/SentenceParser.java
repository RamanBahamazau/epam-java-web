package com.bahamazau.parser;

import static com.bahamazau.composite.TextType.*;

public class SentenceParser extends TextParserMother {

    public SentenceParser(TextParserMother... nextParsers) {
        super(SENTENCE, "\\.\\s(?!\\d)|(?<!\\d)\\.\\s", nextParsers);
    }

}
