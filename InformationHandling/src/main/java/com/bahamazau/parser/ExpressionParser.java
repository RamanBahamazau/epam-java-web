package com.bahamazau.parser;

import static com.bahamazau.composite.TextType.*;

public class ExpressionParser extends TextParserMother {

    // TODO: find regex for expressions.
    public ExpressionParser(TextParserMother... nextParsers) {
        super(EXPRESSION, "[^a-zA-Z0-9]", nextParsers);
    }

}
