package com.bahamazau.parser;

/**
 * Chain responsibility's builder.
 * Initialize parsers as default to avoid NullPointerExceptions.
 */
public class TextParserBuilder {

    private TextParserBuilder instance;

    private WordParser wordParser = new WordParser();
    private ExpressionParser expressionParser = new ExpressionParser();
    private TokenParser tokenParser = new TokenParser(expressionParser, wordParser);
    private SentenceParser sentenceParser = new SentenceParser(tokenParser);

    public TextParserBuilder getInstance() {
        if (instance == null) {
            instance = new TextParserBuilder();
        }

        return this.instance;
    }

    public TextParserBuilder withWordParser(WordParser wordParser) {
        this.wordParser = wordParser;
        return this;
    }

    public TextParserBuilder withExpressionParser(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
        return this;
    }

    public TextParserBuilder withTokenParser(TokenParser tokenParser) {
        this.tokenParser = tokenParser;
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
