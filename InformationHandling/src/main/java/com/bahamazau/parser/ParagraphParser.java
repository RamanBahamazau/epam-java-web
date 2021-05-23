package com.bahamazau.parser;

import static com.bahamazau.composite.TextType.*;

public class ParagraphParser extends TextParser {

    ParagraphParser(SentenceParser nextParser) {
        super(PARAGRAPH, "(?m)(?=^\\s{4})", nextParser);
    }

    @Override
    public void parse(String text) {

    }

}
