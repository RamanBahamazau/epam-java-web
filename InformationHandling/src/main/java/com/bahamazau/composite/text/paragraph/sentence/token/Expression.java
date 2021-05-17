package com.bahamazau.composite.text.paragraph.sentence.token;

import java.util.List;

public class Expression extends Token {

    private List<Word> wordList;

    public Expression(Long id, List<Character> symbolList, List<Word> wordList) {
        super(id, symbolList);
        this.wordList = wordList;
    }

}
