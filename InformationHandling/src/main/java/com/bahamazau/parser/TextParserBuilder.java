package com.bahamazau.parser;

/**
 * Chain responsibility's builder.
 * Initialize parsers as default to avoid NullPointerExceptions.
 */
public class TextParserBuilder {

    private WordParser wordParser = new WordParser();
    private TokenParser tokenParser = new TokenParser(wordParser);
    private SentenceParser sentenceParser = new SentenceParser(tokenParser);
    private ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

    public TextParserBuilder withWordParser(WordParser wordParser) {
        this.wordParser = wordParser;
        return this;
    }

    public TextParserBuilder withExpressionParser(TokenParser tokenParser) {
        this.tokenParser = tokenParser;
        return this;
    }

    public TextParserBuilder withSentenceParser(SentenceParser sentenceParser) {
        this.sentenceParser = sentenceParser;
        return this;
    }

    public TextParserBuilder withParagraphParser(ParagraphParser paragraphParser) {
        this.paragraphParser = paragraphParser;
        return this;
    }

    public TextParserMother build() {
        return new TextParser(paragraphParser);
    }

}
