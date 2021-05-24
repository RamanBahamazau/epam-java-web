package com.bahamazau.parser;

/**
 * Chain responsibility's builder.
 * Initialize parsers as default to avoid NullPointerExceptions.
 */
public class TextParserBuilder {

    private TextParserBuilder instance;

    private ExpressionParser expressionParser = new ExpressionParser();
    private SentenceParser sentenceParser = new SentenceParser(expressionParser);

    public TextParserBuilder getInstance() {
        if (instance == null) {
            instance = new TextParserBuilder();
        }

        return this.instance;
    }

    public TextParserBuilder withExpressionParser(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
        return this;
    }

    public TextParserBuilder withSentenceParser(SentenceParser sentenceParser) {
        this.sentenceParser = sentenceParser;
        return this;
    }

    public TextParser build() {
        return new ParagraphParser(sentenceParser);
    }

}
