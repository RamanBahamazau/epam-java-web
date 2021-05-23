package com.bahamazau.parser;

public class TokenParser extends TextParser {

    protected TokenParser(TextParser... nextParsers) {
        super("\\s", nextParsers);
    }

    protected TokenParser() {
        super("\\s");
    }

    @Override
    protected void parse(String text) {

    }

}
