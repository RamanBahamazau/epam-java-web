package com.bahamazau.parser;

import static com.bahamazau.composite.TextType.*;

public class ExpressionParser extends TextParser {

    public ExpressionParser(TextParser... nextParsers) {
        super(EXPRESSION, "", nextParsers);
    }

    @Override
    protected void parse(String text) {

    }
}
