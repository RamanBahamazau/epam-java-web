package com.bahamazau.parser;

import static com.bahamazau.composite.TextType.*;

public class SentenceParser extends TextParser {

    public SentenceParser(TokenParser... nextParsers) {
        super(TOKEN, "\\.\\s(?!\\d)|(?<!\\d)\\.\\s", nextParsers);
    }

    /**
     * Parse on expressions and words.
     *
     * @param text
     */
    @Override
    public void parse(String text) {

    }

}
