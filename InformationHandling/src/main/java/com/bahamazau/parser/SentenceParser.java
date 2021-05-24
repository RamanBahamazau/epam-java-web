package com.bahamazau.parser;

import static com.bahamazau.composite.TextType.*;

public class SentenceParser extends TextParser {

    public SentenceParser(TextParser... nextParsers) {
        super(SENTENCE, "\\.\\s(?!\\d)|(?<!\\d)\\.\\s", nextParsers);
    }

}
