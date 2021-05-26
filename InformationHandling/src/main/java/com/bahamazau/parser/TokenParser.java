package com.bahamazau.parser;

import static com.bahamazau.composite.TextType.*;

public class TokenParser extends TextParserMother {

    // TODO: find regex for expressions.
    public TokenParser(TextParserMother... nextParsers) {
        super(TOKEN, "[^a-zA-Z0-9]", nextParsers);
    }

}
