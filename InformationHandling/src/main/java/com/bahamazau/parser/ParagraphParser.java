package com.bahamazau.parser;

import static com.bahamazau.composite.TextType.*;

public class ParagraphParser extends TextParserMother {

    ParagraphParser(SentenceParser nextParser) {
        super(PARAGRAPH, "(?m)(?=^\\s{4})", nextParser);
    }

}
