package com.bahamazau.composite.text.paragraph.sentence;

import com.bahamazau.composite.text.paragraph.sentence.token.Token;
import com.bahamazau.parser.TextParser;

public class Sentence implements TextParser {

    private static final String WORD_TEXT_REGEX = "\\s";

    private Long id;
    private Token[] tokens;

    public Sentence(Long id) {
        this.id = id;
        this.tokens = new Token[]{};
    }

    @Override
    public void parse(String text) {
    }
}
