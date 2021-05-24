package com.bahamazau.parser;

import static com.bahamazau.composite.TextType.*;

public class ExpressionParser extends TextParser {

    // TODO: find regex for expressions.
    public ExpressionParser(TextParser... nextParsers) {
        super(EXPRESSION, "\\s", nextParsers);
    }

}
